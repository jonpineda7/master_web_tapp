package app.com.steps.migracion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.migracion.migracionActions;
import steps.Hooks;
import utils.CsvUtils;

public class migracionSteps {

    private String csvPath = "src/test/resources/data/migracion.csv"; // ruta a tu CSV
    private int currentRow = 0; // para simplificar, fila en CSV que corresponde al Example actual
    private String resultado;

    private migracionActions MigracionActions;

    public migracionSteps(){
        this.MigracionActions = new migracionActions(Hooks.driver);
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

       /* String intAnualEsperado = CsvUtils.getDataFromCsv(sheetName, row, 3);
        String intMensualEsperado = CsvUtils.getDataFromCsv(sheetName, row, 4);*/

        String estadoEsperado = CsvUtils.getDataFromCsv(sheetName, row, 3);

       /* String caeOriginalEsperado = CsvUtils.getDataFromCsv(sheetName, row, 6);
        String caeSinSegEsperado = CsvUtils.getDataFromCsv(sheetName, row, 7);*/
       /* String apellidoPEsperado = CsvUtils.getDataFromCsv(sheetName, row, 8);
        String apellidoMEsperado = CsvUtils.getDataFromCsv(sheetName, row, 9);
        String nombreEsperado = CsvUtils.getDataFromCsv(sheetName, row, 10);*/

        String montoEsperado = CsvUtils.getDataFromCsv(sheetName, row, 4);
        String sucEsperado = CsvUtils.getDataFromCsv(sheetName, row, 5);
        String cProdEsperado = CsvUtils.getDataFromCsv(sheetName, row, 6);
        String monedaEsperado = CsvUtils.getDataFromCsv(sheetName, row, 7);
        String mImpEsperado = CsvUtils.getDataFromCsv(sheetName, row, 8);
        String mGasEsperado = CsvUtils.getDataFromCsv(sheetName, row, 9);
        String mProyEsperado = CsvUtils.getDataFromCsv(sheetName, row, 10);
        String capIniEsperado = CsvUtils.getDataFromCsv(sheetName, row, 11);



        //resultado = MigracionActions.validarRegistros(RutEsperado, cuentaEsperado, mProyEsperado);

        resultado = MigracionActions.validarRegistros(RutEsperado, cuentaEsperado, PlazoEsperado,estadoEsperado,montoEsperado,
                sucEsperado,cProdEsperado,monedaEsperado,mImpEsperado,mGasEsperado,mProyEsperado,capIniEsperado);
        
    }

    @And("navega a la seccion de cuadro de pago")
    public void ingresa_a_cuadro_de_pago() {
        MigracionActions.cPago();
    }

    @And("ingresa a cuadro de pago hoja: {string} fila: {int}")
    public void ingresa_a_cuadro_de_pago(String sheetName, int row) {


        // Leer los mismos datos del CSV
        String ultimaCuotaEsperada = CsvUtils.getDataFromCsv(sheetName, row, 9);
        String cMorosoEsperada = CsvUtils.getDataFromCsv(sheetName, row, 10);
        String cPagadaEsperada = CsvUtils.getDataFromCsv(sheetName, row, 11);

        // Llamar a una nueva validación que solo revise lo que existe en esta página
        String resultadoDetalle = MigracionActions.validaCuadroPago(
                ultimaCuotaEsperada, cMorosoEsperada, cPagadaEsperada
        );

        // Combinar resultados para escribir un solo output en el CSV
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
