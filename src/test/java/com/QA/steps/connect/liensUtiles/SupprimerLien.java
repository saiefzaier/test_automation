package com.QA.steps.connect.liensUtiles;

import com.QA.locators.LiensUtilesLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SupprimerLien {


    private final WebDriver driver = GenerateurDriver.driver;


    @Then("verifier que le lien a été supprimé avec succés")
    public void verifierQueLeLienAÉtéSuppriméAvecSuccés() {


        Boolean modules1 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(LiensUtilesLocators.Premier_Lien_Afficher_Titre), "innerText", ActionsCommunes.DataProvider("Titre_Lien_Creation") )));

        Boolean modules2 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(LiensUtilesLocators.Premier_Lien_Afficher_LienUtile), "innerText", ActionsCommunes.DataProvider("Champ_Lien_Creation"))));

        Boolean modules3 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(LiensUtilesLocators.Premier_Lien_Afficher_Description), "innerText", ActionsCommunes.DataProvider("Description_Lien_Creation"))));

        Assert.assertNotEquals(ActionsCommunes.DataProvider("Titre_Lien_Creation"), driver.findElement(By.xpath(LiensUtilesLocators.Premier_Lien_Afficher_Titre)).getAttribute("innerText"));
        Assert.assertNotEquals(ActionsCommunes.DataProvider("Champ_Lien_Creation"), driver.findElement(By.xpath(LiensUtilesLocators.Premier_Lien_Afficher_LienUtile)).getAttribute("innerText"));
        Assert.assertNotEquals(ActionsCommunes.DataProvider("Description_Lien_Creation"), driver.findElement(By.xpath(LiensUtilesLocators.Premier_Lien_Afficher_Description)).getAttribute("innerText"));

    }


}
