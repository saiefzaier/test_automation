package com.QA.steps.connect.sondage;

import com.QA.locators.SondageLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VoterSondage {

    private final WebDriver driver = GenerateurDriver.driver;


    @Then("verifier que le vote a été compté")
    public void verifierQueLeVoteAÉtéCompté() {


        String str1 = "100%";

        WebElement modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SondageLocators.Pourcentage_Sondage_Afficher)));
        Boolean modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.attributeToBe(By.xpath(SondageLocators.Pourcentage_Sondage_Afficher), "innerText", str1));

        String str2 = driver.findElement(By.xpath(SondageLocators.Pourcentage_Sondage_Afficher)).getAttribute("innerText");
        Assert.assertEquals(str1, str2);

    }

}
