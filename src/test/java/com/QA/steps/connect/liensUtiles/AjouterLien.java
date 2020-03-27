package com.QA.steps.connect.liensUtiles;

import com.QA.locators.AnnoncesLocators;
import com.QA.locators.LiensUtilesLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjouterLien {

    private final WebDriver driver = GenerateurDriver.driver;


    @Then("verifier que le lien a été ajouté avec succes")
    public void verifierQueLeLienAÉtéAjoutéAvecSucces() {


        Boolean modules1 = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.attributeToBe(By.xpath(LiensUtilesLocators.Premier_Lien_Afficher_Titre), "innerText", ActionsCommunes.DataProvider("Titre_Lien_Creation")));

        Boolean modules2 = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.attributeToBe(By.xpath(LiensUtilesLocators.Premier_Lien_Afficher_LienUtile), "innerText", ActionsCommunes.DataProvider("Champ_Lien_Creation")));

        Boolean modules3 = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.attributeToBe(By.xpath(LiensUtilesLocators.Premier_Lien_Afficher_Description), "innerText", ActionsCommunes.DataProvider("Description_Lien_Creation")));

        Assert.assertEquals(ActionsCommunes.DataProvider("Titre_Lien_Creation"), driver.findElement(By.xpath(LiensUtilesLocators.Premier_Lien_Afficher_Titre)).getAttribute("innerText"));
        Assert.assertEquals(ActionsCommunes.DataProvider("Champ_Lien_Creation"), driver.findElement(By.xpath(LiensUtilesLocators.Premier_Lien_Afficher_LienUtile)).getAttribute("innerText"));
        Assert.assertEquals(ActionsCommunes.DataProvider("Description_Lien_Creation"), driver.findElement(By.xpath(LiensUtilesLocators.Premier_Lien_Afficher_Description)).getAttribute("innerText"));

    }

}
