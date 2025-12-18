package app.com.steps.migracion;

import app.support.browsers.Browser;
import app.support.utils.CsvUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import app.pages.migracion.migracionActions;

public class migracionSteps {

    private String csvPath = "src/test/resources/data/migracion.csv";
    private int currentRow = 0;
    private String resultado;

    private migracionActions MigracionActions;

    public migracionSteps() {
        this.MigracionActions = new migracionActions(Browser.getDriver());
    }

    @And("navega a la seccion de credito hoja: {string} fila: {int}")
    public void haIngresadoALaSecciónDeDeSiebel(String sheetName, int row) throws InterruptedException {
        MigracionActions.cFinanciera(sheetName, row);
    }

    @When("el usuario valida todos los registros hoja: {string} fila: {int}")
    public void elUsuarioValidaTodosLosRegistros(String sheetName, int row) {
        String RutEsperado = CsvUtils.getDataFromCsv(sheetName, row, 0);
        String cuentaEsperado = CsvUtils.getDataFromCsv(sheetName, row, 1);
        String PlazoEsperado = CsvUtils.getDataFromCsv(sheetName, row, 2);
        String estadoEsperado = CsvUtils.getDataFromCsv(sheetName, row, 3);
        String montoEsperado = CsvUtils.getDataFromCsv(sheetName, row, 4);
        String sucEsperado = CsvUtils.getDataFromCsv(sheetName, row, 5);
        String cProdEsperado = CsvUtils.getDataFromCsv(sheetName, row, 6);
        String monedaEsperado = CsvUtils.getDataFromCsv(sheetName, row, 7);
        String mImpEsperado = CsvUtils.getDataFromCsv(sheetName, row, 8);
        String mGasEsperado = CsvUtils.getDataFromCsv(sheetName, row, 9);
        String mProyEsperado = CsvUtils.getDataFromCsv(sheetName, row, 10);
        String capIniEsperado = CsvUtils.getDataFromCsv(sheetName, row, 11);

        resultado = MigracionActions.validarRegistros(RutEsperado, cuentaEsperado, PlazoEsperado, estadoEsperado,
                montoEsperado, sucEsperado, cProdEsperado, monedaEsperado, mImpEsperado, mGasEsperado, mProyEsperado,
                capIniEsperado);
    }

    @And("navega a la seccion de cuadro de pago")
    public void ingresa_a_cuadro_de_pago() {
        MigracionActions.cPago();
    }

    @And("ingresa a cuadro de pago hoja: {string} fila: {int}")
    public void ingresa_a_cuadro_de_pago(String sheetName, int row) {
        String ultimaCuotaEsperada = CsvUtils.getDataFromCsv(sheetName, row, 9);
        String cMorosoEsperada = CsvUtils.getDataFromCsv(sheetName, row, 10);
        String cPagadaEsperada = CsvUtils.getDataFromCsv(sheetName, row, 11);

        String resultadoDetalle = MigracionActions.validaCuadroPago(
                ultimaCuotaEsperada, cMorosoEsperada, cPagadaEsperada);

        if (!resultado.equals("OK")) {
            resultado += " | " + resultadoDetalle;
        } else {
            resultado = resultadoDetalle;
        }
    }

    @Then("guardar el resultado en el csv fila: {int}")
    public void guardarElResultadoEnElCsv(int row) {
        CsvUtils.setResultInCsv(csvPath, row, resultado);
        currentRow++;
    }
}
