package app.support.utils;

import app.support.utils.ApiClient;

public class UpdateYamlConfigRunner {
    public static void main(String[] args) {
        ApiClient ac = new ApiClient();
        ac.updateYamlConfig("browserstack.yml"); // Ajusta el nombre del archivo según sea necesario
    }
}