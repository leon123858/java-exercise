public class Counter {
    public int count = 5;

    Counter(int initNum){
        count = initNum;
    }

    public int add(){
        return ++count;
    }
}
