package com.QA.steps;

import com.QA.base.ConfigBasiqueWebDriver;
import com.QA.base.streams;
import cucumber.api.java.After;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class GenerateurDriver {

    private static final Logger logger = Logger.getLogger(GenerateurDriver.class);
    private static Scenario scenario;
    public static WebDriver driver = null;


    @Before
    public void DemarrageScenarioTest(Scenario scenario) {
        GenerateurDriver.scenario = scenario;
        if (driver == null) {
            driver = ConfigBasiqueWebDriver.get();
        }
        EtapesCommunes.listededonnees.clear();
        logger.info("Début scénario " + scenario.getName());

    }

    @After
    public static void ArretScenarioTest(Scenario scenario) {
        GenerateurDriver.scenario = scenario;
        if (scenario.isFailed()){
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),"image/png");
        }
        logger.info("Fin scénario " + scenario.getName());
        driver.manage().deleteAllCookies();
        driver.get(streams.readers().getProperty("testsiteurl"));
    }

}
