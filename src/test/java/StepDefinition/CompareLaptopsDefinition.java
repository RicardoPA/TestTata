package StepDefinition;

import Runner.BrowserManager.DriverFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class CompareLaptopsDefinition extends TestBase{

    @Given("usuario ingresa a la web de Gadget snow")
    public void usuarioIngresaALaWebDeGadgetSnow() {
        //DriverFactory.getDriver().manage().deleteAllCookies();
        DriverFactory.getDriver().get("https://www.gadgetsnow.com/compare-laptops");
    }

    @When("usuario selecciona la primera laptop {string}")
    public void usuarioSeleccionaLaPrimeraLaptop(String desc) throws Exception {
        compareLaptopAction.actionSeleccionarLaptop(1, desc);
    }

    @And("usuario selecciona la segunda laptop {string}")
    public void usuarioSeleccionaLaSegundaLaptop(String desc) throws Exception {
        compareLaptopAction.actionSeleccionarLaptop(2, desc);
    }

    @And("usuario presiona el boton compare")
    public void usuarioPresionaElBotonCompare() throws Exception {
        compareLaptopAction.clickBtnCompare();
    }

    @Then("se muestra resultado de comparacion")
    public void seMuestraResultadoDeComparacion() throws InterruptedException {
        Assert.assertTrue(resultAction.validarResultado());
    }

    @And("usuario extrae informacion de tabla SUMMARY en archivo excel")
    public void usuarioExtraeInformacionDeTablaSUMMARYEnArchivoExcel() throws IOException {
        resultAction.exportarTablaSummaryExcel();
    }
}
