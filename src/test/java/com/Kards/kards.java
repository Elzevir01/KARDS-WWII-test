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

    private static Logger Log = LogManager.getLogger(kards.class);

    @Test
    public void Test_1_idioma() {
        try {
            km = new kardsMain(driver);
            String url = "https://www.kards.com/";
            km.navegar(url);
            km.seleccionarIdiomaEspañol();
            km.seleccionarDeckBuilder();
            Thread.sleep(5000);

        } catch (Exception e) {
            Log.error("Causa : " + e.getCause());
            Log.error("Mensaje : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void Test_2_naciones() {
        try {
            kn = new kardsNacion(driver);
            kn.seleccionarNacion();

        } catch (Exception e) {
            Log.error("Causa : " + e.getCause());
            Log.error("Mensaje : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(priority = 3, dataProvider = "deckCards", dataProviderClass = DeckRecipe.class)
    public void Test_3_seleccionarCartas(By carta, int numero, String nombre) {
        kb = new kardsBuild(driver);

        Log.info("Buscando y agregando: " + nombre + " :: numero de veces: " + numero + "");

        // ---generar mazo---//

        // kb.esperarElemento(carta);
        // kb.findElemento(carta).click();
        kb.buscarCarta(nombre, carta, numero);
    }

    @Test
    public void Test_4_generarCodigoMazo() {
        kb = new kardsBuild(driver);
        kb.obtenerCodigoImportacion();
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