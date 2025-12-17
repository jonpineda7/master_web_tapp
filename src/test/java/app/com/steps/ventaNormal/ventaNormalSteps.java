package app.com.steps.ventaNormal;

import io.cucumber.java.en.When;
import pages.ventaNormalPage.ventaNormalActions;
import steps.Hooks;

public class ventaNormalSteps {
    private ventaNormalActions VentaNormalActions;  // Declaración de la variable

    public ventaNormalSteps() {
        this.VentaNormalActions = new ventaNormalActions(Hooks.driver); // Inicialización con el driver de Hooks
    }


    @When("ejecutivo ingresa oferta hoja: {string} fila: {int}")
    public void enterCreditData(String sheetName, int row) throws Exception {
        VentaNormalActions.enterCreditData(sheetName, row);
    }


}
