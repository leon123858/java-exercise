public class AssignCommand implements Command {
    private final String declaration;
    private final String variableName;
    private final int constantValue;
    public AssignCommand(String variableName, int constantValue, String declaration) {
        this.variableName = variableName;
        this.constantValue = constantValue;
        this.declaration = declaration;
    }

    @Override
    public void print() {
        System.out.println(declaration);
    }

    @Override
    public void generate() {
        System.out.println(variableName + " = " + constantValue);
    }

    @Override
    public void type() {
        System.out.println("AssignmentNode");
    }
}
