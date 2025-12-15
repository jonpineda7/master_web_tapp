package app.com.steps;

import app.pages.packs.ComprarPack;
import app.support.utils.ApiClient;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class ComprarPacks {

    private List<String[]> data;
    private JSONArray dataapi;
    private static int currentIndex;
    private Scenario currentScenario;

    @Before
    public void setUp(Scenario scenario) {
        // Este método se ejecutará antes de cada escenario
        this.currentScenario = scenario;
    }

    @Then("^marcar el check de terminos y condiciones$")
    public void leerAceptarTerminos() throws URISyntaxException, IOException {
        ComprarPack cp = new ComprarPack();
        cp.aceptarCondiciones();
    }

    @And("^click en comprar pack$")
    public void clickComprarPack() throws URISyntaxException, IOException, InterruptedException {
        ComprarPack cp = new ComprarPack();
        cp.clickComprarPack();
    }

    @And("^presionar icono volver$")
    public void clickIconoVolver() throws URISyntaxException, IOException, InterruptedException {
        ComprarPack cp = new ComprarPack();
        cp.clickIconoVolver();
    }


    @And("^seleccionar pack y hacer click en boton continuar$")
    public void seleccionarPack() throws URISyntaxException, IOException, InterruptedException {
        ComprarPack cp = new ComprarPack();
        cp.seleccionPack();
    }

    @And("^ingresar datos de formulario \"([^\"]*)\"$")
    public void ingresarDatosFormulario(String id) throws InterruptedException, URISyntaxException, IOException {
        //String[] record = data.get(Integer.parseInt(id));
        System.out.println("DATOSAPI==>");
        System.out.println(dataapi);
        // Obtiene el primer objeto JSON del JSONArray
        JSONObject objetData = dataapi.getJSONObject(Integer.parseInt(id));

        // Obtiene el valor de la clave "código" del primer objeto
        //String codigo = objetData.getString("código");

        String nombreCliente = objetData.getString("nombre");
        String rut = objetData.getString("rut");
        String telefono = objetData.getString("fono");
        String correo = objetData.getString("mail");
        System.out.println("NOMBRE: " + nombreCliente);
        System.out.println("RUT: " + rut);

        ComprarPack cp = new ComprarPack();
        cp.ingresarDatos(nombreCliente, rut, telefono, correo);
    }

    @And("^forzar ingreso de datos en formulario$")
    public void forzarIngresoDatosFormulario() throws InterruptedException, URISyntaxException, IOException {

        String nombreCliente = "abcdefghi_abcdefghi_abcdefghi_abcdefghi_abcdefghi_abcdefghi_abcdefghi_abcdefghi_abcdefghi_abcdefghi_F";
        String rut = "11.111.111-11";
        String telefono = "9234567801";
        String correo = "abcdefghiabcdefghi_abcdefghi_abcdefghi_abcdefghi_abcdefghi_abcdefghi_abcdefghi_abcdefghi_@abcde.fghiclF";
        System.out.println("NOMBRE: " + nombreCliente);
        System.out.println("RUT: " + rut);

        ComprarPack cp = new ComprarPack();
        cp.forzarIngresoDatos(nombreCliente, rut, telefono, correo);
    }

    @And("^ingresar rut de empresa y corroborar validación rut persona$")
    public void ingresoRutEmpresayValidacion() throws InterruptedException, URISyntaxException, IOException {

        String rut = "93329000-K";
        System.out.println("RUT: " + rut);

        ComprarPack cp = new ComprarPack();
        cp.ingresarRutEmpresaValidacion(rut);
    }

    @And("^validar ingreso distintos mails en formulario$")
    public void validarIngresoDistintosMails() throws InterruptedException, URISyntaxException, IOException {

        String email  = "jpineda@gasco.cl";
        String emailb = "jpineda2@gasco.cl";

        ComprarPack cp = new ComprarPack();
        cp.validarDistintosMails(email, emailb);
    }

    @And("^reingresar datos de formulario \"([^\"]*)\"$")
    public void reingresarDatosFormulario(String id) throws InterruptedException, URISyntaxException, IOException {
        //String[] record = data.get(Integer.parseInt(id));
        System.out.println("DATOSAPI==>");
        System.out.println(dataapi);
        // Obtiene el primer objeto JSON del JSONArray
        JSONObject objetData = dataapi.getJSONObject(Integer.parseInt(id));

        // Obtiene el valor de la clave "código" del primer objeto
        //String codigo = objetData.getString("código");

        String nombreCliente = objetData.getString("nombre");
        String rut = objetData.getString("rut");
        String telefono = objetData.getString("fono");
        String correo = objetData.getString("mail");
        System.out.println("NOMBRE: " + nombreCliente);
        System.out.println("RUT: " + rut);

        ComprarPack cp = new ComprarPack();
        cp.reingresarDatos(nombreCliente, rut, telefono, correo);
    }

    @And("^ingresar datos de formulario y marcar check \"([^\"]*)\"$")
    public void ingresarDatosFormularioYCheck(String id) throws InterruptedException, URISyntaxException, IOException {
        //String[] record = data.get(Integer.parseInt(id));

        // Obtiene el primer objeto JSON del JSONArray
        JSONObject objetData = dataapi.getJSONObject(Integer.parseInt(id));

        // Obtiene el valor de la clave "código" del primer objeto
        //String codigo = objetData.getString("código");

        String nombreCliente = objetData.getString("nombre");
        String rut = objetData.getString("rut");
        String telefono = objetData.getString("fono");
        String correo = objetData.getString("mail");
        System.out.println("NOMBRE: " + nombreCliente);
        System.out.println("RUT: " + rut);

        ComprarPack cp = new ComprarPack();
        cp.ingresarDatosCheck(nombreCliente, rut, telefono, correo);
    }

    @And("^ingresar datos de formulario y validar boton continuar \"([^\"]*)\"$")
    public void ingresarDatosFormularioYValidarContinuar(String id) throws InterruptedException, URISyntaxException, IOException {
        //String[] record = data.get(Integer.parseInt(id));

        // Obtiene el primer objeto JSON del JSONArray
        JSONObject objetData = dataapi.getJSONObject(Integer.parseInt(id));

        // Obtiene el valor de la clave "código" del primer objeto
        //String codigo = objetData.getString("código");

        String nombreCliente = objetData.getString("nombre");
        String rut = objetData.getString("rut");
        String telefono = objetData.getString("fono");
        String correo = objetData.getString("mail");
        System.out.println("NOMBRE: " + nombreCliente);
        System.out.println("RUT: " + rut);

        ComprarPack cp = new ComprarPack();
        cp.ingresarDatosValidarContinuar(nombreCliente, rut, telefono, correo);
    }

    @And("^ingresar codigo de seguridad e ir a pagar$")
    public void ingresarCodigoPagar() throws InterruptedException, URISyntaxException, IOException {
        // Asegúrate de que los datos coincidan con los valores esperados del escenario
        ApiClient ap = new ApiClient();
        String result = ap.getCode();
        JSONArray jsonArray = new JSONArray(result);

        // Obtiene el primer objeto JSON del JSONArray
        JSONObject primerObjeto = jsonArray.getJSONObject(0);

        // Obtiene el valor de la clave "código" del primer objeto
        String codigo = primerObjeto.getString("código");

        ComprarPack cp = new ComprarPack();
        cp.ingresarCodigoyPago(codigo);

    }

    @And("^ingresar codigo de seguridad$")
    public void ingresarCodigo() throws InterruptedException, URISyntaxException, IOException {
        // Asegúrate de que los datos coincidan con los valores esperados del escenario
        ApiClient ap = new ApiClient();
        String result = ap.getCode();
        JSONArray jsonArray = new JSONArray(result);

        // Obtiene el primer objeto JSON del JSONArray
        JSONObject primerObjeto = jsonArray.getJSONObject(0);

        // Obtiene el valor de la clave "código" del primer objeto
        String codigo = primerObjeto.getString("código");

        ComprarPack cp = new ComprarPack();
        cp.ingresarCodigo(codigo);

    }

    @And("^ingresar codigo de seguridad y verificar$")
    public void ingresarCodigoVerificar() throws InterruptedException, URISyntaxException, IOException {
        // Asegúrate de que los datos coincidan con los valores esperados del escenario
        ApiClient ap = new ApiClient();
        String result = ap.getCode();
        JSONArray jsonArray = new JSONArray(result);

        // Obtiene el primer objeto JSON del JSONArray
        JSONObject primerObjeto = jsonArray.getJSONObject(0);

        // Obtiene el valor de la clave "código" del primer objeto
        String codigo = primerObjeto.getString("código");

        ComprarPack cp = new ComprarPack();
        cp.ingresarCodigoValidacion(codigo);

    }

    @And("^ingresar datos de pago y realizar pago$")
    public void ingresarDatosyPagar() throws InterruptedException, URISyntaxException, IOException {
        // Asegúrate de que los datos coincidan con los valores esperados del escenario

        ComprarPack cp = new ComprarPack();
        cp.ingresarDatosyPagar();

    }

    @And("^cargar datos de prueba CSV$")
    public void loadCsvTest() throws IOException, CsvException {
        String csvFile = "files/Csv/datosform_gascopack.csv"; // Reemplaza con la ruta correcta del archivo CSV
        CSVReader reader = new CSVReader(new FileReader(csvFile));
        data = reader.readAll();
        System.out.println("DATA: " + data);
        reader.close();
        currentIndex = 0;
    }

    @And("^cargar datos de prueba API$")
    public void loadDataApi() throws IOException, CsvException {

        // Asegúrate de que los datos coincidan con los valores esperados del escenario
        ApiClient ap = new ApiClient();
        String result = ap.getCustomData();
        dataapi = new JSONArray(result);
        currentIndex = 0;
    }

    @Then("^I use the data \"([^\"]*)\" from the CSV file$")
    public void cargarCsvTest(String id) throws IOException, CsvException {

        String[] record = data.get(Integer.parseInt(id));
        String nombreActual = record[0];
        String edadActual = record[1];
        String ocupacionActual = record[2];
        System.out.println("NOMBRE: " + nombreActual);
        // Asegúrate de que los datos coincidan con los valores esperados del escenario
        assert nombreActual.equals(id);

    }

    @Then("^Verificar elementos de acciones$")
    public void VerificarElementosGP() throws URISyntaxException, IOException, InterruptedException {
        ComprarPack cp = new ComprarPack();
        cp.verificarCamposGp();
    }
    @And("^Presionar el logo de Gasco y validar url link$")
    public void presionarLogoGasco() throws URISyntaxException, IOException, InterruptedException {
        ComprarPack cp = new ComprarPack();
        cp.clickLogoGasco();
    }

    @And("^Presionar el link terminos y condiciones$")
    public void presionarLinkTerminosCondiciones() throws URISyntaxException, IOException, InterruptedException {
        ComprarPack cp = new ComprarPack();
        cp.clickLogoGasco();
    }

    @And("^click en link contactanos$")
    public void clickLinkContactanos() throws URISyntaxException, IOException {
        ComprarPack cp = new ComprarPack();
        cp.clickContactanos();
    }

    @Then("^click en haz click aqui$")
    public void clickHazClick() throws URISyntaxException, IOException {
        ComprarPack cp = new ComprarPack();
        cp.clickHazClickAqui();
    }

    @And("^enviar mensaje telegram termino de prueba$")
    public void enviarMensajeTlgFinPrueba() throws InterruptedException, URISyntaxException, IOException {
        // Asegúrate de que los datos coincidan con los valores esperados del escenario

        ComprarPack cp = new ComprarPack();
        String scenarioName = currentScenario.getName();
        cp.enviarMensajeTelegram("ProyectoBase", scenarioName);

    }
}
