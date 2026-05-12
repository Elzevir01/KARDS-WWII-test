package com.Kards;

import org.testng.annotations.Test;

//import driver.DriverFactoryDirect;

import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.net.MalformedURLException;

import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pageModel.kardsBuild;
import pageModel.kardsMain;
import pageModel.kardsNacion;

import driver.DriverFactoryDirect;

import dataDeck.DeckRecipe;

public class kards {

    pageModel.kardsNacion kn;
    pageModel.kardsMain km;
    pageModel.kardsBuild kb;
    DriverFactoryDirect dfd;
    WebDriver driver;
    boolean reservadas = false;

    private static Logger Log = LogManager.getLogger(kards.class);

    @Description("Cambia el idioma de la web y selecciona construccion de mazo")
    @Epic("Test de idioma")
    @Story("Seleccion de idioma")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "kards.com - principal", url = "https://www.kards.com/")
    @Test(priority = 1, description = "Cambia el idioma de la web y selecciona deck builder")
    public void Test_1_idioma() {
        try {
            km = new kardsMain(driver);
            String url = "https://www.kards.com/";
            km.navegar(url);
            km.esperarWeb();
            // Thread.sleep(5000);
            km.allowCookies();
            km.seleccionarIdiomaEspañol();
            km.seleccionarDeckBuilder();
            km.esperarWeb();
            // Thread.sleep(5000);

        } catch (Exception e) {
            Log.error("Causa : " + e.getCause());
            Log.error("Mensaje : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Description("Selecciona una nacion principal, aliada y click en crear mazo")
    @Epic("Test seleccionde nacion")
    @Story("Seleccion de nacion")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "kards.com - seleccion de naciones", url = "https://www.kards.com/es/decks/deck-builder")
    @Test(priority = 2, description = "Selecciona nacion principal y aliada")
    public void Test_2_naciones() {
        try {
            kn = new kardsNacion(driver);
            kn.seleccionarNacion();
            // kn.esperarWeb();
            // Thread.sleep(5000);
        } catch (Exception e) {
            Log.error("Causa : " + e.getCause());
            Log.error("Mensaje : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Description("Selecciona las cartas del mazo")
    @Epic("Test seleccionde cada carta del mazo")
    @Story("Seleccion de cada carta del mazo")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "kards.com - deck builder", url = "https://www.kards.com/es/decks/deck-builder?hash=%25%2559|%3B%3B%3B")
    @Test(priority = 3, dataProvider = "deckCards", dataProviderClass = DeckRecipe.class)
    public void Test_3_seleccionarCartas(By carta, int numero, String nombre) {
        kb = new kardsBuild(driver);
        System.out.println("valor reservadas: " + reservadas);
        if (reservadas == false) {
            kb.esperarWeb();
            kb.incluirReservadas();
            reservadas = true;
        }
        Log.info("Buscando y agregando: " + nombre + " :: numero de veces: " + numero + "");

        // ---generar mazo---//
        kb.buscarCarta(nombre, carta, numero);
    }

    @Description("Obtiene el codigo de importacion del mazo")
    @Epic("Test obtencion de codigo de importacion")
    @Story("Obtencion de codigo de importacion")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "kards.com - deck builder", url = "https://www.kards.com/es/decks/deck-builder?hash=%25%2559|%3B%3B%3B")
    @Test(priority = 4, description = "Obtiene el codigo de importacion del mazo")
    public void Test_4_generarCodigoMazo() {
        try {
            kb = new kardsBuild(driver);
            kb.obtenerCodigoImportacion();
            kb.esperarWeb();
            // Thread.sleep(5000);
        } catch (Exception e) {
            Log.error("Causa : " + e.getCause());
            Log.error("Mensaje : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @BeforeTest
    @Parameters({ "browser", "nodeUrl" })
    public void SetUp(String browser, String nodeUrl) throws MalformedURLException {
        try {
            dfd = new DriverFactoryDirect();
            driver = dfd.setDriver(browser, nodeUrl);

        } catch (Exception exc) {
            Log.error("Causa : " + exc.getCause());
            Log.error("Mensaje : " + exc.getMessage());
            exc.printStackTrace();
        }
    }

    @AfterTest
    public void TearDown() {
        try {
            // driver.quit();
            dfd.quitDriver();
        } catch (Exception ex) {
            Log.error("Causa : " + ex.getCause());
            Log.error("Mensaje : " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}