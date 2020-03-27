package com.QA.steps.connect.anniversaire;
import com.QA.locators.AnniversaireLocators;
import com.QA.locators.CommonLocators;
import com.QA.locators.GestionDuPersonnel;
import com.QA.locators.TimelineLocators;
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

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AnniversairePersoWidget {

    private Throwable NoSuchElementException;
    private static final Logger logger = Logger.getLogger(GenerateurDriver.class);
    private static String demain_date;
    private String annee_anniversaire="/1992";
    private static String date_anniversaire;
    public Date date;
    private Format formatter;
    private ActionsCommunes action = new ActionsCommunes();
    private final WebDriver driver = GenerateurDriver.driver;
    private boolean birthday;

    @And("l utilisateur modifie la date de l anniversaire")
    public void lUtilisateurModifieLaDateDeLAnniversaire() throws InterruptedException {
        String str="Opération effectuée avec succès";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 247);
        date = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        demain_date= formatter.format(date);
        date_anniversaire=demain_date.substring(0, 5)+annee_anniversaire;
        System.out.println(date_anniversaire);
        action.pause(driver, 1000);
        driver.findElement(By.xpath(GestionDuPersonnel.DateDeNaissance_DossierIndividuel)).clear();
        action.pause(driver,500);
        driver.findElement(By.xpath(GestionDuPersonnel.DateDeNaissance_DossierIndividuel)).sendKeys(date_anniversaire);
        action.pause(driver,500);


    }

    @Then("verifier que l anniversaire personnel de l utilisateur est affiche")
    public void verifierQueLAnniversairePersonnelDeLUtilisateurEstAffiche() throws Throwable {

        String str;
        String before_css="a.list-group-item:nth-child(";
        String after_css_perso=") .fa-birthday-cake";
        String after_css_pro=") .fa-calendar";
        String actual_css_perso="";
        String actual_css_pro="";
        String mois_anniversaire;
        String jour_anniversaire;
        String mois_anniversaire_l;
        String date_anniversaire_portal;
        int emplacement1=0;
        int emplacement2=0;
        int condition = 1;
      String nom= ActionsCommunes.DataProvider("Rechercher_Employe");
        if (demain_date.charAt(0)=='0')
        {
            jour_anniversaire= String.valueOf(demain_date.charAt(1));

            System.out.println("LE JOUR DEBUT EST"+jour_anniversaire);
        }
        else
        {
            jour_anniversaire = demain_date.substring(0,2);
            System.out.println("LE JOUR FIN EST"+jour_anniversaire);
        }
        mois_anniversaire = demain_date.substring(3, 5);

        switch (mois_anniversaire) {
            case "01":
                mois_anniversaire_l = "Jan";
                break;
            case "02":
                mois_anniversaire_l = "Feb";
                break;
            case "03":
                mois_anniversaire_l = "Mar";
                break;
            case "04":
                mois_anniversaire_l = "Apr";
                break;
            case "05":
                mois_anniversaire_l = "May";
                break;
            case "06":
                mois_anniversaire_l = "Jun";
                break;
            case "07":
                mois_anniversaire_l = "Jul";
                break;
            case "08":
                mois_anniversaire_l = "Aug";
                break;
            case "09":
                mois_anniversaire_l = "Sep";
                break;
            case "10":
                mois_anniversaire_l = "Oct";
                break;
            case "11":
                mois_anniversaire_l = "Nov";
                break;
            case "12":
                mois_anniversaire_l="Dec";
                break;
            default:
                logger.info("Date d'anniversaire est vide");
                throw NoSuchElementException;
        }
        date_anniversaire_portal = jour_anniversaire + " " + mois_anniversaire_l;
        System.out.println("LE JOUR EST"+jour_anniversaire);
        List<WebElement> l = driver.findElements(By.cssSelector(AnniversaireLocators.Liste_Anniversaire));
        int i = 0;
        for (WebElement x : l)
        {
            x.getAttribute("innerText");
            System.out.println("LA DATE ET LE NOM DE L'UTILISATEUR"+x.getAttribute("innerText"));
           if (x.getAttribute("innerText").contains(nom) && x.getAttribute("innerText").contains(date_anniversaire_portal) && condition == 1)
            {
               emplacement1 = i + 1;
                System.out.println("EMPLACEMENT"+emplacement1);
                condition ++;
                System.out.println("CONDITION1 est "+condition);
            }
           else {

               if ( x.getAttribute("innerText").contains(nom) && x.getAttribute("innerText").contains(date_anniversaire_portal) && condition == 2)
               {
                   emplacement2 = i + 1 ;
                   System.out.println("EMPLACEMENT"+emplacement2);
                   condition ++;
                   System.out.println("CONDITION2 est "+condition);

               }
           }
           i++;
        }
        System.out.println("CONDITION"+condition);
         if (condition==2)
           {
            actual_css_perso=before_css+emplacement1+after_css_perso;
            List<WebElement> listeBirthdayCake=driver.findElements(By.cssSelector(actual_css_perso));
            System.out.println("XPATH"+actual_css_perso);
        Assert.assertEquals(1,listeBirthdayCake.size());
           }
         else if (condition == 3)
           {
            actual_css_pro =before_css+emplacement1+after_css_pro;
            actual_css_perso=before_css+emplacement2+after_css_perso;
            List<WebElement> listeBirthdayCake=driver.findElements(By.cssSelector(actual_css_perso));
            List<WebElement> listeBirthdayCalendar=driver.findElements(By.cssSelector(actual_css_pro));
            System.out.println("XPATH"+actual_css_perso);
            Assert.assertEquals(1,listeBirthdayCake.size());
            Assert.assertEquals(1,listeBirthdayCalendar.size());
           }
        }

    @And("verifier que la date d anniv perso a ete modifie")
    public void verifierQueLaDateDAnnivPersoAEteModifie() {
        WebElement modules = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CommonLocators.Notification_Simple)));
        Assert.assertTrue(driver.findElement(By.cssSelector(CommonLocators.Notification_Simple)).getText().contains("succès"));
        Assert.assertEquals(driver.findElement(By.xpath(GestionDuPersonnel.DateDeNaissance_DossierIndividuel)).getAttribute("value"),date_anniversaire);
    }

}