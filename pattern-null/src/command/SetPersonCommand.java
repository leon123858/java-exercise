package command;

import utils.AbstractPerson;
import utils.NullPerson;
import utils.Person;

import java.util.ArrayList;

public class SetPersonCommand extends SetCommand{
    public SetPersonCommand(String[] args) {
        super(args);
    }

    /**
     * @param dataArr ArrayList<AbstractPerson>
     */
    @Override
    public void execute(ArrayList<AbstractPerson> dataArr) {
        AbstractPerson person;
        // args is [Name] [Job] [Weight] [Height]
        try {
            // check weight and height is int bigger than 0
            int weight = Integer.parseInt(this.args[2]);
            int height = Integer.parseInt(this.args[3]);
            if (weight <= 0 || height <= 0) {
                throw new Exception();
            }
            person = new Person();
            person.setName(this.args[0]);
            person.setJob(this.args[1]);
            person.setWeight(weight);
            person.setHeight(height);
        } catch (Exception e) {
            person = new NullPerson();
            person.setName(this.args[0]);
        }
        this.setPerson(person, dataArr);
    }

    public void setPerson(AbstractPerson person, ArrayList<AbstractPerson> personArr) {
        super.setData(person, personArr);
    }
}
