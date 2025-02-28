package infixparser;

import org.junit.jupiter.api.Test;

public class StackImplementationTests {
    @Test
    public void shouldReturnArrayListStackResult() {
        IStack<Integer> stack = new ArrayListStack<>();
        Calculadora.getInstance().evaluate("1 2 + 3 4 * +", stack);
    }
}
