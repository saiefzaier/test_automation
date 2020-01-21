package com.QA.steps.easyRun;

import com.QA.locators.AbcencesLocators;
import com.QA.locators.CommonLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CollaborateurManagerRH_RejetAbsence {

    private static final Logger logger = Logger.getLogger(CollaborateurManagerRH_RejetAbsence.class);
    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();

    @Then("Vérifier que l utilisateur reçoit une notification {string} et que le statut de la demande d absence devient Rejetée et que la demande d absence ne s affiche pas dans le calendrier")
    public void vérifierQueLUtilisateurReçoitUneNotificationEtQueLeStatutDeLaDemandeDAbsenceDevientRejetéeEtQueLaDemandeDAbsenceNeSAffichePasDansLeCalendrier(String textenotif) throws InterruptedException {

        driver.findElement(By.xpath(CommonLocators.Bouton_Notifications_Portal)).click();
        WebElement modules = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(CommonLocators.Première_Notification_Portal)));
        Assert.assertTrue(driver.findElement(By.xpath(CommonLocators.Première_Notification_Portal)).getAttribute("innerText").contains(textenotif));
        action.pause(driver,2000);
        driver.findElement(By.xpath(AbcencesLocators.Bouton_Mes_Absences)).click();
        Assert.assertEquals("Rejetée", driver.findElement(By.xpath(AbcencesLocators.Statut_Première_Absence_Mes_Absences)).getAttribute("innerText"));
        WebElement wb = CollaborateurManagerValidationAbsence.Jourlibre;
        Assert.assertTrue(wb.getAttribute("outerHTML").contains("style=\"background-color:"));


    }
}
