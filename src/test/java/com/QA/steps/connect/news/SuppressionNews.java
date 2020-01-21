package com.QA.steps.connect.news;

import com.QA.locators.NewsLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuppressionNews {

    private final WebDriver driver = GenerateurDriver.driver;


    @Then("vérifier la suppression de la News")
    public void vérifierLaSuppressionDeLaNews() {

        Assert.assertFalse(ActionsCommunes.DataProvider("Champ_Input_Titre_News").contains(driver.findElement(By.id(NewsLocators.Champ_Input_Titre_News_Existante)).getAttribute("value")));
        Assert.assertFalse(ActionsCommunes.DataProvider("Champ_Input_Texte_News").contains(driver.findElement(By.xpath(NewsLocators.Champ_Input_Contenu_News_Existante)).getAttribute("innerText")));

    }
}
