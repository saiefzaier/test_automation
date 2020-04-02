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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class VerifierCollaborateurInactif {

    private static final Logger logger = Logger.getLogger(EtapesCommunes.class);
    private final WebDriver driver = GenerateurDriver.driver;
    private static final Properties reader;
    private ActionsCommunes action = new ActionsCommunes();
    public static List<String> listededonnees = EtapesCommunes.listededonnees;
    public Actions actions = new Actions(driver);

    static {
        reader = streams.readers();
    }

    @And("l utilisateur choisit une date de sortie")
    public void LutilisateurChoisitDateDeSortie() throws Exception {
        logger.info("l utilisateur choisit une date de sortie");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateEntrée = formatter.parse(driver.findElement(By.xpath(GestionDuPersonnel.Date_Entrée_Entrée_Sortie)).getAttribute("value"));
        String dateEntréFormatée = formatter.format(dateEntrée);
        logger.info("Date Entrée " + dateEntréFormatée);
        Date dateSystéme = new Date();
        String dateSystémeFormatée = formatter.format(dateSystéme);
        WebElement inputSortie = driver.findElement(By.xpath(GestionDuPersonnel.Date_Sortie_Entrée_Sortie));
        logger.info("Date Systéme " + dateSystémeFormatée);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateEntrée);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        Date dateSortie = calendar.getTime();
        String dateSortieFormatée = formatter.format(dateSortie);
        if (dateSortie.after(dateSystéme)) {
            throw new IllegalArgumentException("La date d'embauche n'est pas en 2019 ");
        }
        inputSortie.sendKeys(dateSortieFormatée);
    }

    @And("vérifier que l'utilisateur est inactif")
    public void vérifierQueLUtilisateurEstInactif() {
        logger.info("Vérifier que le collaborateur est Inactif");
        WebElement statusCollaborateur = driver.findElement(By.xpath(GestionDuPersonnel.Status_Collaborateur));

        Boolean verifStatutInactif = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.textToBePresentInElement(statusCollaborateur, "Inactif"));

        Assert.assertTrue(verifStatutInactif);
    }
}






