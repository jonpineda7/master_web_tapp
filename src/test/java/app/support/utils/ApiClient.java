package app.support.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ApiClient {
    private static final String urlApi = "https://coruscant.gascosistemas.com/apihelper/";

    public static String existingUserName;
    public static String existingAccessKey;
    public static String existingProjectName;
    public static String existingBuildName;

    public static String getCode() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://coruscant.gascosistemas.com/apihelper/get_code_sms");
        String result = null;
        try {
            HttpResponse response = httpClient.execute(request);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();

            result = content.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void unlockPhone(String phone) {

        HttpClient httpClient = HttpClients.createDefault();

        // URL del servicio PUT
        String url = "https://coruscant.gascosistemas.com/apihelper/set_smsphone_gp/" + phone + "/true";

        // Datos que deseas enviar en el cuerpo de la solicitud
        String jsonBody = "{\"phone\": \"" + phone + "\"}"; // Reemplaza con tus propios datos

        HttpPut request = new HttpPut(url);

        // Configura el encabezado para indicar que esta enviando datos JSON
        request.setHeader("Content-Type", "application/json");

        // Configura el cuerpo de la solicitud con los datos JSON
        StringEntity entity = new StringEntity(jsonBody, "UTF-8");
        request.setEntity(entity);

        try {
            HttpResponse response = httpClient.execute(request);
            System.out.println(response);

            // Procesa la respuesta aqui si es necesario

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unlockPhoneSerie(String phone) {

        HttpClient httpClient = HttpClients.createDefault();

        // URL del servicio PUT
        String url = "https://coruscant.gascosistemas.com/apihelper/set_validate_phone_gp/" + phone;

        // Datos que deseas enviar en el cuerpo de la solicitud
        String jsonBody = "{\"phone\": \"" + phone + "\"}"; // Reemplaza con tus propios datos

        HttpPut request = new HttpPut(url);

        // Configura el encabezado para indicar que estás enviando datos JSON
        request.setHeader("Content-Type", "application/json");

        // Configura el cuerpo de la solicitud con los datos JSON
        StringEntity entity = new StringEntity(jsonBody, "UTF-8");
        request.setEntity(entity);

        try {
            HttpResponse response = httpClient.execute(request);
            System.out.println(response);

            // Procesa la respuesta aquí si es necesario

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cleanPhoneSerie(String phone) {

        HttpClient httpClient = HttpClients.createDefault();

        // URL del servicio PUT
        String url = "https://coruscant.gascosistemas.com/apihelper/clean_sch_security/" + phone;

        // Datos que deseas enviar en el cuerpo de la solicitud
        String jsonBody = "{\"phone\": \"" + phone + "\"}"; // Reemplaza con tus propios datos

        HttpDelete request = new HttpDelete(url);

        // Configura el encabezado para indicar que estás enviando datos JSON
        request.setHeader("Content-Type", "application/json");

        // Configura el cuerpo de la solicitud con los datos JSON
        StringEntity entity = new StringEntity(jsonBody, "UTF-8");
        // request.setEntity(entity);

        try {
            HttpResponse response = httpClient.execute(request);
            System.out.println(response);

            // Procesa la respuesta aquí si es necesario

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCustomData() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://coruscant.gascosistemas.com/apihelper/getdatagascopack");
        String result = null;
        try {
            HttpResponse response = httpClient.execute(request);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();

            result = content.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void insertDataClientGp(String phone, String rut, String controlDate) {
        HttpClient httpClient = HttpClients.createDefault();

        // URL del servicio POST
        String url = "https://coruscant.gascosistemas.com/apihelper/insert_data_gp/" + phone + "/" + rut + "/"
                + controlDate;

        // Crear la solicitud HTTP POST
        HttpPost request = new HttpPost(url);

        // Configura el encabezado para indicar que estas enviando datos en formato de
        // formulario
        request.setHeader("Content-Type", "application/x-www-form-urlencoded");

        try {
            // Ejecuta la solicitud HTTP POST
            HttpResponse response = httpClient.execute(request);

            // Procesa la respuesta aqui si es necesario
            System.out.println(response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCapabilityAndroid() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://coruscant.gascosistemas.com/apihelper/get_capability_mobile/ANDROID");
        String result = null;
        try {
            HttpResponse response = httpClient.execute(request);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();

            result = content.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void updateYamlConfig(String yamlFileName) {
        System.out.println("Iniciando actualización del archivo YAML...");

        // Obtiene el directorio de trabajo actual y construye la ruta al archivo YAML
        File yamlFile = new File(System.getProperty("user.dir"), yamlFileName);
        // variable que hay que modificar según proyecto a ejecutar
        // ARQUETIPO/GASCOPACKS/etc
        String project = "ARQUETIPO";

        if (!yamlFile.exists()) {
            System.out.println("El archivo YAML no existe en la ruta especificada: " + yamlFile.getAbsolutePath());
            return;
        }

        String result;

        try {
            // 1. Obtener el JSON desde la API
            URL url = new URL(urlApi + "get_browserstack_yml/" + project);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                result = content.toString();
            }

            // Verificar que el JSON no sea nulo o vacío
            if (result == null || result.isEmpty()) {
                throw new NullPointerException("El JSON recibido de la API es nulo o está vacío.");
            }

            // Parsear el JSON
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> configData = objectMapper.readValue(result, new TypeReference<>() {
            });

            // Verificar que configData no sea nulo
            if (configData == null) {
                throw new NullPointerException("Los datos de configuración del JSON son nulos.");
            }

            // Cargar el archivo YAML
            Map<String, Object> yamlData;
            try (InputStream inputStream = new FileInputStream(yamlFile)) {
                Yaml yaml = new Yaml();
                yamlData = yaml.load(inputStream);

                // Verificar que yamlData no sea nulo
                if (yamlData == null) {
                    System.out.println("Los datos del archivo YAML son nulos.");
                    yamlData = new LinkedHashMap<>(); // Crear un nuevo mapa si el archivo está vacío
                }
            }

            // Mantener los valores existentes de los campos clave
            existingUserName = (String) yamlData.get("userName");
            existingAccessKey = (String) yamlData.get("accessKey");
            existingProjectName = (String) yamlData.get("projectName");
            existingBuildName = (String) yamlData.get("buildName");

            // Actualizar otros campos, pero NO sobrescribir los campos clave
            yamlData.put("userName", existingUserName);
            yamlData.put("accessKey", existingAccessKey);
            yamlData.put("projectName", existingProjectName);
            yamlData.put("buildName", existingBuildName);
            yamlData.put("buildIdentifier", configData.get("buildIdentifier"));

            // Eliminar la sección 'platforms' del yamlData para reconstruirla manualmente
            yamlData.remove("platforms");

            // Actualizar parallelsPerPlatform si existe
            if (configData.containsKey("parallelsPerPlatform")) {
                yamlData.put("parallelsPerPlatform", configData.get("parallelsPerPlatform"));
            }

            // Añadir otros campos necesarios
            yamlData.put("source", "java:intellij:v1.1.4");
            yamlData.put("browserstackLocal", true);
            yamlData.put("debug", true);
            yamlData.put("networkLogs", true);
            yamlData.put("consoleLogs", "errors");

            // Construir manualmente la sección 'platforms'
            List<Map<String, Object>> platforms = (List<Map<String, Object>>) configData.get("platforms");
            if (platforms != null) {
                // Convertir valores de osVersion y browserVersion a número si es posible
                for (Map<String, Object> platform : platforms) {
                    if (platform.containsKey("osVersion")) {
                        Object osVersion = platform.get("osVersion");
                        if (osVersion instanceof String) {
                            String osVersionStr = (String) osVersion;
                            if (osVersionStr.matches("\\d+")) {
                                platform.put("osVersion", Integer.parseInt(osVersionStr));
                            } else if (osVersionStr.matches("\\d+\\.\\d+")) {
                                platform.put("osVersion", Double.parseDouble(osVersionStr));
                            }
                        }
                    }
                    if (platform.containsKey("browserVersion")) {
                        Object browserVersion = platform.get("browserVersion");
                        if (browserVersion instanceof String) {
                            String browserVersionStr = (String) browserVersion;
                            if (browserVersionStr.matches("\\d+\\.\\d+")) {
                                platform.put("browserVersion", Double.parseDouble(browserVersionStr));
                            }
                        }
                    }
                }
                yamlData.put("platforms", platforms);
            }

            // Guardar el archivo YAML actualizado
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            options.setPrettyFlow(true);
            Yaml yamlWriter = new Yaml(options);

            // Guardar el archivo con el contenido actualizado
            try (FileWriter writer = new FileWriter(yamlFile)) {
                yamlWriter.dump(yamlData, writer);
            }

            System.out.println("Archivo YAML actualizado exitosamente.");

        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo YAML: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // --------------------------------------------------------------------------------
    // JIRA INTEGRATION
    // --------------------------------------------------------------------------------

    // Nota: Reemplazar con la URL real de la API de Jira o Xray
    private static final String JIRA_API_URL = "https://jira.yourcompany.com/rest/raven/1.0/import/execution";
    private static final String JIRA_AUTH_TOKEN = System.getenv("JIRA_AUTH_TOKEN"); // Token Base64 o Bearer

    public static void updateJiraExecution(String testKey, String status) {
        if (JIRA_AUTH_TOKEN == null || JIRA_AUTH_TOKEN.isBlank()) {
            System.out.println("[ApiClient] JIRA_AUTH_TOKEN no configurado. Saltando actualización Jira.");
            return;
        }

        System.out.println("[ApiClient] Actualizando Jira: " + testKey + " -> " + status);
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost(JIRA_API_URL);

        try {
            // Configurar Headers
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Authorization", "Basic " + JIRA_AUTH_TOKEN);

            // Mapeo básico de status Cucumber a Jira/Xray
            String xrayStatus = status.equalsIgnoreCase("PASSED") ? "PASS" : "FAIL";

            // Payload Ejemplo (Ajustar según la documentación de la API específica de
            // Jira/Xray/Zephyr)
            String jsonBody = String.format("{" +
                    "\"testExecutionKey\": \"%s\"," +
                    "\"info\": { \"summary\": \"Execution by Automation\" }," +
                    "\"tests\": [ { \"testKey\": \"%s\", \"status\": \"%s\" } ]" +
                    "}", "EXEC-123", testKey, xrayStatus); // 'EXEC-123' debería ser dinámico si se crea una ejecución
                                                           // nueva

            // Nota: Para implementación real, se recomienda crear primero la ejecución y
            // luego actualizar los tests,
            // o crear una ejecución que contenga todos los resultados al final.
            // Esta implementación es un ejemplo de actualización individual.

            StringEntity entity = new StringEntity(jsonBody);
            request.setEntity(entity);

            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode >= 200 && statusCode < 300) {
                System.out.println("[ApiClient] Jira actualizado correctamente para " + testKey);
            } else {
                System.out.println("[ApiClient] Error actualizando Jira. Status: " + statusCode);
            }

        } catch (Exception e) {
            System.out.println("[ApiClient] Excepción al conectar con Jira: " + e.getMessage());
            e.printStackTrace();
        }
    }
}