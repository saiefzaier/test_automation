package com.QA.steps.coreRH.onboarding;

import com.QA.locators.OnboardingLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModificationOnboarding {

    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();
    private static final Logger logger = Logger.getLogger(ModificationOnboarding.class);


    @And("vérifier la modification du nom de l'onboarding")
    public void vérifierLaModificationDuNomDeLOnboarding() throws InterruptedException {

        logger.info("Vérification de l'enregistrment correct la modification");
        String nouveautemplate = "a.no-icon span[title=\"" + ActionsCommunes.DataProvider("Nom_du_template_onboarding_Modifie") + "\"]";
        WebElement modules = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(nouveautemplate)));
        driver.findElement(By.cssSelector("a.no-icon span[title=\"" + ActionsCommunes.DataProvider("Nom_du_template_onboarding_Modifie") + "\"]+i")).click();
        action.pause(driver,1000);
        Assert.assertEquals(driver.findElement(By.xpath(OnboardingLocators.Durée_d_affichage_en_mois_onboarding_Modifié)).getAttribute("value"), ActionsCommunes.DataProvider("Durée_d_affichage_en_mois_onboarding_Modifié"));

    }
}
