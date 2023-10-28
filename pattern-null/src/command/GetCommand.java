package command;

import utils.AbstractPerson;

import java.util.ArrayList;

public abstract class GetCommand extends Command {

    public GetCommand(String[] args) {
        super(args);
    }

    private boolean isIncludePerson(String name, String[] nameList) {
        for (String n : nameList) {
            if (n.equals(name)) {
                return true;
            }
        }
        return false;
    }

    protected ArrayList<AbstractPerson> getTargetPersons(ArrayList<AbstractPerson> dataArr) {
        ArrayList<AbstractPerson> targetPersons = new ArrayList<>();
        for (AbstractPerson person : dataArr) {
            if (this.isIncludePerson(person.getName(), this.args)) {
                targetPersons.add(person);
            }
        }
        return targetPersons;
    }
}
