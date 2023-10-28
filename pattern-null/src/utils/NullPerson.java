package utils;

public class NullPerson extends AbstractPerson{

    /**
     * @param height
     */
    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @param job
     */
    @Override
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param weight
     */
    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return
     */
    @Override
    public int getHeight() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public int getWeight() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public String getJob() {
        return "Unknown";
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }
}
