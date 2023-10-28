package command;

import utils.AbstractPerson;

import java.util.ArrayList;

public class GetJobCommand extends GetCommand {

    public GetJobCommand(String[] args) {
        super(args);
    }

    /**
     * @param dataArr ArrayList<AbstractPerson>
     * @return String
     */
    public String getJob(ArrayList<AbstractPerson> dataArr) {
        for (AbstractPerson person : dataArr) {
            if (person.getName().equals(this.args[0])) {
                return person.getJob();
            }
        }
        return  "Not found";
    }

    @Override
    public void execute(ArrayList<AbstractPerson> dataArr) {
        System.out.println(this.getJob(dataArr));
    }
}
