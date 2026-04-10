package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class kardsBuild extends Base {

    private By buscador = By.xpath("//input[@id='build-card-search']");
    private By codigoImportacion = By.xpath("//span[text()='Obtener código de importación']");
    private By maxCartas = By.xpath("//div[contains(text(), '40')]");

    ///// CONSTRUCTOR /////
    public kardsBuild(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ///// METODOS /////

    /// buscar y agregar carta al mazo ///
    public void buscarCarta(String nombreCarta, By carta) {
        sendKey(buscador, nombreCarta);
        esperarElemento(carta);
        clickElemento(carta);
    }

    public void obtenerCodigoImportacion() {
        int cantidadCartas = 0;
        cantidadCartas = Integer.parseInt(maxCartas));
        if (cantidadCartas == 40) {
            esperarElemento(codigoImportacion);
            clickElemento(codigoImportacion);
        }
    }

}
