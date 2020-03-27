package com.QA.steps.easyRun;

import com.QA.locators.AbcencesLocators;
import com.QA.locators.CommonLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CollaborateurManagerRhValidationAbsence {

    private static final Logger logger = Logger.getLogger(CollaborateurManagerValidationAbsence.class);
    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();

    @And("Vérifier que la demande d'absence est déplacée au niveau de la rubrique Historique et que son statut devient Validée")
    public void vérifierQueLaDemandeDAbsenceEstDéplacéeAuNiveauDeLaRubriqueHistoriqueEtQueSonStatutDevientValidée() throws InterruptedException {

        logger.info("Vérification du déplacement de la demande vers l'historique et du changement de son statut vers validée");
        driver.findElement(By.cssSelector(AbcencesLocators.Bouton_Historique_Demandes_Absences)).click();
        action.pause(driver,4000);
        WebElement modules = (new WebDriverWait(driver, 40)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(AbcencesLocators.Statut_Première_Absence_Liste_Historique)));
        Assert.assertEquals("Validée", driver.findElement(By.cssSelector(AbcencesLocators.Statut_Première_Absence_Liste_Historique)).getAttribute("innerText"));

    }



    @Then("Vérifier que l utilisateur reçoit une notification {string} et que le statut de la demande d absence devient Validée et que la demande d absence s affiche dans le calendrier")
    public void vérifierQueLUtilisateurReçoitUneNotificationEtQueLeStatutDeLaDemandeDAbsenceDevientValidéeEtQueLaDemandeDAbsenceSAfficheDansLeCalendrier(String textenotif) throws InterruptedException {

        driver.findElement(By.xpath(CommonLocators.Bouton_Notifications_Portal)).click();
        WebElement modules = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(CommonLocators.Première_Notification_Portal)));
        Assert.assertTrue(driver.findElement(By.xpath(CommonLocators.Première_Notification_Portal)).getAttribute("innerText").contains(textenotif));
        action.pause(driver,2000);
        driver.findElement(By.xpath(AbcencesLocators.Bouton_Mes_Absences)).click();
        Assert.assertEquals("Validée", driver.findElement(By.xpath(AbcencesLocators.Statut_Première_Absence_Mes_Absences)).getAttribute("innerText"));
        WebElement wb = driver.findElement(By.cssSelector(CollaborateurManagerValidationAbsence.Jourlibre));
        Assert.assertEquals(wb.getAttribute("title"), ActionsCommunes.DataProvider("Motif_d_absence_Ajout_Demande_Absence_Collaborateur"));

    }


}
