import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {
    private String filePath = "";

    public TextFileReader(String filePath) {
        this.filePath = filePath;
    }

    private List<Float> readDataPath(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            List<Float> dataList = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
                dataList.add(Float.parseFloat(line));
            }
            return  dataList;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public FakeEnv readInputLines() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int idx = 0;
            int period = 0;
            List<Sensor> sensors = new ArrayList<>();
            List<Patient> pations = new ArrayList<>();
            String patientName = "";
            int patientPeriod = 0;
            while ((line = reader.readLine()) != null) {
                idx++;
//                System.out.println(line);
                if(idx == 1){
                    period =Integer.parseInt(line);
                    continue;
                }
                String[] words = line.split(" ");
                if(words[0].equals("patient")){
                    if(!patientName.isEmpty()){
                        pations.add(new Patient(patientName,patientPeriod,sensors));
                    }
                    patientName = words[1];
                    patientPeriod = Integer.parseInt(words[2]);
                    sensors = new ArrayList<>();
                    continue;
                }
                String type = words[0];
                String name = words[1];
                List<Float> dataList = readDataPath(words[2]);
                int lowBound = Integer.parseInt(words[3]);
                int upBound = Integer.parseInt(words[4]);
                Sensor newSensor = new Sensor(type,name,upBound,lowBound,dataList);
                sensors.add(newSensor);
                continue;
            }
            pations.add(new Patient(patientName,patientPeriod,sensors));
            return new FakeEnv(period,pations);
        } catch (IOException e) {
            e.printStackTrace();
            return new FakeEnv(0,new ArrayList<>());
        }
    }

}
