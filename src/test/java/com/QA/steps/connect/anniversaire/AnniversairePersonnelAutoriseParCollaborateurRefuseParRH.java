package com.QA.steps.connect.anniversaire;

import com.QA.locators.AnniversaireLocators;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AnniversairePersonnelAutoriseParCollaborateurRefuseParRH {

    private final WebDriver driver = GenerateurDriver.driver;


    @Then("l administrateur va decocher le bouton d affichage de l anniversaire personnel")
    public void lAdministrateurVaDecocherLeBoutonDAffichageDeLAnniversairePersonnel() {

       boolean test = driver.findElement(By.xpath(AnniversaireLocators.Check_Box_AnniversairePersonnel_Rh)).isSelected();

        if(test){
            driver.findElement(By.xpath("//*[@id=\"configTable\"]/tbody/tr[8]/td[2]/div/label/span")).click();
        }

    }


    @Then("l utilisateur va cocher le bouton d affichage d anniversaire personnel")
    public void lUtilisateurVaCocherLeBoutonDAffichageDAnniversairePersonnel() {




       Boolean test=driver.findElement(By.xpath("//*[@id=\"configTable\"]/tbody/tr[8]/td[2]/acc-switch/div/label/span")).isDisplayed();

       if(!test){
           driver.findElement(By.xpath(AnniversaireLocators.Bouton_Collaborateur_Anniversaire_Personnel)).click();

       }



    }


    @Then("verifier que la date n est pas affichée dans le profil enrichi")
    public void verifierQueLaDateNEstPasAffichéeDansLeProfilEnrichi() {

        List<WebElement> list=driver.findElements(By.cssSelector(AnniversaireLocators.Anniversaire_Personnel_Profil_Enrichi));
        Assert.assertEquals(0,list.size());

    }


}
