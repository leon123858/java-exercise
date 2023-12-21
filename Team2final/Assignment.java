public class Assignment {
    //    private final String id;
    private final Rubric rubric;

    public Assignment(String id, Rubric rankingCriterion) {
//        this.id = id;
        this.rubric = rankingCriterion;
    }

//    public String getId() {
//        return id;
//    }

    public Rubric getRubric() {
        return rubric;
    }
}
