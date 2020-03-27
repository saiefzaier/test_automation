package com.QA.steps.connect.anniversaire;

import com.QA.locators.AnniversaireLocators;
import com.QA.locators.CommonLocators;
import com.QA.locators.GestionDuPersonnel;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;
import java.util.List;

public class WidgetAnniversairePersonnelAutoriséRH {

    private final WebDriver driver = GenerateurDriver.driver;
    private static String Nom_User;
    private static String Date_Anniv_Perso_User;
    private Throwable NoSuchElementException;
    private static final Logger logger = Logger.getLogger(GenerateurDriver.class);
    @Then("verifier que la date n est pas affichée dans le widget")
    public void verifierQueLaDateNEstPasAffichéeDansLeWidget() throws Throwable {
        String jour_birthday_perso;
        String mois_birthday_perso;
        String date_birthday_perso_widget;
        System.out.println("LE NOM DU USER EST"+Nom_User+"LA DATE DU USER EST"+ Date_Anniv_Perso_User);
        if (Date_Anniv_Perso_User.charAt(0)=='0')
        {
            jour_birthday_perso= String.valueOf(Date_Anniv_Perso_User.charAt(1));

        }
        else
        {
            jour_birthday_perso = Date_Anniv_Perso_User.substring(0,2);
        }
        mois_birthday_perso = Date_Anniv_Perso_User.substring(3, 5);
        switch (mois_birthday_perso) {
            case "01":
                mois_birthday_perso = "Jan";
                break;
            case "02":
                mois_birthday_perso = "Feb";
                break;
            case "03":
                mois_birthday_perso = "Mar";
                break;
            case "04":
                mois_birthday_perso = "Apr";
                break;
            case "05":
                mois_birthday_perso = "May";
                break;
            case "06":
                mois_birthday_perso = "Jun";
                break;
            case "07":
                mois_birthday_perso = "Jul";
                break;
            case "08":
                mois_birthday_perso = "Aug";
                break;
            case "09":
                mois_birthday_perso = "Sep";
                break;
            case "10":
                mois_birthday_perso = "Oct";
                break;
            case "11":
                mois_birthday_perso = "Nov";
                break;
            case "12":
                mois_birthday_perso="Dec";
                break;
            default:
                logger.info("Date d'anniversaire est vide");
                throw NoSuchElementException;
        }
     date_birthday_perso_widget=jour_birthday_perso+" "+mois_birthday_perso;
        List<WebElement> listeannivperso = driver.findElements(By.cssSelector(AnniversaireLocators.Liste_Anniversaire));
        boolean exist=false;
        for (WebElement lap :listeannivperso)
        {
            String str=lap.getAttribute("innerText");
            if (str.contains(Nom_User)&& str.contains(date_birthday_perso_widget))
            {
                exist=true;
                break;
            }
        }
        Assert.assertFalse(exist);
    }

    @And("l utilisateur verifie le nom et la date personnel du collaborateur")
    public void lUtilisateurVerifieLeNomEtLaDatePersonnelDuCollaborateur() {


        Nom_User=driver.findElement(By.xpath(GestionDuPersonnel.NomUser)).getAttribute("innerText");
        Date_Anniv_Perso_User=driver.findElement(By.xpath(GestionDuPersonnel.DateDeNaissance_DossierIndividuel)).getAttribute("value");

    }
}
