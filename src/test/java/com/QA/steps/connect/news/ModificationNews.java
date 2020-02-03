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

import static com.QA.steps.ActionsCommunes.DataProvider;


public class ModificationNews {

    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();

    @Then("verifier que la modification a été enregistrée")
    public void verifierQueLaModificationAÉtéEnregistrée() {

        driver.navigate().refresh();
        Boolean modules = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.attributeContains(driver.findElement(By.id(NewsLocators.Champ_Input_Titre_News_Existante)),"value", DataProvider("Champ_Input_Titre_News")+DataProvider("Champ_Input_Titre_News_Existante")));
        Assert.assertEquals(DataProvider("Champ_Input_Titre_News")+DataProvider("Champ_Input_Titre_News_Existante"), driver.findElement(By.id(NewsLocators.Champ_Input_Titre_News_Existante)).getAttribute("value"));
        Assert.assertEquals(DataProvider("Champ_Input_Texte_News")+DataProvider("Champ_Input_Contenu_News_Existante"), driver.findElement(By.xpath(NewsLocators.Champ_Input_Contenu_News_Existante)).getAttribute("innerText"));

    }
}
