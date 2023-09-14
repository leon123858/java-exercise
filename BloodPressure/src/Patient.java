import java.util.ArrayList;
import java.util.List;

public class Patient {
    public int period = 0;
    public String name = "";
    public List<Sensor>  sensors = new ArrayList<>();
    Patient(String _name,int _period, List<Sensor> _sensors){
        period = _period;
        name = _name;
        sensors = _sensors;
    }
}
