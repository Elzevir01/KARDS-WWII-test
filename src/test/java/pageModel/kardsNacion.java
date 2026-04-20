package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class kardsNacion extends Base {

    ///// REFERENCIAS /////
    private String urlNacion = "https://www.kards.com/es/decks/deck-builder";

    ///// ELEMENTOS WEB /////
    /// nacion principal Estados Unidos ///  ////div[text()='Estados Unidos']
    private By nacionPrincipal = By.xpath("/html/body/div[2]/div[1]/main/div/div/div[2]/div/div[2]/div[4]/div/div[2]/div[2]");
    /// nacion aliada Finlandia ///
    private By nacionAliada = By.xpath("/html/body/div[2]/div[1]/main/div/div/div[2]/div/div[4]/div[9]");
    /// Boton Crear Mazo ///
    private By botonCrearMazo = By.xpath("/html/body/div[2]/div[1]/main/div/div/div[2]/div/div[5]/button");

    
    ///// CONSTRUCTOR /////
    public kardsNacion(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    ///// METODOS /////
    public void seleccionarNacion() {
        esperarElemento(nacionPrincipal);
        clickElemento(nacionPrincipal);
        clickElemento(nacionAliada);
        clickElemento(botonCrearMazo);
        
    }
}