package com.QA.steps.connect.anniversaire;
import com.QA.locators.AnniversaireLocators;
import com.QA.locators.CommonLocators;
import com.QA.locators.GestionDuPersonnel;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AnniversaireProfessWidget {

    private Throwable NoSuchElementException;
    private static final Logger logger = Logger.getLogger(GenerateurDriver.class);
    private static String demain_date_pro;
    private Date date_pro;
    private Format formatter;
    private ActionsCommunes action = new ActionsCommunes();
    private final WebDriver driver = GenerateurDriver.driver;
    private static String date_anniversaire_pro;
    private String annee_anniversaire="/2017";
    public Actions actions = new Actions(driver);

    @And("l utilisateur modifie la date de l anniversaire professionnel")
    public void lUtilisateurModifieLaDateDeLAnniversaireProfessionnel() throws InterruptedException {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 249);
        date_pro = calendar.getTime();
        formatter = new SimpleDateFormat("dd/MM/yyyy");
        demain_date_pro= formatter.format(date_pro);
        date_anniversaire_pro=demain_date_pro.substring(0, 5)+annee_anniversaire;
        System.out.println(date_anniversaire_pro);
        action.pause(driver, 1000);
        driver.findElement(By.xpath(GestionDuPersonnel.DateDentree_DossierIndividuel)).clear();
        driver.findElement(By.xpath(GestionDuPersonnel.DateDentree_DossierIndividuel)).sendKeys(date_anniversaire_pro);
        action.pause(driver, 8000);


    }

    @Then("verifier que l anniversaire professionnel de l utilisateur est affiche")
    public void verifierQueLAnniversaireProfessionnelDeLUtilisateurEstAffiche() throws Throwable {

        String str;
        int i=1;
        String before_css="a.list-group-item:nth-child(";
        String after_css=") .fa-calendar";
        String actual_css="";
        String mois_anniversaire_pro;
        String jour_anniversaire_pro;
        String mois_anniversaire_pro_l;
        String date_anniversaire_portal;
        int emplacement=0;
        String nom= ActionsCommunes.DataProvider("Rechercher_Employe");

        if (demain_date_pro.charAt(0)=='0')
        {
            jour_anniversaire_pro= String.valueOf(demain_date_pro.charAt(1));
        }
        else
        {
            jour_anniversaire_pro = demain_date_pro.substring(0,2);
        }
        mois_anniversaire_pro = demain_date_pro.substring(3, 5);
        switch (mois_anniversaire_pro) {
            case "01":
                mois_anniversaire_pro_l = "Jan";
                break;
            case "02":
                mois_anniversaire_pro_l = "Feb";
                break;
            case "03":
                mois_anniversaire_pro_l = "Mar";
                break;
            case "04":
                mois_anniversaire_pro_l = "Apr";
                break;
            case "05":
                mois_anniversaire_pro_l = "May";
                break;
            case "06":
                mois_anniversaire_pro_l = "Jun";
                break;
            case "07":
                mois_anniversaire_pro_l = "Jul";
                break;
            case "08":
                mois_anniversaire_pro_l = "Aug";
                break;
            case "09":
                mois_anniversaire_pro_l = "Sep";
                break;
            case "10":
                mois_anniversaire_pro_l = "Oct";
                break;
            case "11":
                mois_anniversaire_pro_l = "Nov";
                break;
            case "12":
                mois_anniversaire_pro_l="Dec";
                break;
            default:
                logger.info("Date d'anniversaire est vide");
                throw NoSuchElementException;
        }



        date_anniversaire_portal=jour_anniversaire_pro + " " + mois_anniversaire_pro_l;

        System.out.println("DATE PRO "+date_anniversaire_portal);
        List<WebElement> listeannivpro = driver.findElements(By.cssSelector(AnniversaireLocators.Liste_Anniversaire));
        for  (WebElement elntliste:listeannivpro)
        {
            System.out.println(listeannivpro.size());
            actions.moveToElement(elntliste).perform();
            str=elntliste.getAttribute("innerText");
            System.out.println("LA DATE ET LE NOM DE L'UTILISATEUR"+str);

            if (str.contains(nom) && str.contains(date_anniversaire_portal))
            {
                emplacement = i;
                break;
            }
            System.out.println(i);
            i++;
        }
        actual_css=before_css+emplacement+after_css;
        List<WebElement> listeBirthdayCakepro=driver.findElements(By.cssSelector(actual_css));
        action.pause(driver, 2000);
        Assert.assertEquals(1,listeBirthdayCakepro.size());

    }

    @And("verifier que la date d anniv pro a ete modifie")
    public void verifierQueLaDateDAnnivProAEteModifie() {
        WebElement modules = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CommonLocators.Notification_Simple)));
        Assert.assertTrue(driver.findElement(By.cssSelector(CommonLocators.Notification_Simple)).getText().contains("succès"));
        Assert.assertEquals(driver.findElement(By.xpath(GestionDuPersonnel.Fiche_User_Date_Entree)).getAttribute("innerText"),date_anniversaire_pro);

    }
}
