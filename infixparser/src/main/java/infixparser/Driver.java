package infixparser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Clase principal para la ejecución y gestión del programa.
 */
public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la implementación de Stack: ");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista (SingleLinked / DoubleLinked)");
        System.out.print("Ingrese el número de la opción que desee: \nR/ ");
        int stackChoice = scanner.nextInt();
        scanner.nextLine(); 
        IStack<Integer> stack;
        if (stackChoice == 3) {
            System.out.println("Seleccione la implementación de Lista:");
            System.out.println("1. SingleLinkedList");
            System.out.println("2. DoubleLinkedList");
            System.out.print("Ingrese el número de la opción que desee: \nR/ ");
            int listChoice = scanner.nextInt();
            scanner.nextLine();

            stack = StackFactory.getListStack(listChoice == 1 ? "single" : "double");
        } else {
            stack = StackFactory.getStack(stackChoice == 1 ? "arraylist" : "vector");
        }
        

        // Leer un archivo y procesa la informacion
        try {
            List<String> lines = Files.readAllLines(Paths.get("datos.txt"));
            int i = 1;
            for (String infix : lines) {
                if (!infix.trim().isEmpty()) {
                    String postfix = convertToPostfix(infix.trim());
                    try {
                        int result = Calculadora.getInstance().evaluate(postfix, stack);
                        System.out.println("Línea #" + i + ":");
                        System.out.println("Infix: " + infix);
                        System.out.println("Postfix: " + postfix);
                        System.out.println("Resultado: " + result);
                        System.out.println("-------------------------");
                        i++;
                    } catch (ArithmeticException e) {
                        System.out.println("Error: División por cero en la expresión: " + infix);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: Expresión inválida: " + infix);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: No se pudo leer el archivo datos.txt.");
        }
    }

    /**
     * Convierte de infix a posfix
     * @param infix La expresión en notación infix.
     * @return La expresión en notación postfix.
     */
    public static String convertToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        StringBuilder numberBuffer = new StringBuilder();

        for (char token : infix.toCharArray()) {
            if (Character.isDigit(token)) {
                numberBuffer.append(token);
            } else {
                if (numberBuffer.length() > 0) {
                    postfix.append(numberBuffer).append(" ");
                    numberBuffer.setLength(0);
                }

                if (token == '(') {
                    stack.push(token);
                } else if (token == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postfix.append(stack.pop()).append(" ");
                    }
                    if (!stack.isEmpty()) stack.pop();
                } else {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postfix.append(stack.pop()).append(" ");
                    }
                    stack.push(token);
                }
            }
        }

        if (numberBuffer.length() > 0) {
            postfix.append(numberBuffer).append(" ");
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }
}
