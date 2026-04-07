package pageModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Base {
    WebDriver driver;
    String expectedTitle = "";

    ///// CONSTRUCTOR/////
    public Base(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Base() {
    }

    //// METODOS/////
    public WebElement findElemento(By elemento) {
        return driver.findElement(elemento);
    }

    public WebElement clickElemento(By elemento) {
        WebElement element = driver.findElement(elemento);
        element.click();
        return element;
    }

    public WebElement listaElemento(By elemento, int numero) {
        List<WebElement> lista = driver.findElements(elemento);
        WebElement elementoNumero = lista.get(numero);
        return elementoNumero;
    }

    public int listaSize(By elemento) {
        List<WebElement> lista = driver.findElements(elemento);
        return lista.size();

    }

    public void sendKey(By elemento, String texto) {
        findElemento(elemento).sendKeys(texto);
    }

    //// Escribir texto sin enviarlo ////
    /*
     * public void sendText(By elemento, String texto) {
     * WebElement input = driver.findElement(elemento);
     * actions.moveToElement(input).click().sendKeys(texto).build().perform();
     * }
     */
    public void cursorTo(By elemento) {
        new Actions(driver).moveToElement(findElemento(elemento)).perform();
    }

    public void cursorToJS(By elemento) {
        WebElement el = findElemento(elemento);
        String script = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent('mouseover',true,true,window,1,0,0,0,0,false,false,false,false,0,null);" +
                "arguments[0].dispatchEvent(evObj);";
        ((JavascriptExecutor) driver).executeScript(script, el);
    }

    public void navegar(String url) {
        driver.get(url);
    }

    public String titulo() {
        return driver.getTitle();
    }

    public void esperarElemento(By elemento) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
    }

    public void esperarWeb() {
    }

    public void confirmarTitulo(String titulo) {
        ExpectedConditions.titleIs(titulo);
    }

    public boolean checkElement(By elemento) {
        WebElement we = findElemento(elemento);
        try {
            if (we.isDisplayed()) {
                System.out.println("Elemento: [ " + we.getText() + " ] Existe");
            }
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Elemento: [ " + we.getText() + " ]X NO Existe");
            return false;
        }
    }

    public String getText(By elemento) {

        if (checkElement(elemento))
            return findElemento(elemento).getText();
        else
            return "";
    }

    public void derechaDe(By elemento, By xpath) {
        driver.findElement(with(xpath).toRightOf(elemento)).click();
    }

    public void izquierdaDe(By elemento, By xpath) {
        driver.findElement(with(xpath).toLeftOf(elemento)).click();
    }

    public void clickCoordenada(By elemento) {
        Actions builder = new Actions(driver);
        builder.moveToElement(findElemento(elemento), 25, 25).click().build().perform();
    }

    public void pressEsc() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).perform();
    }

}
