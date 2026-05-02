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
    private By idiomaEspanol = By.xpath("//a[@href='/es/?']");
    private By cookies = By.xpath(
            "//span[contains(text(),'Accept')] | /html/body/div[2]/div[1]/div[1]/div/div[2]/ul/li[2]/button/span[2]");
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

    public void allowCookies() {
        esperarElemento(cookies);
        clickElemento(cookies);
    }

}
