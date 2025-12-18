package app.com.steps.refinanciar;

import app.support.browsers.Browser;
import io.cucumber.java.en.When;
import app.pages.refinanciar.refinActions;

public class refinSteps {
    refinActions RefinActions;

    public refinSteps() {
        this.RefinActions = new refinActions(Browser.getDriver());
    }

    @When("ejecutivo ingresa datos a refinanciar hoja: {string} fila: {int}")
    public void el_usuario_visualiza_el_detalle_de_la_repactacion(String sheetName, int row) throws Exception {
        RefinActions.enterDataNewRefin(sheetName, row);
    }

    @When("ejecutivo ingresa datos y efectivo hoja: {string} fila: {int}")
    public void el_usuario_visualiza_el_detalle(String sheetName, int row) throws Exception {
        RefinActions.RefinEfectivo(sheetName, row);
    }
}
