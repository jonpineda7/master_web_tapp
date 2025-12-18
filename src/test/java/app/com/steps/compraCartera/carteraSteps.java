package app.com.steps.compraCartera;

import app.support.browsers.Browser;
import io.cucumber.java.en.When;
import app.pages.compraCartera.carteraActions;

public class carteraSteps {

    private carteraActions CarteraActions;

    public carteraSteps() {
        this.CarteraActions = new carteraActions(Browser.getDriver());
    }

    @When("ejecutivo ingresa datos a compra de cartera: hoja: {string} fila: {int}")
    public void selectMenuOption(String sheetName, int row) throws Exception {
        CarteraActions.enterNewCcartera(sheetName, row);
    }
}
