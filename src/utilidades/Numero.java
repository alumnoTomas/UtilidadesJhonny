
package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Numero {

    public static int pedirNumeroEnteroPositivo(String mensaje, int liminiteInferior) {
        Scanner entrada = new Scanner(System.in);
        int numero = 0;
        boolean mal = true;
        while (mal) {
            try {
                System.out.println(mensaje);
                numero = entrada.nextInt();
                if (numero < liminiteInferior) {
                    System.out.println("Deber ser mayor que " + liminiteInferior);
                } else {
                    mal = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error, no es un numero válido");
                entrada.nextLine();
            }

        }
        return numero;
    }

    public static int pedirNumeroEnteroPositivo(String mensaje, int liminiteInferior, int limiteSuperior) {
        Scanner entrada = new Scanner(System.in);
        int numero = 0;
        boolean mal = true;
        while (mal) {
            try {
                System.out.println(mensaje);
                numero = entrada.nextInt();
                if (numero < liminiteInferior | numero > limiteSuperior) {
                    System.out.println("Deber ser mayor que " + liminiteInferior + " e inferior a " + limiteSuperior);
                } else {
                    mal = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error, no es un numero válido");
                entrada.nextLine();
            }

        }
        return numero;
    }

    public static float pedirNumeroRealPositivo(String mensaje, int liminiteInferior) {
        Scanner entrada = new Scanner(System.in);
        float numero = 0;
        boolean mal = true;
        while (mal) {
            try {
                System.out.println(mensaje);
                numero = entrada.nextFloat();
                if (numero < liminiteInferior) {
                    System.out.println("Deber ser mayor que " + liminiteInferior);
                } else {
                    mal = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error, no es un numero válido");
                entrada.nextLine();
            }

        }
        return numero;
    }

    public static float pedirNumeroRealPositivo(String mensaje, int liminiteInferior, int limiteSuperior) {
        Scanner entrada = new Scanner(System.in);
        float numero = 0;
        boolean mal = true;
        while (mal) {
            try {
                System.out.println(mensaje);
                numero = entrada.nextFloat();
                if (numero < liminiteInferior || numero > limiteSuperior) {
                    System.out.println("Deber ser mayor que " + liminiteInferior + " e inferior" + limiteSuperior);
                } else {
                    mal = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error, no es un numero válido");
                entrada.nextLine();
            }

        }
        return numero;
    }

    public static float pedirNumeroReal(String mensaje) {
        Scanner entrada = new Scanner(System.in);
        float numero = 0;
        boolean mal = true;
        while (mal) {
            try {
                System.out.println(mensaje);
                numero = entrada.nextFloat();

                mal = false;

            } catch (InputMismatchException ex) {
                System.out.println("Error, no es un numero");
                entrada.nextLine();
            }

        }
        return numero;
    }
}
