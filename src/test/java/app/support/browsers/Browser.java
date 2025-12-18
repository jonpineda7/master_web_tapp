package app.support.browsers;

import app.support.utils.Yaml;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import app.com.hook.Hooks;
import app.support.loadproperties.LoadProperty;
import java.net.URL;

public class Browser {

    // El Java SDK de BrowserStack injecta automáticamente las credenciales y
    // capabilities
    // si el driver es RemoteWebDriver y la URL apunta al hub de BrowserStack.
    // También soporta el uso de variables de entorno BROWSERSTACK_USERNAME y
    // BROWSERSTACK_ACCESS_KEY

    // URL estándar para BrowserStack Automate
    public static final String HUB_URL = "https://hub-cloud.browserstack.com/wd/hub";

    private static String url;

    private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static ChromeDriver localChrome() {
        try {
            System.setProperty("webdriver.chrome.driver",
                    LoadProperty.BROWSER.getProperty("path_chrome"));
            System.setProperty("webdriver.chrome.silentOutput", "true");

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");

            driver.set(new ChromeDriver(chromeOptions));
            driver.get().manage().window().setSize(new Dimension(1920, 1080));
            driver.get().get(url);
            waitThread();
        } catch (Exception e) {
            System.out.println("Fallo ChromeDriver. " + e.getCause());
        }
        return (ChromeDriver) driver.get();
    }

    public static SafariDriver localSafari() {
        try {
            driver.set(new SafariDriver());
            driver.get().manage().window().setSize(new Dimension(1920, 1080));

            driver.get().get(url);
            waitThread();
        } catch (Exception e) {
            System.out.println("Fallo SafariDriver. " + e.getCause());
        }
        return (SafariDriver) driver.get();
    }

    public static FirefoxDriver localFirefox() {
        try {
            System.setProperty("webdriver.gecko.driver",
                    LoadProperty.BROWSER.getProperty("path_firefox"));
            FirefoxOptions opciones = new FirefoxOptions();
            opciones.setProfile(new FirefoxProfile());
            driver.set(new FirefoxDriver(opciones));
            driver.get().manage().window().setSize(new Dimension(1920, 1080));
            driver.get().get(url);
            waitThread();
        } catch (Exception e) {
            System.out.println("Fallo FirefoxDriver. " + e.getCause());
        }
        return (FirefoxDriver) driver.get();
    }

    public static RemoteWebDriver latestChrome() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Configuración básica que el SDK complementará
        // Nota: Al usar el SDK, 'os', 'os_version', 'browser', 'browser_version'
        // deberían venir preferentemente del browserstack.yml, aunque se pueden forzar
        // aquí.

        // Mantenemos solo capabilities custom que definen metadatos de la prueba
        caps.setCapability("name", Hooks.NAMEs.get());

        // Construcción del nombre del build basado en la tarea (logica original
        // preservada)
        String buildName = generateBuildName();
        if (buildName != null) {
            caps.setCapability("build", buildName);
        }

        // Ya no hardcodeamos usuario/key en la URL
        // El Authentication se maneja via SDK o variables de entorno estándar si se
        // configura
        // Sin embargo, para RemoteWebDriver puro a veces se requiere pasar user/key en
        // URL o caps.
        // Pero el SDK agent intercepta la creación del driver.

        // Asumiendo que el SDK agent está activo (ver build.gradle), usamos
        // capabilities mínimas.

        waitThread();
        driver.set(new RemoteWebDriver(new URL(HUB_URL), caps));
        driver.get().manage().window().maximize();
        driver.get().get(url);
        return driver.get();
    }

    public static RemoteWebDriver latestMultipleChrome() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("name", Hooks.NAMEs.get());

        waitThread();
        driver.set(new RemoteWebDriver(new URL(HUB_URL), caps));
        driver.get().manage().window().maximize();
        driver.get().get(url);
        return driver.get();

    }

    private static String generateBuildName() {
        String taskName = LoadProperty.BUILD.getProperty("name_task");
        String baseBuild = LoadProperty.BUILD.getProperty("build") + " "
                + LoadProperty.BUILD.getProperty("build_version");

        // Logica simplificada
        if (taskName == null)
            return baseBuild;

        String typeBuild = "";
        switch (taskName) {
            case "regressionLowTag":
                typeBuild = LoadProperty.BUILD.getProperty("type_build_low");
                break;
            case "regressionMiddleTag":
                typeBuild = LoadProperty.BUILD.getProperty("type_build_middle");
                break;
            case "regressionHighTag":
                typeBuild = LoadProperty.BUILD.getProperty("type_build_high");
                break;
            case "regressionVeryHighTag":
                typeBuild = LoadProperty.BUILD.getProperty("type_build_very_high");
                break;
            default:
                return baseBuild + " " + LoadProperty.BROWSER.getProperty("browser_chrome");
        }

        return baseBuild + " " + typeBuild + " " + LoadProperty.BROWSER.getProperty("browser_chrome");
    }

    public static void quitDriver() {
        try {
            if (driver.get() != null) {
                driver.get().quit();
            }
        } catch (Exception e) {
            System.out.println("Fallo el driver al momento de cerrarse. Causa: " + e.getCause());
        }
    }

    public static RemoteWebDriver getDriver() {
        return driver.get();
    }

    /**
     * Codigo para dar una tolerancia de tiempo entre test
     **/
    private static void waitThread() {
        try {
            double valor = Math.floor(Math.random() * 4000) + 1000;
            int a = (int) valor;
            System.out.println("Tiempo de espera entre ejeucion: " + a);
            Thread.sleep(a);
        } catch (Exception e) {
            System.out.println("No se logro agregar Tiempo de espera. Excepcion: " + e.getMessage());
        }

    }

    /**
     * Setear variable url
     * 
     * @param flag
     */
    public static void setUrl(String flag) {
        url = LoadProperty.URLs.getProperty("urls." + flag);
    }
}
