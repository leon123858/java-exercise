package utils;

public class Person extends AbstractPerson{
    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public String getJob() {
        return this.job;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
