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

    public Hospital readInputLines() {
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
                if(idx == 1){
                    try {
                        period = Integer.parseInt(line);
                    }catch (Exception e){
                        System.out.println("Input Error");
                        idx--;
                    }
                    continue;
                }
                String[] words = line.split(" ");
                if(words[0].equals("patient")){
                    if(words.length != 3){
                        System.out.println("Input Error");
                        idx--;
                        continue;
                    }
                    int tmpPatientPeriod = 0;
                    try {
                        tmpPatientPeriod = Integer.parseInt(words[2]);
                    }catch (Exception e){
                        System.out.println("Input Error");
                        idx--;
                        continue;
                    }
                    if(!patientName.isEmpty()){
                        pations.add(new Patient(patientName,patientPeriod,sensors));
                    }
                    patientPeriod = tmpPatientPeriod;
                    patientName = words[1];
                    sensors = new ArrayList<>();
                    continue;
                }
                if (words.length != 5) {
                    System.out.println("Input Error");
                    idx--;
                    continue;
                }
                if(patientName.isEmpty()){
                    System.out.println("Input Error");
                    idx--;
                    continue;
                }
                float lowBound = 0;
                float upBound = 0;
                try {
                    lowBound = Float.parseFloat(words[3]);
                    upBound = Float.parseFloat(words[4]);
                }catch (Exception e){
                    System.out.println("Input Error");
                    idx--;
                    continue;
                }
                String type = words[0];
                String name = words[1];
                List<Float> dataList = readDataPath(words[2]);
                Sensor newSensor = new Sensor(type,name,upBound,lowBound,dataList);
                sensors.add(newSensor);
            }
            pations.add(new Patient(patientName,patientPeriod,sensors));
            return new Hospital(period,pations);
        } catch (IOException e) {
            e.printStackTrace();
            return new Hospital(0,new ArrayList<>());
        }
    }

}
