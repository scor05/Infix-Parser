package infixparser;

public class StackFactory {
    /**
     * 
     * @param type
     * @return
     */
    public static IStack<Integer> getStack(String type) {
        switch (type.toLowerCase()) {
            case "arraylist": return new ArrayListStack<>();
            case "vector": return new VectorStack<>();
            default: throw new IllegalArgumentException("Tipo de Stack no válido: " + type);
        }
    }
/**
 * 
 * @param type
 * @return
 */
    public static IStack<Integer> getListStack(String type) {
        switch (type.toLowerCase()) {
            case "single": return new ListStack<>(new SingleLinkedList<>());
            case "double": return new ListStack<>(new DoubleLinkedList<>());
            default: throw new IllegalArgumentException("Tipo de Lista no válido: " + type);
        }
    }
}
