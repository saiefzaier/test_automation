package com.QA.base;




import com.QA.steps.GenerateurDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        plugin = {"json:target/reports/cucumber.json"},
        glue = {"com.QA.steps"}
)

public class TestGenerateurDriverInit {

    private static final Logger logger = Logger.getLogger(TestGenerateurDriverInit.class);
    public static List<List<Field>> ListeGlobaleLocators = new ArrayList<>();

    @BeforeClass
    public static void SetupClass() {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);
        logger.info("Configuration de l'environnement de test");


        logger.info("Configuration terminée");
    }

    @AfterClass
    public static void TearDown() {
       logger.info("Fin des tests, fermeture du navigateur et génération des rapports");
       ListeGlobaleLocators.clear();
       GenerateurDriver.driver.quit();
    }

}





