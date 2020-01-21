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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CollaborateurManagerValidationAbsence {

    private static final Logger logger = Logger.getLogger(CollaborateurManagerValidationAbsence.class);
    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();
    private static String etat = "Pas encore";
    public static WebElement Jourlibre;
    List<List<WebElement>> listejours = null;

    @And("l utilisateur selectionne une case de journée libre dans le calendrier")
    public void lUtilisateurSelectionneUneCaseDeJournéeLibreDansLeCalendrier() {

        logger.info("Recherche d'une journée libre");
        WebElement modules = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath(AbcencesLocators.Bouton_Avance_Mois_Calendrier_Ajout_Abcence)));
        listejours.add(driver.findElements(By.cssSelector("fc-day ui-widget-content fc-mon fc-future")));
        listejours.add(driver.findElements(By.cssSelector("fc-day ui-widget-content fc-tue fc-future")));
        listejours.add(driver.findElements(By.cssSelector("fc-day ui-widget-content fc-wed fc-future")));
        listejours.add(driver.findElements(By.cssSelector("fc-day ui-widget-content fc-thu fc-future")));
        listejours.add(driver.findElements(By.cssSelector("fc-day ui-widget-content fc-fri fc-future")));
        while (etat.equals("Pas encore")) {
            for (List<WebElement> L : listejours) {
                for (WebElement jour : L) {
                    if (!jour.getAttribute("outerHTML").contains("style=\"background-color:")) {

                        Jourlibre = jour;
                        JavascriptExecutor executor = (JavascriptExecutor) driver;
                        executor.executeScript("arguments[0].click();", jour);
                        etat = "Jour trouvé";
                        break;
                    }
                    if (etat.equals("Jour trouvé")) {
                        break;
                    }
                }
            }
            if (etat.equals("Jour trouvé")) {
                break;
            } else {
                driver.findElement(By.xpath(AbcencesLocators.Bouton_Avance_Mois_Calendrier_Ajout_Abcence)).click();
                listejours.add(driver.findElements(By.cssSelector("fc-day ui-widget-content fc-mon fc-future")));
                listejours.add(driver.findElements(By.cssSelector("fc-day ui-widget-content fc-tue fc-future")));
                listejours.add(driver.findElements(By.cssSelector("fc-day ui-widget-content fc-wed fc-future")));
                listejours.add(driver.findElements(By.cssSelector("fc-day ui-widget-content fc-thu fc-future")));
                listejours.add(driver.findElements(By.cssSelector("fc-day ui-widget-content fc-fri fc-future")));
            }
        }
        logger.info("Journée libre trouvée");
    }

    @And("l'utilisateur upload un justificatif")
    public void lUtilisateurUploadUnJustificatif() throws InterruptedException {
        logger.info("Uplaod d'un justificatif");
        driver.findElement(By.id(AbcencesLocators.Upload_Justificatif_Ajout_Demande_Absence)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/imagespourtest/imagetest.jpg");
        action.pause(driver, 500);

    }

    @And("vérifier que le statut de la demande devient En cours")
    public void vérifierQueLeStatutDeLaDemandeDevientEnCours() {

        Assert.assertTrue(driver.findElement(By.xpath(AbcencesLocators.Profil_Initiateur_Absence_Liste_Absence)).getAttribute("innerText").contains(ActionsCommunes.DataProvider("Population_Affectation_Population_Motif_Abcence")));
        Assert.assertTrue(driver.findElement(By.xpath(AbcencesLocators.Profil_Backup_Absence_Liste_Absence)).getAttribute("innerText").contains(ActionsCommunes.DataProvider("Backup_Ajout_Demande_Absence_Collaborateur")));
        Assert.assertTrue(driver.findElement(By.xpath(AbcencesLocators.Statut_Nouvelle_Demande_Absence)).getAttribute("innerText").contains("En cours"));

    }

    @And("l'utilisateur vérifie que le statut de la journée type est Actif")
    public void lUtilisateurVérifieQueLeStatutDeLaJournéeTypeEstActif() {

        Assert.assertEquals("form-control input-sm ng-valid ng-touched ng-pristine", driver.findElement(By.xpath(CommonLocators.Statut_Ajout_Journée_Type)).getAttribute("className"));
    }


    @And("l'utilisateur vérifie que le statut du cycle de travail est Actif")
    public void lUtilisateurVérifieQueLeStatutDuCycleDeTravailEstActif() {

        Assert.assertEquals("form-control input-sm ng-untouched ng-pristine ng-valid", driver.findElement(By.xpath(CommonLocators.Statut_Ajout_Cycle_De_Travail)).getAttribute("className"));
    }


}
