package com.QA.steps.connect.anniversaire;

import com.QA.locators.AnniversaireLocators;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AnniversairePersonnelAutoriseParRhRefuseParCollaborateur {

    private final WebDriver driver = GenerateurDriver.driver;


    @Then("l administrateur va cocher le bouton d affichage de l anniversaire personnel")
    public void lAdministrateurVaCocherLeBoutonDAffichageDeLAnniversairePersonnel() {

        boolean test = driver.findElement(By.xpath(AnniversaireLocators.Check_Box_AnniversairePersonnel_Rh)).isSelected();

        if(!test){
            driver.findElement(By.xpath("//*[@id=\"configTable\"]/tbody/tr[8]/td[2]/div/label/span")).click();
        }


    }


    @Then("l utilisateur va decocher le bouton d affichage d anniversaire personnel")
    public void lUtilisateurVaDecocherLeBoutonDAffichageDAnniversairePersonnel() {



        Boolean test=driver.findElement(By.xpath("//*[@id=\"bithPerso\"]/div/div/p-inputswitch/div/div[1]/span")).isDisplayed();

        if(!test){
            driver.findElement(By.xpath(AnniversaireLocators.Bouton_Collaborateur_Anniversaire_Personnel)).click();

        }


    }


}
