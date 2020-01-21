package com.QA.steps.talent.recrutement;

import com.QA.locators.CommonLocators;
import com.QA.locators.RecrutementLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.QA.base.TestGenerateurDriverInit.ListeGlobaleLocators;

public class DemandeDeRecrutementParManagerAvecValidation {

    private final WebDriver driver = GenerateurDriver.driver;

    @Then("le nom de l utilisateur {string} est affiche en haut a gauche")
    public void leNomDeLUtilisateurEstAfficheEnHautAGauche(String arg0) {

        Boolean modules = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.attributeToBe(By.xpath(CommonLocators.Icone_Nom_Utilisateur), "innerText",arg0));

        Assert.assertEquals(arg0,driver.findElement(By.xpath(CommonLocators.Icone_Nom_Utilisateur)).getAttribute("innerText"));

    }


    @And("le manager clique pour ajouter_des_fichiers_demande_rec")
    public void leManagerCliquePourAjouter_des_fichiers_demande_rec() {

        driver.findElement(By.xpath(RecrutementLocators.Upload_Document_Recrutement)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/imagespourtest/imagetest.jpg");
    }




    @Then("verifier que {string} est {string}")
    public void verifierQueEst(String ChampSalaireAnnuel, String Salaire) throws IllegalAccessException {

        String locator = "vide";
        for (List<Field> f : ListeGlobaleLocators) {
            for (Field x : f) {
                if (x.getName().equals(ChampSalaireAnnuel)) {
                    locator = (String) x.get(x);
                    break;
                }
            }
            if (!locator.equals("vide")) {
                break;
            }
        }

     if (Character.toString(locator.charAt(0)).contains("/")) {

        //Récuperer l'intégralité du texte et récuperer la partie du salaire
        String chaine1 =  driver.findElement(By.xpath(locator)).getAttribute("innerText");
        String chaine2 = chaine1.substring(chaine1.length()-Salaire.length(),chaine1.length());

        Assert.assertEquals(Salaire,chaine2);


     } else if (locator.contains("[") || Character.toString(locator.charAt(0)).contains(".")) {

         //Récuperer l'intégralité du texte et récuperer la partie du salaire
         String chaine1 =  driver.findElement(By.xpath(locator)).getAttribute("innerText");
         String chaine2 = chaine1.substring(chaine1.length()-Salaire.length(),chaine1.length());

         Assert.assertEquals(Salaire,chaine2);


     } else {


         //Récuperer l'intégralité du texte et récuperer la partie du salaire
         String chaine1 =  driver.findElement(By.xpath(locator)).getAttribute("innerText");
         String chaine2 = chaine1.substring(chaine1.length()-Salaire.length(),chaine1.length());

         Assert.assertEquals(Salaire,chaine2);



     }


}


    @Then("verifier que le {string} est {string} s affiche a droite")
    public void verifierQueLeEstSAfficheADroite(String montantAfficher, String montant) {

        Assert.assertEquals(montant,driver.findElement(By.xpath(RecrutementLocators.montant_demande_rec)).getAttribute("innerText"));

    }


    @Then("verifier que le premier libelle_demandes_rec_mgr {string}")
    public void verifierQueLePremierLibelle_demandes_rec_mgr(String libelle) {
        Assert.assertEquals(libelle,driver.findElement(By.xpath(RecrutementLocators.libelle_demandes_rec_mgr)).getAttribute("innerText"));

    }


    @And("verifier que la premiere date de creation_demandes_rec_mgr aujourd hui")
    public void verifierQueLaPremiereDateDeCreation_demandes_rec_mgrAujourdHui() {

        String dateAfficher=driver.findElement(By.xpath(RecrutementLocators.creation_demandes_rec_mgr)).getAttribute("innerText");
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateAsString=format.format(date);
        Assert.assertEquals(dateAsString,dateAfficher);


    }




    @And("verifier que la premiere ligne de l effectif a couvrir_demandes_rec_mgr est {string}")
    public void verifierQueLaPremiereLigneDeLEffectifACouvrir_demandes_rec_mgrEst(String effectif) {

                  Assert.assertEquals(effectif,driver.findElement(By.xpath(RecrutementLocators.couvrir_demandes_rec_mgr)).getText());
    }



    @And("verifier que le premier status_demandes_rec_mgr est de couleur Orange et l intitule est {string}")
    public void verifierQueLePremierStatus_demandes_rec_mgrEstDeCouleurOrangeEtLIntituleEst(String arg0) {
    }


    @And("verifier que le premier lieu_demandes_rec_mgr est {string}")
    public void verifierQueLePremierLieu_demandes_rec_mgrEst(String lieu) {

           Assert.assertEquals(lieu,driver.findElement(By.xpath(RecrutementLocators.lieu_demandes_rec_mgr)).getAttribute("innerText"));
    }


    @And("verifier que la premiere ligne de publiee_demandes_rec_mgr n est pas cochee")
    public void verifierQueLaPremiereLigneDePubliee_demandes_rec_mgrNEstPasCochee() {
        Assert.assertEquals("",driver.findElement(By.xpath(RecrutementLocators.publiee_demandes_rec_mgr)).getAttribute("innerText"));
    }


}
