package com.QA.base;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ConfigBasiqueWebDriver {

    private static final Logger logger = Logger.getLogger(String.valueOf(ConfigBasiqueWebDriver.class));
    private static WebDriver driver = null;


    public static WebDriver get() {


        FirefoxOptions optionsF = new FirefoxOptions();
        optionsF.addArguments("start-maximized");
        optionsF.addArguments("enable-automation");
        optionsF.addArguments("--no-sandbox");
        optionsF.addArguments("--disable-infobars");
        optionsF.addArguments("--disable-dev-shm-usage");
        optionsF.addArguments("--disable-browser-side-navigation");
        optionsF.addArguments("--disable-gpu");

        ChromeOptions optionsC = new ChromeOptions();
        optionsC.addArguments("start-maximized");
        optionsC.addArguments("enable-automation");
        optionsC.addArguments("--no-sandbox");
        optionsC.addArguments("--disable-infobars");
        optionsC.addArguments("--disable-dev-shm-usage");
        optionsC.addArguments("--disable-browser-side-navigation");
        optionsC.addArguments("--disable-gpu");




        if (System.getProperty("RemoteInDocker").equalsIgnoreCase("true")) {

            URL grid = null;
            try {
                grid = new URL(streams.readers().getProperty("remoteURL"));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            switch (System.getProperty("browser")) {

                case "chrome":
                    logger.info("Lancement d'un navigateur chrome dans un docker container ");
                    optionsC.addArguments("--window-size=1920,1080");
                    driver = new RemoteWebDriver(grid, optionsC);
                    ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                    break;

                case "firefox":
                    logger.info("Lancement d'un navigateur firefox dans un docker container ");
                    optionsF.addArguments("--window-size=1920,1080");
                    driver = new RemoteWebDriver(grid, optionsF);
                    ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                    break;

                case "chrome-headless":
                    ChromeOptions optionsCh = new ChromeOptions();
                    optionsCh.addArguments("--headless");
                    optionsCh.addArguments("start-maximized");
                    optionsCh.addArguments("--window-size=1920,1080");
                    optionsCh.addArguments("enable-automation");
                    optionsCh.addArguments("--no-sandbox");
                    optionsCh.addArguments("--disable-infobars");
                    optionsCh.addArguments("--disable-dev-shm-usage");
                    optionsCh.addArguments("--disable-browser-side-navigation");
                    optionsCh.addArguments("--disable-gpu");
                    logger.info("Lancement d'un navigateur chrome en mode Headless dans un docker container");
                    driver = new RemoteWebDriver(grid, optionsCh);
                    break;

                default:
                    logger.warning("le choix du navigateur n'est pas correct");

            }

        } else if (System.getProperty("RemoteInDocker").equalsIgnoreCase("false")) {

            switch (System.getProperty("browser")) {

                case "chrome":
                    logger.info("Lancement d'un navigateur chrome pour les tests");
                    if (System.getProperty("os.name").toLowerCase().contains("wind")) {
                        System.setProperty("webdriver.chrome.driver", streams.readers().getProperty("ChromeDriverPath"));
                    } else {
                        WebDriverManager.chromedriver().setup();
                    }
                    driver = new ChromeDriver(optionsC);
                    break;

                case "chrome-headless":
                    ChromeOptions optionsCh = new ChromeOptions();
                    optionsCh.addArguments("--headless");
                    optionsCh.addArguments("start-maximized");
                    optionsCh.addArguments("--window-size=1920,1080");
                    optionsCh.addArguments("enable-automation");
                    optionsCh.addArguments("--no-sandbox");
                    optionsCh.addArguments("--disable-infobars");
                    optionsCh.addArguments("--disable-dev-shm-usage");
                    optionsCh.addArguments("--disable-browser-side-navigation");
                    optionsCh.addArguments("--disable-gpu");

                    logger.info("Lancement d'un navigateur chrome en mode Headless pour les tests");

                    if (System.getProperty("os.name").toLowerCase().contains("wind")) {
                        System.setProperty("webdriver.chrome.driver", streams.readers().getProperty("ChromeDriverPath"));
                        driver = new ChromeDriver(optionsCh);
                    } else {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver(optionsCh);
                    }
                    break;

                case "firefox":
                    logger.info("Lancement d'un navigateur firefox pour les tests");
                    if (System.getProperty("os.name").toLowerCase().contains("wind")) {
                        System.setProperty("webdriver.gecko.driver", streams.readers().getProperty("FirefoxDriverPath"));
                        driver = new FirefoxDriver(optionsF);
                    } else {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver(optionsF);
                    }
                    break;

                case "IE":
                    logger.info("Lancement d'un navigateur Internet Explorer pour les tests");
                    System.setProperty("webdriver.ie.driver", streams.readers().getProperty("IeDriverPath"));
                    driver = new InternetExplorerDriver();
                    break;

                default:
                    logger.info("Le choix du navigateur local n'est pas bien configuré");
            }


        }

        try {

            assert driver != null;
            driver.manage().timeouts().implicitlyWait(Long.parseLong(streams.readers().getProperty("Implicitwait")), TimeUnit.SECONDS);
        } catch (NullPointerException e) {

            System.out.println("Le navigateur est introuvable");

        }

        return driver;
    }


}

