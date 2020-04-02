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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class VérifierCollaborateurInactifCasKO {

    private static final Logger logger = Logger.getLogger(EtapesCommunes.class);
    private final WebDriver driver = GenerateurDriver.driver;
    private static final Properties reader;
    private ActionsCommunes action = new ActionsCommunes();
    public static List<String> listededonnees =EtapesCommunes.listededonnees;
    public Actions actions = new Actions(driver);

    static {
        reader = streams.readers();
    }

    @And("l utilisateur choisit une date de sortie inférieure a la date d'embauche")
    public void ChoisirUneDateDeSortieInférieureaLaDateEntrée() throws ParseException {
        logger.info("l utilisateur choisit une date de sortie inférieure a la date d'embauche");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateEntrée = formatter.parse(driver.findElement(By.xpath(GestionDuPersonnel.Date_Entrée_Entrée_Sortie)).getAttribute("value"));
        String dateEntréFormatée = formatter.format(dateEntrée);
        logger.info("Date Entrée " + dateEntréFormatée);
        WebElement inputSortie = driver.findElement(By.xpath(GestionDuPersonnel.Date_Sortie_Entrée_Sortie));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateEntrée);
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        Date dateSortie = calendar.getTime();
        String dateSortieFormatée = formatter.format(dateSortie);
        logger.info("Date Sortie " + dateSortieFormatée);
        inputSortie.clear();
        inputSortie.sendKeys(dateSortieFormatée);

    }

    @And("l utilisateur choisit une date de sortie égale a la date d'embauche")
    public void lUtilisateurChoisitUneDateDeSortieÉgaleALaDateDEmbauche() throws ParseException {
        logger.info("l utilisateur choisit une date de sortie égale a la date d'embauche");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateEntrée = formatter.parse(driver.findElement(By.xpath(GestionDuPersonnel.Date_Entrée_Entrée_Sortie)).getAttribute("value"));
        String dateEntréFormatée = formatter.format(dateEntrée);
        logger.info("Date Entrée " + dateEntréFormatée);
        WebElement inputSortie = driver.findElement(By.xpath(GestionDuPersonnel.Date_Sortie_Entrée_Sortie));
        String dateSortieFormatée = formatter.format(dateEntrée);
        logger.info("Date Sortie " + dateSortieFormatée);
        inputSortie.clear();
        inputSortie.sendKeys(dateSortieFormatée);
    }



    @And("Vérifier l affichage du message d erreur {string} sous le champs Date de sortie")
    public void vérifierLAffichageDuMessageDErreurSousLeChampsDateDeSortie(String messageErreur) {
        WebElement messageErreurDateSortie=(new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GestionDuPersonnel.Message_Erreur_Date_Sortie)));
        Boolean verifText=messageErreurDateSortie.getText().equals(messageErreur);
        Assert.assertTrue(verifText);
    }

}