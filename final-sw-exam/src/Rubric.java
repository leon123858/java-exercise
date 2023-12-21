import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Rubric {
    private final List<RubricDescription> descriptions;

    public Rubric(List<RubricDescription> descriptions) {
        this.descriptions = descriptions;
    }

    public List<RubricDescription> getDescriptions() {
        return descriptions;
    }

    public List<Criterion> getCriteria() {
        var criteria = new HashSet<Criterion>();

        for (var rubric : descriptions) {
            criteria.add(rubric.getCriterion());
        }

        return new LinkedList<>(criteria);
    }

    public List<Level> getLevels() {
        var levels = new HashSet<Level>();

        for (var rubric : descriptions) {
            levels.add(rubric.getLevel());
        }

        return new LinkedList<>(levels);
    }

    public void PrintRubric() {
        for (var rubric : descriptions) {
            System.out.println("(" + rubric.getLevel().getName() + "," + rubric.getCriterion().getName() + ") " + rubric.getDescription());
        }
    }
}
