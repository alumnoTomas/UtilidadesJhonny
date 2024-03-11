package utilidades;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

    private int dia;
    private int mes;
    private int anno;

    private final static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final static String[] nombreMes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    /**
     * constructor. Guarda la fecha de hoy
     */
    public Fecha() {
        //para coger la fecha del sistema 
        Calendar hoy = new GregorianCalendar();
        dia = hoy.get(Calendar.DAY_OF_MONTH);
        mes = hoy.get(Calendar.MONTH);
        anno = hoy.get(Calendar.YEAR);
    }

    public Fecha(int dia, int mes, int anno) {
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
    }

    public static int[] getDiasMes() {
        return diasMes;
    }

    public static String[] getNombreMes() {
        return nombreMes;
    }

    /**
     *
     * @param fechaIntroducida
     * @return
     */
    public boolean comprobarFecha(String fechaIntroducida) {
        boolean fechaCorrectamenteIntroducida;
        String[] fechaDividida;
        fechaDividida = fechaIntroducida.split("/");
        if (fechaDividida.length != 3) {
            fechaCorrectamenteIntroducida = false;
        } else {
            try {
                dia = Integer.parseInt(fechaDividida[0]);
                mes = Integer.parseInt(fechaDividida[1]) - 1;//Lo guardamos restando menos uno para que coincida con la posicion en el array
                anno = Integer.parseInt(fechaDividida[2]);
                if (mes < 0 || mes > 11) {
                    fechaCorrectamenteIntroducida = false;
                } else if (dia < 1 || dia > diasMes[mes]) {
                    fechaCorrectamenteIntroducida = false;
                } else {
                    fechaCorrectamenteIntroducida = true;
                }
            } catch (NumberFormatException ex) {
                fechaCorrectamenteIntroducida = false;
            }
        }

        return fechaCorrectamenteIntroducida;
    }

    //calcular años que han pasado desde la fecha hasta la fecha actual
    public int calcularAnnos() {
        Fecha fechaActual = new Fecha(); //instanciamos la clase fecha con la fecha actual
        int annosDiferencia = fechaActual.getAnno() - anno;

        if (fechaActual.getMes() < mes || (fechaActual.getMes() == mes && fechaActual.getDia() < dia)) {
            annosDiferencia--;
        }

        return annosDiferencia;
    }

    public int calcularPolienios(int rangoAnnos) {
        return calcularAnnos() / rangoAnnos;
    }

    //Calcular la fecha de vencimiento de una factura con los dias de vencimentos dados
    public Fecha calcularFechaVencimiento(int diasVencimiento) {
        Fecha fechaVencimiento = new Fecha(dia, mes, anno);
        int dias = diasVencimiento + fechaVencimiento.getDia();

        while (dias > diasMes[fechaVencimiento.getMes()]) {

            dias = dias - diasMes[fechaVencimiento.getMes()];
            fechaVencimiento.setMes(fechaVencimiento.getMes() + 1);

            if (fechaVencimiento.getMes() > 11) {
                fechaVencimiento.setAnno(fechaVencimiento.getAnno() + 1);
                fechaVencimiento.setMes(0);
            }

            fechaVencimiento.setDia(dias);
        }

        return fechaVencimiento;
    }

    public void establecerEnMesProximo() {
        mes++;
        if (mes > 11) {
            anno++;
            mes = 0;
        }
    }

    public String fechaCompleta() {
        return dia + "/" + (mes + 1) + "/" + anno;//está guardada la posición y no el numero del mes exacto 
    }

    public String fechaCompletaMesLetra() {
        return dia + "/" + nombreMes[mes] + "/" + anno;
    }

    public int calcularOrden() {
        int orden = 0;
        for (int mesX = 0; mesX < mes; mesX++) {
            orden = orden + diasMes[mesX];
        }
        orden = orden + dia;
        return orden;
    }

    /*devuelve 0 si son iguales
    devuelve 1 si la que llama es mayor que la fecha a comparar
    devuelve -1 si la que llama es menor que la fecha a comparar*/
    /**
     *
     * @param fechaAComparar
     * @return devuelve 0 si son iguales devuelve 1 si la que llama es mayor que
     * la fecha a comparar devuelve -1 si la que llama es menor que la fecha a
     * comparar
     */
    public int compararFechas(Fecha fechaAComparar) {
        int resultado = 0;
        if (anno > fechaAComparar.getAnno()) {
            resultado = 1;
        } else if (anno < fechaAComparar.getAnno()) {
            resultado = -1;
        } else if (mes > fechaAComparar.getMes()) {
            resultado = 1;
        } else if (mes < fechaAComparar.getMes()) {
            resultado = -1;
        } else if (dia > fechaAComparar.getDia()) {
            resultado = 1;
        } else if (dia < fechaAComparar.getDia()) {
            resultado = -1;
        }
        return resultado;
    }

    public int getMes() {
        return mes;
    }

    public int getAnno() {
        return anno;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

}//fin clase fecha
