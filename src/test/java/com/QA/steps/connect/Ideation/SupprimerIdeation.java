package com.QA.steps.connect.Ideation;

import com.QA.locators.IdeationLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SupprimerIdeation {

    private final WebDriver driver = GenerateurDriver.driver;


    @Then("verifier que l idée n est plus affichée")
    public void verifierQueLIdéeNEstPlusAffichée() {

        String str1 = ActionsCommunes.DataProvider("Libelle_Creation_Idee");
        String str2 = ActionsCommunes.DataProvider("Description_Creation_Idee");

        Boolean modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.refreshed(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(IdeationLocators.Libelle_Premiere_Idee_Affichee), "innerText", str1))));

        Boolean modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.refreshed(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(IdeationLocators.Description_Premiere_Idee_Affichee), "innerText", str2))));

        String str3 = driver.findElement(By.xpath(IdeationLocators.Libelle_Premiere_Idee_Affichee)).getAttribute("innerText");
        String str4 = driver.findElement(By.xpath(IdeationLocators.Description_Premiere_Idee_Affichee)).getAttribute("innerText");

        Assert.assertNotEquals(str1, str3);
        Assert.assertNotEquals(str2, str4);

    }


}
