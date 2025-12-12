package app.support.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FechaUtil {

    // Obtener la fecha actual en formato "YYYY-MM-DD"
    public static String obtenerFechaActual() {
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    // Restar días a una fecha y retornar la nueva fecha en formato "YYYY-MM-DD"
    public static String restarDias(String fecha, int dias) {
        LocalDate fechaOriginal = LocalDate.parse(fecha);
        LocalDate nuevaFecha = fechaOriginal.minusDays(dias);
        return nuevaFecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    // Sumar días a una fecha y retornar la nueva fecha en formato "YYYY-MM-DD"
    public static String sumarDias(String fecha, int dias) {
        LocalDate fechaOriginal = LocalDate.parse(fecha);
        LocalDate nuevaFecha = fechaOriginal.plusDays(dias);
        return nuevaFecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String restarMeses(String fecha, int meses) {
        LocalDate fechaOriginal = LocalDate.parse(fecha);
        LocalDate nuevaFecha = fechaOriginal.minusMonths(meses);
        return nuevaFecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String sumarMeses(String fecha, int meses) {
        LocalDate fechaOriginal = LocalDate.parse(fecha);
        LocalDate nuevaFecha = fechaOriginal.plusMonths(meses);
        return nuevaFecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String restarAnios(String fecha, int anios) {
        LocalDate fechaOriginal = LocalDate.parse(fecha);
        LocalDate nuevaFecha = fechaOriginal.minusYears(anios);
        return nuevaFecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String sumarAnios(String fecha, int anios) {
        LocalDate fechaOriginal = LocalDate.parse(fecha);
        LocalDate nuevaFecha = fechaOriginal.plusYears(anios);
        return nuevaFecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    // Obtener la diferencia en días entre dos fechas
    public static int diferenciaEnDias(String fecha1, String fecha2) {
        LocalDate date1 = LocalDate.parse(fecha1);
        LocalDate date2 = LocalDate.parse(fecha2);
        return (int) Math.abs(date1.until(date2).getDays());
    }

}
