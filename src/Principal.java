import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaConversion consulta = new ConsultaConversion();
        System.out.println("Escriba el numero de la pelicula de Star Wars que quiere consultar:");
        try{
            var numeroDePelicula = Integer.valueOf(lectura.nextLine());
            Conversion pelicula = consulta.buscarConversion(numeroDePelicula);
            System.out.println(pelicula);
        } catch (NumberFormatException e){
            System.out.println("Número no encontrado "+e.getMessage());
        } catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}
