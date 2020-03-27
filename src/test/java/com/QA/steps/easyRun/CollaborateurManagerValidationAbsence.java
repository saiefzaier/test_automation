package com.QA.steps.easyRun;

import com.QA.base.streams;
import com.QA.locators.AbcencesLocators;
import com.QA.locators.CommonLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class CollaborateurManagerValidationAbsence {

    private static final Logger logger = Logger.getLogger(CollaborateurManagerValidationAbsence.class);
    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();

    public static String Jourlibre;
    List<WebElement> listejours = null;
    public Actions actions = new Actions(driver);
    Wait wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(2))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(NoSuchElementException.class);


    @And("l utilisateur selectionne une case de journée libre dans le calendrier")
    public void lUtilisateurSelectionneUneCaseDeJournéeLibreDansLeCalendrier() throws InterruptedException {

        logger.info("Recherche d'une journée libre");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String etat = "Pas encore";
        int semaine;
        int jour;
        String locator;
        String locator1;
        String locator2;
        Object jourabsence = null;
        Object jourabsence1 = null;
        String[] joursdelasemaine = new String[]{" ", ".fc-mon", ".fc-tue", ".fc-wed", ".fc-thu", ".fc-fri", ".fc-sat", ".fc-sun"};

        while (etat.equals("Pas encore")) {
            for (semaine = 1; semaine < 7; semaine++) {
                for (jour = 1; jour < 8; jour++) {
                    action.pause(driver, 3000);
                    locator = (".fc-week:nth-child(" + semaine + ") > .fc-bg .fc-day:not([style]):nth-child(" + jour + ")");
                    locator1 = (".fc-week:nth-child(" + semaine + ") > .fc-bg .fc-day:not([style]):nth-child(" + jour + ") .absence-wrapper");
                    try {
                        action.pause(driver, 3000);
                        jourabsence = driver.findElement(By.cssSelector(locator));
                        jourabsence1 = driver.findElement(By.cssSelector(locator1));
                    } catch (NoSuchElementException ignore) {
                    }
                    if (!(jourabsence == null)) {
                        if (jourabsence1 == null) {
                            locator2 = ".fc-row:nth-child(" + semaine + ") > .fc-content-skeleton " + joursdelasemaine[jour];
                            System.out.println(locator2);
                            Jourlibre = locator1;
                            actions.moveToElement(driver.findElement(By.cssSelector(locator2))).clickAndHold().perform();
                            driver.findElement(By.cssSelector(".fc-highlight")).click();
                            WebElement modules1 = (new WebDriverWait(driver, 10))
                                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(AbcencesLocators.Popup_Ajout_Absences_Header)));
                            etat = "Jour trouvé";
                            break;
                        }
                        jourabsence1 = null;
                        jourabsence = null;
                    }
                }
                if (!etat.equals("Pas encore")) {
                    break;
                }
            }
            driver.findElement(By.xpath(AbcencesLocators.Bouton_Avance_Mois_Calendrier_Ajout_Abcence)).click();
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(streams.readers().getProperty("Implicitwait")), TimeUnit.SECONDS);

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

        WebElement modules = (new WebDriverWait(driver, 40))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AbcencesLocators.Profil_Initiateur_Absence_Liste_Absence)));
        //Assert.assertTrue(driver.findElement(By.xpath(AbcencesLocators.Profil_Initiateur_Absence_Liste_Absence)).getAttribute("innerText").contains(ActionsCommunes.DataProvider("Population_Affectation_Population_Motif_Abcence")));
        Assert.assertTrue(driver.findElement(By.xpath(AbcencesLocators.Profil_Initiateur_Absence_Liste_Absence)).getAttribute("innerText").contains("Cosette Berger"));
        //Assert.assertTrue(driver.findElement(By.xpath(AbcencesLocators.Profil_Backup_Absence_Liste_Absence)).getAttribute("innerText").contains(ActionsCommunes.DataProvider("Backup_Ajout_Demande_Absence_Collaborateur")));
        Boolean modules1 = (new WebDriverWait(driver, 40))
                .until(ExpectedConditions.attributeToBe(driver.findElement(By.xpath(AbcencesLocators.Statut_Nouvelle_Demande_Absence)), "title", "En cours"));
        Assert.assertTrue(driver.findElement(By.xpath(AbcencesLocators.Statut_Nouvelle_Demande_Absence)).getAttribute("title").contains("En cours"));

    }

    @And("l'utilisateur vérifie que le statut de la journée type est Actif")
    public void lUtilisateurVérifieQueLeStatutDeLaJournéeTypeEstActif() {

        Assert.assertEquals("true", driver.findElement(By.xpath(CommonLocators.Statut_Ajout_Journée_Type)).getAttribute("checked"));
    }


    @And("l'utilisateur vérifie que le statut du cycle de travail est Actif")
    public void lUtilisateurVérifieQueLeStatutDuCycleDeTravailEstActif() {

        Assert.assertEquals("true", driver.findElement(By.xpath(CommonLocators.Statut_Ajout_Cycle_De_Travail)).getAttribute("checked"));
    }


}
