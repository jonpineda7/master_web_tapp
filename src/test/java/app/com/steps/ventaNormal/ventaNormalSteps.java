package app.com.steps.ventaNormal;

import app.support.browsers.Browser;
import io.cucumber.java.en.When;
import app.pages.ventaNormalPage.ventaNormalActions;

public class ventaNormalSteps {
    private ventaNormalActions VentaNormalActions;

    public ventaNormalSteps() {
        this.VentaNormalActions = new ventaNormalActions(Browser.getDriver());
    }

    @When("ejecutivo ingresa oferta hoja: {string} fila: {int}")
    public void enterCreditData(String sheetName, int row) throws Exception {
        VentaNormalActions.enterCreditData(sheetName, row);
    }
}
