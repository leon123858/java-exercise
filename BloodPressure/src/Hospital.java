import java.util.ArrayList;
import java.util.List;

public class Hospital {
    public int total_period = 0;
    public List<Patient> patients = new ArrayList<>();
    Hospital(int _total_period, List<Patient> _patients){
        total_period = _total_period;
        patients = _patients;
    }
}
