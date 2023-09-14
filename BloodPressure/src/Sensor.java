import java.util.ArrayList;
import java.util.List;

public class Sensor {
    public int curDataId = 0;
    public String type = "";
    public String name = "";
    public float upBound = 0;
    public float lowBound = 0;
    public List<Float> dataList = new ArrayList<>();
    Sensor(String _type, String _name,float up,float low,List<Float> _dataList){
        type = _type;
        name = _name;
        upBound = up;
        lowBound = low;
        dataList = _dataList;
    }

    public Float getData(){
        if(curDataId == dataList.size()){
            return (float) -1.0;
        }
        return  dataList.get(curDataId++);
    }
}
