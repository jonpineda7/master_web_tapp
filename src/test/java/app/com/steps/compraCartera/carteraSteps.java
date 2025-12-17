package app.com.steps.compraCartera;

import io.cucumber.java.en.When;
import pages.compraCartera.carteraActions;
import steps.Hooks;

public class carteraSteps {

    private carteraActions CarteraActions;

    public carteraSteps(){
        this.CarteraActions = new carteraActions(Hooks.driver);
    }

    @When("ejecutivo ingresa datos a compra de cartera: hoja: {string} fila: {int}")
    public void selectMenuOption(String sheetName, int row) throws Exception {
        CarteraActions.enterNewCcartera(sheetName,  row);
    }
}
