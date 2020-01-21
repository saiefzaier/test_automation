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

public class ModificationAnnonce {

    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();


    @Then("vérifier la modification de l'annonce")
    public void vérifierLaModificationDeLAnnonce() {


        Boolean modules = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.attributeContains(By.xpath(AnnoncesLocators.Premiere_Annonce),"innerText",ActionsCommunes.DataProvider("Input_Texte_Annonces_Creation")+ActionsCommunes.DataProvider("Input_Texte_Annonces_Modification")));


         Assert.assertEquals(ActionsCommunes.DataProvider("Input_Texte_Annonces_Creation")+ActionsCommunes.DataProvider("Input_Texte_Annonces_Modification"),driver.findElement(By.xpath(AnnoncesLocators.Premiere_Annonce)).getAttribute("innerText"));




    }




    @And("l'utilisateur rafraichit la page")
    public void lUtilisateurRafraichitLaPage() {
        driver.navigate().refresh();
    }




}
