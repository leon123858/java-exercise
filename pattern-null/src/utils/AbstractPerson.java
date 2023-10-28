package utils;

public abstract class AbstractPerson {
    String name;
    String job;
    int weight;
    int height;

    public abstract void setHeight(int height);
    public abstract void setJob(String job);
    public abstract void setName(String name);
    public abstract void setWeight(int weight);
    public abstract int getHeight();
    public abstract int getWeight();
    public abstract String getJob();
    public abstract String getName();
}
