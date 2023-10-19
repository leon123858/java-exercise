import java.util.List;

public class Quiz {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("沒有指定參數。");
            return;
        }
        // read input file
        TextFileReader reader = new TextFileReader(args[0]);
        Hospital env = reader.readInputLines();
        // monitor
        for(int i=0;i<=env.total_period;i++){
            List<Patient> patients = env.patients;
            for (Patient item : patients) {
                if(i % item.period == 0){
                    // need check
                    for (Sensor sensor : item.sensors) {
                        Float curData = sensor.getData();
                        if(curData < -0){
                            System.out.printf("[%d] %s fails\n", i, sensor.name);
                            continue;
                        }
                        if(curData > sensor.upBound || curData < sensor.lowBound){
                            System.out.printf("[%d] %s is in danger! Cause: %s %.1f\n", i, item.name,sensor.name,curData);
                            continue;
                        }
                    }
                }
            }
        }
        // log
        Hospital newEnv = reader.readInputLines();
        List<Patient> patients = newEnv.patients;
        for (Patient item : patients) {
            System.out.printf("%s %s\n", "patient", item.name);
            for (Sensor sensor : item.sensors) {
                System.out.printf("%s %s\n", sensor.type, sensor.name);
                for(int i=0;i<=newEnv.total_period;i++){
                    if(i % item.period == 0){
                        System.out.printf("[%d] %.1f\n", i, sensor.getData());
                    }
                }
            }
        }

    }
}
