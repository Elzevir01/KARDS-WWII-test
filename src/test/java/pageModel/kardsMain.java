package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class kardsMain extends Base {

    ///// REFERENCIAS /////
    private String webEspaniol = "https://www.kards.com/es";

    ///// ELEMENTOS WEB /////
    // idioma
    private By menu = By.xpath("//button[@class='Header_header__hamburger__bxks8']");
    private By idiomaEspanol = By.xpath("//a[@href='/es/']");
    // private By idiomaEspañol =
    // By.xpath("//li//div//a[@href='/es/decks/deck-builder']");

    private By contructorMazo = By.xpath("//li//div//a[@href='/es/decks/deck-builder']");

    ///// CONSTRUCTOR /////
    public kardsMain(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ///// METODOS /////
    public void seleccionarIdiomaEspañol() {
        esperarElemento(menu);
        clickElemento(menu);
        esperarElemento(idiomaEspanol);
        clickElemento(idiomaEspanol);
    }

    public void seleccionarDeckBuilder() {
        if (driver.getCurrentUrl().equals(webEspaniol)) {
            esperarElemento(menu);
            clickElemento(menu);
            esperarElemento(contructorMazo);
            clickElemento(contructorMazo);
        }
    }

}
