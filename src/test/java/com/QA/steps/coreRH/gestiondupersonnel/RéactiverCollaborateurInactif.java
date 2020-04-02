package com.QA.steps.coreRH.gestiondupersonnel;

import com.QA.base.streams;
import com.QA.locators.GestionDuPersonnel;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.EtapesCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Properties;

public class RéactiverCollaborateurInactif {

    private static final Logger logger = Logger.getLogger(EtapesCommunes.class);
    private final WebDriver driver = GenerateurDriver.driver;
    private static final Properties reader;
    private ActionsCommunes action = new ActionsCommunes();
    public static List<String> listededonnees =EtapesCommunes.listededonnees;
    public Actions actions = new Actions(driver);

    static {
        reader = streams.readers();
    }

    @And("vérifier que l'utilisateur est actif")
    public void vérifierQueLUtilisateurEstActif() {
        logger.info("Vérifier que le collaborateur est Actif");
        WebElement statusCollaborateur=driver.findElement(By.xpath(GestionDuPersonnel.Status_Collaborateur));

        Boolean verifStatutActif = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.textToBePresentInElement(statusCollaborateur,"Actif"));

        Assert.assertTrue(verifStatutActif);
    }


}
