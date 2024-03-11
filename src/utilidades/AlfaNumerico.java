
package utilidades;

import java.util.Scanner;

/**
 *
 * @author dam
 */
public class AlfaNumerico {
    public static String pedirAlfaNumérico(String mensaje){
        Scanner entrada=new Scanner(System.in);
        System.out.println(mensaje);
        String cadena=entrada.nextLine().trim();
        while(cadena.isEmpty()){
            System.out.println("Error. No puede ser una cadena vacía");
            System.out.println(mensaje);
            cadena=entrada.nextLine().trim();
        }
        return cadena;
    }
    public static Fecha pedirFecha(String mensaje){
        Fecha fecha=new Fecha();
        String fechaIntroducida = AlfaNumerico.pedirAlfaNumérico(mensaje);
        while (!fecha.comprobarFecha(fechaIntroducida)){
            System.out.println("Fecha incorrecta. La fecha no cumple el formato requerido.");
            fechaIntroducida = AlfaNumerico.pedirAlfaNumérico(mensaje);
        }
        return fecha;
    }
    
}
