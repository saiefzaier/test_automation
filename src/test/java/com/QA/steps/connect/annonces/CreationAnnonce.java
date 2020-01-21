package com.QA.steps.connect.annonces;

import com.QA.locators.AnnoncesLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreationAnnonce {

    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();


    @Then("vérifier la création de la nouvelle annonce")
    public void vérifierLaCréationDeLaNouvelleAnnonce() {

        Boolean modules = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.attributeToBe(By.xpath(AnnoncesLocators.Premiere_Annonce), "innerText", ActionsCommunes.DataProvider("Input_Texte_Annonces_Creation")));

        Assert.assertEquals(ActionsCommunes.DataProvider("Input_Texte_Annonces_Creation"), driver.findElement(By.xpath(AnnoncesLocators.Premiere_Annonce)).getText());

    }


    @And("l'utilisateur ajoute une photo dans le champ photo annonce")
    public void lUtilisateurAjouteUnePhotoDansLeChampPhotoAnnonce() {
        driver.findElement(By.xpath(AnnoncesLocators.Upload_Image_Annonce)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/imagespourtest/imagetest.jpg");
    }


}
