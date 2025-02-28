package infixparser;

import org.junit.jupiter.api.Test;

public class CalculadoraTests {
    @Test
    public void shouldReturnArithmeticError() {
        try {
            Calculadora.getInstance().evaluate("1 0 /");
        } catch (ArithmeticException e){
            assert(e.getMessage().equals("División por cero")); // Mensaje que pusimos nosotros de error
        }
    }

    @Test
    public void shouldReturnIllegalArgumentException() {
        try {
            Calculadora.getInstance().evaluate("1 2 R");
        } catch (IllegalArgumentException e){
            assert(e.getMessage().equals("Operador desconocido: R"));
        }
    }

    @Test
    public void shouldReturnInsufficientOperands() {
        try {
            Calculadora.getInstance().evaluate("1 +");
        } catch (IllegalArgumentException e){
            assert(e.getMessage().equals("Expresión inválida"));
        }
    }
}
