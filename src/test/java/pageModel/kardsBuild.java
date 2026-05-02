package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class kardsBuild extends Base {

    private By buscador = By.xpath("//input[@id='build-card-search']");
    private By codigoImportacion = By
            .xpath("/html/body/div[2]/div[1]/main/div/div/div[2]/div/div[1]/div[2]/div[1]/button/span[2]");
    private By maxCartas = By.xpath(
            "/html/body/div[2]/div[1]/main/div/div/div[2]/div/div[1]/div[2]/div[2]/div/div/div/article/div/div/div[3]");
    private By limpiarFiltros = By.xpath(
            "//span[contains(text(), 'Borrar filtros')] | /html/body/div[2]/div[1]/main/div/div/div[2]/div/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]");
    private By incluirReservadas = By.xpath(
            "//button[contains(text(), 'Incluir cartas reservadas')] | /html/body/div[2]/div[1]/main/div/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div/div[1]/ul/li/div/div[7]/button");

    ///// CONSTRUCTOR /////
    public kardsBuild(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ///// METODOS /////

    /// buscar y agregar carta al mazo ///
    public void buscarCarta(String nombreCarta, By carta, int numero) {
        try {
            clearElemento(buscador);
            sendKey(buscador, nombreCarta);
            esperarElemento(carta);

            if (checkElement(carta)) {
                for (int i = 0; i < numero; i++) {
                    clickElemento(carta);
                }
            }
            if (checkElement(limpiarFiltros))
                clickElemento(limpiarFiltros);
        } catch (Exception e) {
            System.out.println("Error al buscar carta: " + e);
            clickElemento(limpiarFiltros);
        }
    }

    public void obtenerCodigoImportacion() {
        // int cantidadCartas = 0;
        // cantidadCartas = Integer.parseInt(getText(maxCartas));
        if (getText(maxCartas).equals("40/40")) {
            esperarElemento(codigoImportacion);
            clickElemento(codigoImportacion);
        }
    }

    public void incluirReservadas() {
        findElemento(incluirReservadas).click();
    }

}
