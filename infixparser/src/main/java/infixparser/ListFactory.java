package infixparser;
import infixparser.DoubleLinkedList;
import infixparser.IList;

public class ListFactory {
    /**
     *  
     * @param type
     * @return
     */
    public static IList<Integer> getList(String type) {
        return switch (type.toLowerCase()) {
            case "single" -> new SingleLinkedList<>();
            case "double" -> new DoubleLinkedList<>();
            default -> new SingleLinkedList<>();
        };
    }
}
