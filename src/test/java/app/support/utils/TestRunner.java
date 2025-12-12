package app.support.utils;

import app.support.utils.UpdateYamlConfigRunner;
import io.cucumber.core.cli.Main;

public class TestRunner {

    // El bloque estático se ejecutará primero al cargar la clase
    static {
        // Actualiza el YAML antes de que se cargue la configuración de BrowserStack
        new UpdateYamlConfigRunner().main(null);
    }

    public static void main(String[] args) {
        // Inicia la ejecución de Cucumber
        Main.main(args);
    }

}
