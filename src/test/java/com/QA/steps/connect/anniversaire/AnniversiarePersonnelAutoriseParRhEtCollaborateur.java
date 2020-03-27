package com.QA.steps.connect.anniversaire;

import com.QA.locators.AnniversaireLocators;
import com.QA.locators.GestionDuPersonnel;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AnniversiarePersonnelAutoriseParRhEtCollaborateur {

    private final WebDriver driver = GenerateurDriver.driver;

    @Then("verifier que l anniversaire est affiché dans le profil enrichi")
    public void verifierQueLAnniversaireEstAffichéDansLeProfilEnrichi() {

        boolean test  =driver.findElement(By.cssSelector(AnniversaireLocators.Anniversaire_Personnel_Profil_Enrichi)).isDisplayed();
        Assert.assertTrue(test);

    }


    @Then("verifier que la date d anniversaire personnel est la meme dans la gestion du personnel")
    public void verifierQueLaDateDAnniversairePersonnelEstLaMemeDansLaGestionDuPersonnel() {

        Assert.assertEquals("01/10/1991",driver.findElement(By.xpath(GestionDuPersonnel.DateDeNaissance_DossierIndividuel)).getAttribute("value"));

    }



}
