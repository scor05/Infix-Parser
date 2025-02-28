package infixparser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StackImplementationTests {
    @Test
    public void shouldReturnArrayListStackResult() {
        int resultado = Calculadora.getInstance().evaluate("1 2 +", new ArrayListStack<Integer>());
        assertEquals(resultado, 3);
    }

    @Test
    public void shouldReturnVectorStackResult() {
        int resultado = Calculadora.getInstance().evaluate("1 2 +", new VectorStack<Integer>());
        assertEquals(resultado, 3);
    }

    @Test
    public void shouldReturnSingleLinkedListStackResult() {
        @SuppressWarnings("static-access")
        int resultado = Calculadora.getInstance().evaluate("1 2 +", new StackFactory().getListStack("single"));
        assertEquals(resultado, 3);
    }

    @Test
    public void shouldReturnDoubleLinkedListStackResult() {
        @SuppressWarnings("static-access")
        int resultado = Calculadora.getInstance().evaluate("1 2 +", new StackFactory().getListStack("double"));
        assertEquals(resultado, 3);
    }
}
