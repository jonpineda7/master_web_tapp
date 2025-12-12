package app.support.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ActualizarBuildVersion {
    public static void main(String[] args) {
        ActualizarBuildVersion actualizador = new ActualizarBuildVersion();
        //actualizador.actualizarBuild();
    }

    /*public void actualizarBuild() {
        String filePath = "src/test/resources/build.properties";

        // Lee el archivo de propiedades
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Obtiene el valor actual de build_version
        String buildVersionStr = properties.getProperty("build_version");
        int buildVersion = Integer.parseInt(buildVersionStr);

        // Incrementa el valor de build_version en uno
        buildVersion++;

        // Actualiza el valor en las propiedades
        properties.setProperty("build_version", String.format("%04d", buildVersion));

        // Guarda las propiedades actualizadas en el archivo
        try (FileOutputStream output = new FileOutputStream(filePath)) {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprime el nuevo valor de build_version
        System.out.println("Nuevo build_version: " + properties.getProperty("build_version"));
    }*/
}
