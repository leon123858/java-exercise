import java.util.List;

public class Rubric {
    private final List<RubricDescription> descriptions;
    private final List<Criterion> criterionList;

    public Rubric(List<RubricDescription> descriptions, List<Criterion> criterionList) {
        this.descriptions = descriptions;
        this.criterionList = criterionList;
    }

//    public List<RubricDescription> getDescriptions() {
//        return descriptions;
//    }

    public List<Criterion> getCriteria() {
        return criterionList;
    }

//    public List<Level> getLevels() {
//        var levels = new HashSet<Level>();
//
//        for (var rubric : descriptions) {
//            levels.add(rubric.getLevel());
//        }
//
//        return new LinkedList<>(levels);
//    }

    public void PrintRubric() {
        for (var rubric : descriptions) {
            System.out.println("(" + rubric.getCriterion().getName() + "," + rubric.getLevel().getName() + ") " + rubric.getDescription());
        }
    }
}
