package infixparser;

import org.junit.jupiter.api.Test;

public class CalculadoraTests {
    @Test
    public void shouldReturnArithmeticError() {
        try {
            Calculadora.getInstance().evaluate("1 0 /", new ArrayListStack<Integer>()); // Se usa ArrayListStack solo como prueba
        } catch (ArithmeticException e){
            assert(e.getMessage().equals("División por cero")); // Mensaje que pusimos nosotros de error
        }
    }

    @Test
    public void shouldReturnIllegalArgumentException() {
        try {
            Calculadora.getInstance().evaluate("1 2 R", new ArrayListStack<Integer>());
        } catch (IllegalArgumentException e){
            assert(e.getMessage().equals("Operador desconocido: R"));
        }
    }

    @Test
    public void shouldReturnInsufficientOperands() {
        try {
            Calculadora.getInstance().evaluate("1 +", new ArrayListStack<Integer>());
        } catch (IllegalArgumentException e){
            assert(e.getMessage().equals("Expresión inválida"));
        }
    }
}
