import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        int op = 0;
        float amount = 0;
        String base;
        String target;
        Scanner lectura = new Scanner(System.in);
        ConsultaConversion consulta = new ConsultaConversion();

        while (op != 7) {
            System.out.println("**************************************************\n" +
                    "Sea bienvenido/a al Conversor de Moneda =]\n" +
                    "\n" +
                    "1) Dólar => Peso argentino\n" +
                    "2) Peso argentino => Dólar\n" +
                    "3) Dólar => Real brasileño\n" +
                    "4) Real brasileño => Dólar\n" +
                    "5) Dólar => Peso colombiano\n" +
                    "6) Peso colombiano => Dólar\n" +
                    "7) Salir\n" +
                    "\n" +
                    "Elija una opción válida:\n" +
                    "**************************************************\n");

            op = lectura.nextInt();

            if (op != 7) {
                System.out.println("Ingrese la cantidad de dinero que desea convertir:");
                amount = lectura.nextInt();
            }

            switch (op) {
                case 1:
                    base = "USD";
                    target = "ARS";
                    procesarOpcionDeMoneda(base, target, amount, consulta);
                    break;
                case 2:
                    base = "ARS";
                    target = "USD";
                    procesarOpcionDeMoneda(base, target, amount, consulta);
                    break;
                case 3:
                    base = "USD";
                    target = "BRL";
                    procesarOpcionDeMoneda(base, target, amount, consulta);
                    break;
                case 4:
                    base = "BRL";
                    target = "USD";
                    procesarOpcionDeMoneda(base, target, amount, consulta);
                    break;
                case 5:
                    base = "USD";
                    target = "COP";
                    procesarOpcionDeMoneda(base, target, amount, consulta);
                    break;
                case 6:
                    base = "COP";
                    target = "USD";
                    procesarOpcionDeMoneda(base, target, amount, consulta);
                    break;
                case 7:
                    System.out.println("Gracias por usar nuestro programa!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción entre 1 y 7.");
                    break;

            }
        }
    }

    private static void procesarOpcionDeMoneda(String base, String target, float amount, ConsultaConversion consulta) {
        try {
            Conversion conversion = consulta.buscarConversion(base, target, amount);
            System.out.println(amount+" "+base+" a "+target+" es: "+ conversion.conversion_result()+ " "+target);
        } catch (NumberFormatException e) {
            System.out.println("Alguna moneda no fue encontrada!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Hubo un error");
        }
    }

}
