package app.support.utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Yaml {
    private static String pathFile;
    private static String basepath = "C:\\Users\\soportepc\\Documents\\QA\\gascox-caja-magallanes\\data\\";
    public Yaml(String tagFile) {
        pathFile = getPathFile(tagFile);
    }

    private String getPathFile(String tag) {
        HashMap<String, String> pathsFile = new HashMap<String, String>();
        pathsFile.put("pathlogs", basepath + "pathlogs.yml");
        pathsFile.put("config", basepath + "config.yml");

        return pathsFile.get(tag);
    }

    public Map<String, Map<String, String>> getFile() throws FileNotFoundException {

        org.yaml.snakeyaml.Yaml yaml = new org.yaml.snakeyaml.Yaml();

        Map<String, Map<String, String>> values = yaml
                .load(new FileInputStream(new File(pathFile)));

        return values;

    }

    public String getUserName () {

        File yamlFile = new File(System.getProperty("user.dir"), "browserstack.yml");

        // Cargar el archivo YAML
        Map<String, Object> yamlData;
        try (InputStream inputStream = new FileInputStream(yamlFile)) {
            org.yaml.snakeyaml.Yaml yaml = new org.yaml.snakeyaml.Yaml();
            yamlData = yaml.load(inputStream);

            // Verificar que yamlData no sea nulo
            if (yamlData == null) {
                System.out.println("Los datos del archivo YAML son nulos.");
                yamlData = new LinkedHashMap<>(); // Crear un nuevo mapa si el archivo está vacío
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Mantener los valores existentes de los campos clave
        String userName = (String) yamlData.get("userName");
        return userName;
    }

    public String getAccessKey () {

        File yamlFile = new File(System.getProperty("user.dir"), "browserstack.yml");

        // Cargar el archivo YAML
        Map<String, Object> yamlData;
        try (InputStream inputStream = new FileInputStream(yamlFile)) {
            org.yaml.snakeyaml.Yaml yaml = new org.yaml.snakeyaml.Yaml();
            yamlData = yaml.load(inputStream);

            // Verificar que yamlData no sea nulo
            if (yamlData == null) {
                System.out.println("Los datos del archivo YAML son nulos.");
                yamlData = new LinkedHashMap<>(); // Crear un nuevo mapa si el archivo está vacío
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Mantener los valores existentes de los campos clave
        String accessKey = (String) yamlData.get("accessKey");
        return accessKey;
    }
}
