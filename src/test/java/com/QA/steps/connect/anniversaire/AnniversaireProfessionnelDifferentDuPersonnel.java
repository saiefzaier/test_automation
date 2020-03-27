package com.QA.steps.connect.anniversaire;

import com.QA.locators.AnniversaireLocators;
import com.QA.locators.GestionDuPersonnel;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static java.lang.System.*;
import static org.junit.Assert.*;

public class AnniversaireProfessionnelDifferentDuPersonnel {
    private final WebDriver driver = GenerateurDriver.driver;
    public String date_embauche;
    public String jour_embauche;
    public String mois_embauche;
    public String mois_embauche_l;
    public static String date_embauche_l;
    private Throwable NoSuchElementException;
    private static final Logger logger = Logger.getLogger(GenerateurDriver.class);
    @Then("l administrateur va cocher le bouton d affichage de l anniversaire professionnel")
    public void lAdministrateurVaCocherLeBoutonDAffichageDeLAnniversaireProfessionnel() {

        boolean test = driver.findElement(By.xpath(AnniversaireLocators.Check_Box_AnniversaireProfessionnel_Rh)).isSelected();
        if(!test){
            driver.findElement(By.xpath(AnniversaireLocators.Check_Box_AnniversaireProfessionnel_Rh_Click)).click();
        }

    }

    @And("l utilisateur verifie la date d'anniversaire professionnel")
    public void lUtilisateurVerifieLaDateDAnniversaireProfessionnel() throws Throwable {

    date_embauche = driver.findElement(By.xpath(GestionDuPersonnel.DateDentree)).getAttribute("innerText");
        if (date_embauche.isEmpty()) {
            logger.info("Date d'entrée est obligatoire");
            throw NoSuchElementException;
        }
        else {

            jour_embauche = date_embauche.substring(0, 2);
            mois_embauche = date_embauche.substring(3, 5);

    switch (mois_embauche) {
        case "01":
            mois_embauche_l = "Janvier";
            break;
        case "02":
            mois_embauche_l = "Fevrier";
            break;
        case "03":
            mois_embauche_l = "Mars";
            break;
        case "04":
            mois_embauche_l = "Avril";
            break;
        case "05":
            mois_embauche_l = "Mai";
            break;
        case "06":
            mois_embauche_l = "Juin";
            break;
        case "07":
            mois_embauche_l = "Juillet";
            break;
        case "08":
            mois_embauche_l = "Aout";
            break;
        case "09":
            mois_embauche_l = "Septembre";
            break;
        case "10":
            mois_embauche_l = "Octobre";
            break;
        case "11":
            mois_embauche_l = "Novembre";
            break;
        case "12":
            mois_embauche_l = "Decembre";

        default:
            logger.info("Date d'entrée est vide");
            throw NoSuchElementException;
    }}


            date_embauche_l = jour_embauche + " " + mois_embauche_l;

        }


    @Then("verifier que la date danniversaire professionnel est la meme")
    public void verifierQueLaDateDanniversaireProfessionnelEstLaMeme() {
     String  str1= driver.findElement(By.xpath(AnniversaireLocators.Anniversaire_Professionnel_Profil_Enrichi)).getAttribute("innerText");
        Assert.assertEquals(str1, date_embauche_l);


    }




}
