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
            System.out.println("Buscando carta: " + nombreCarta + ", cantidad: " + numero + " copias");
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
        try {
            // Esperar un momento para asegurar que los scripts de la pagina carguen
            Thread.sleep(2000);
            esperarElemento(incluirReservadas);
            org.openqa.selenium.WebElement element = findElemento(incluirReservadas);

            // Hacer scroll hacia el elemento
            org.openqa.selenium.JavascriptExecutor executor = (org.openqa.selenium.JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            Thread.sleep(500);

            try {
                element.click();
                System.out.println("Casilla 'Incluir cartas reservadas' clickeada exitosamente.");
                Thread.sleep(1000); // Esperar a que los resultados se refresquen en la UI

            } catch (Exception e) {
                // Fallback a click con Javascript si Selenium es bloqueado
                executor.executeScript("arguments[0].click();", element);
            }
            System.out.println("Casilla 'Incluir cartas reservadas' clickeada exitosamente.");
            Thread.sleep(1000); // Esperar a que los resultados se refresquen en la UI

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
