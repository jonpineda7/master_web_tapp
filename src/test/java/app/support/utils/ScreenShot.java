package app.support.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenShot {
    // Método para tomar la captura de pantalla
    public void tomarCapturaDePantalla(WebDriver driver, String rutaArchivo) {
        try {
            // Convierte el WebDriver a TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            // Toma la captura de pantalla como un archivo
            File capturaPantalla = screenshot.getScreenshotAs(OutputType.FILE);

            // Copia el archivo de captura de pantalla al destino especificado
            FileUtils.copyFile(capturaPantalla, new File(rutaArchivo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
