package dataDeck;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class DeckRecipe {

    String xpathCarta1 = "(//div[contains(@class,'Card_card__face__EiVqg')])[1]";
    String xpathCarta2 = "(//div[contains(@class,'Card_card__face__EiVqg')])[2]";
    ///// WEB ELEMENT CARTA/////

    private By card1 = By.xpath(xpathCarta1);
    private By card2 = By.xpath(xpathCarta2);

    private By k511PIR = By.xpath(xpathCarta1);
    // x3
    private By k15DESTACAMIENTO = By.xpath(xpathCarta1);
    // x2
    private By k4ALABAMA = By.xpath(xpathCarta1);
    private By kELPAISDELALIBERTAD = By.xpath(xpathCarta1);
    private By k1ATROPA = By.xpath(xpathCarta1);
    private By kPUENTEDEBARCAS = By.xpath(xpathCarta1);
    private By kFUEGOAMIGO = By.xpath(xpathCarta1);
    private By kLESTERRIBLE = By.xpath(xpathCarta1);
    private By kMUJERESENLAFUERZALABORAL = By.xpath(xpathCarta1);
    private By k13BATALLON = By.xpath(xpathCarta1);
    private By kLOTASVARD = By.xpath(xpathCarta1);
    private By k175REGIMIENTO = By.xpath(xpathCarta1);
    private By kSISU = By.xpath(xpathCarta1);
    private By k4MARINES = By.xpath(xpathCarta1);
    private By kUSSMISSOURI = By.xpath(xpathCarta1);
    private By kLAMUERTEBLANCA = By.xpath(xpathCarta1);
    private By k5BATALLONMEDICOS = By.xpath(xpathCarta1);
    private By kELTIO = By.xpath(xpathCarta1);
    private By kFUERZADEVASTADORA = By.xpath(xpathCarta1);
    private By k13REGIMIENTO = By.xpath(xpathCarta1);

    //// DATA PROVIDER DEL MAZO ////
    @DataProvider(name = "deckCards")
    public Object[][] cardData() {
        return new Object[][] {
                //// --WEB ELEMENT, NUMERO DE REPETICION, NOMBRE DE CARTA-- ////
                { k511PIR, 3, "511.º PIR" },
                { k15DESTACAMIENTO, 2, "15.º DESTACAMENTO" },
                { k4ALABAMA, 1, "4.º ALABAMA" },
                { kELPAISDELALIBERTAD, 1, "EL PAÍS DE LA LIBERTAD" },
                { k1ATROPA, 3, "1.ª TROPA DE CABALLERÍA" },
                { kPUENTEDEBARCAS, 3, "PUENTE DE BARCAS" },
                { kFUEGOAMIGO, 3, "FUEGO AMIGO" },
                { kLESTERRIBLE, 3, "LES TERRIBLE" },
                { kMUJERESENLAFUERZALABORAL, 1, "MUJERES EN LA FUERZA LABORAL" },
                { k13BATALLON, 1, "13.º BATALLÓN DE INGENIEROS" },
                { kLOTASVARD, 1, "LOTTA SVARD" },
                { k175REGIMIENTO, 4, "175.º REGIMIENTO DE INFANTERÍA" },
                { kSISU, 3, "SISU" },
                { k4MARINES, 2, "4.º MARINES" },
                { kUSSMISSOURI, 1, "USS MISSOURI" },
                { kLAMUERTEBLANCA, 1, "LA MUERTE BLANCA" },
                { k5BATALLONMEDICOS, 1, "5.º BATALLÓN DE MÉDICOS" },
                { kELTIO, 1, "EL TÍO SAM" },
                { kFUERZADEVASTADORA, 2, "FUERZA DEVASTADORA" },
                { k13REGIMIENTO, 2, "13.º REGIMIENTO DE INFANTERÍA" }
        };
    }
}
