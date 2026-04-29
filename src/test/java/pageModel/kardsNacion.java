package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class kardsNacion extends Base {

    ///// REFERENCIAS /////
    private String urlNacion = "https://www.kards.com/es/decks/deck-builder";

    ///// ELEMENTOS WEB /////
    /// nacion principal Estados Unidos ///
    private By nacionPrincipal = By.xpath(
            "//div[text()='Estados Unidos' or contains(@class, 'usa') or contains(text(), 'Estados Unidos')] | /html/body/div[2]/div[1]/main/div/div/div[2]/div/div[2]/div[4]/div/div[2]/div[2]");

    /// nacion aliada Finlandia ///
    private By nacionAliada = By.xpath(
            "//div[text()='Finlandia' or contains(text(), 'Finlandia')] | /html/body/div[2]/div[1]/main/div/div/div[2]/div/div[4]/div[9]");

    /// Boton Crear Mazo ///
    private By botonCrearMazo = By.xpath(
            "//button[text()='Crear Mazo' or contains(text(), 'Crear Mazo') or contains(text(), 'Crear mazo')] | /html/body/div[2]/div[1]/main/div/div/div[2]/div/div[5]/button");

    ///// CONSTRUCTOR /////
    public kardsNacion(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ///// METODOS /////
    public void seleccionarNacion() {

        if (driver.getCurrentUrl().equals(urlNacion))
            System.out.println("Estamos en:'https://www.kards.com/es/decks/deck-builder'");

        System.out.println("Esperar Nacion principal seleccionada");
        esperarElemento(nacionPrincipal);

        System.out.println("Nacion principal seleccionada");
        clickElemento(nacionPrincipal);

        System.out.println("Esperar y clickear Nacion aliada seleccionada");
        esperarElemento(nacionAliada);
        clickElemento(nacionAliada);

        System.out.println("Esperar y clickear Boton crear mazo");
        esperarElemento(botonCrearMazo);
        clickElemento(botonCrearMazo);
    }
}