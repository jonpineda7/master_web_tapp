package app.com.steps.login;

import app.support.browsers.Browser;
import app.support.loadproperties.LoadProperty;
import io.cucumber.java.en.Given;
import app.pages.login.loginSiebelActions;

import java.io.IOException;

public class loginSiebelStep {
    String links = "urls";
    private loginSiebelActions LoginSiebelActions;

    public loginSiebelStep() throws IOException {
        this.LoginSiebelActions = new loginSiebelActions(Browser.getDriver());
    }

    @Given("que el ejecutivo ha iniciado sesión en la plataforma {string}")
    public void queElEjecutivoHaIniciadoSesiónEnLaPlataforma(String Siebel) throws Throwable {
        String sheetName = "LOGIN";
        // Replaced Hooks.getDataFromJson with LoadProperty
        String url = LoadProperty.URLs.getProperty(Siebel);
        if (url == null) {
            // Check if adding prefix helps (e.g. urls.Siebel) as seen in Browser.java
            url = LoadProperty.URLs.getProperty("urls." + Siebel);
            if (url == null) {
                throw new NullPointerException("La URL obtenida es nula para key: " + Siebel);
            }
        }
        System.out.println("Navegando a la URL: " + url);
        LoginSiebelActions.navigateTo(url);
        LoginSiebelActions.loginSiebelAplication(sheetName);
    }
}
