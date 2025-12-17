package app.com.steps.login;

import io.cucumber.java.en.Given;
import pages.login.loginSiebelActions;
import steps.Hooks;

import java.io.IOException;

import static steps.Hooks.driver;

public class loginSiebelStep {
    String links = "urls";
    //loginSiebelActions login = new loginSiebelActions(driver);
    private loginSiebelActions LoginSiebelActions;

    public loginSiebelStep() throws IOException {
        this.LoginSiebelActions = new loginSiebelActions(driver);
    }


    @Given("que el ejecutivo ha iniciado sesión en la plataforma {string}")
    public void queElEjecutivoHaIniciadoSesiónEnLaPlataforma(String Siebel) throws Throwable {
        String sheetName = "LOGIN";
        String url = Hooks.getDataFromJson(links, Siebel);
        if (url == null) {
            throw new NullPointerException("La URL obtenida del JSON es nula.");
        }
        System.out.println("Navegando a la URL: " + url);
        LoginSiebelActions.navigateTo(url);
        LoginSiebelActions.loginSiebelAplication(sheetName);
    }
}
