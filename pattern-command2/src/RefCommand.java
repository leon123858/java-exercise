public class RefCommand implements Command {
    private final String declaration;
    private final String referencedVariable;
    private final String variable;
    public RefCommand(String variable, String referencedVariable, String declaration) {
        this.referencedVariable = referencedVariable;
        this.variable = variable;
        this.declaration = declaration;
    }

    @Override
    public void print() {
        System.out.println(declaration);
    }

    @Override
    public void generate() {
        System.out.println(variable + " = " + referencedVariable);
    }

    @Override
    public void type() {
        System.out.println("VariableRefNode");
    }
}
