import java.util.List;

public class Main {
    public static void main(String[] args) {
        // initialize a builder
        ImmutableObject.Builder builder = new ImmutableObject.Builder();
        builder.setId(1)
                .setName("Immutable Object")
                .setList(List.of("a", "b", "c"));
        // build an immutable object
        ImmutableObject immutableObject = builder.build();
        // print the object's id
        System.out.println(immutableObject.getId());
        // print the object's name
        System.out.println(immutableObject.getName());
        // print the object's list
        System.out.println(immutableObject.getList());
    }
}