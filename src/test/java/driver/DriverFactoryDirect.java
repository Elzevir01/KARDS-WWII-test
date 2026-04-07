package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class DriverFactoryDirect {

    private WebDriver driver;

    public WebDriver setDriver(String browser, String nodeURL) throws MalformedURLException {
        // String nodeURL = "http://selenium-hub-c:4444/wd/hub";
        if (driver == null) {
            switch (browser.toString().toUpperCase()) {
                case "CHROME":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new RemoteWebDriver(URI.create(nodeURL).toURL(), chromeOptions);
                    break;
                case "FIREFOX":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver = new RemoteWebDriver(URI.create(nodeURL).toURL(), firefoxOptions);
                    break;
                case "EDGE":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    driver = new RemoteWebDriver(URI.create(nodeURL).toURL(), edgeOptions);
                    break;

            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            try {
                System.out.println("Cerrando navegador...");
                driver.quit();
                driver = null;
            } catch (Exception e) {
                System.out.println("Error quit driver: " + e);
            }
        }
    }

}