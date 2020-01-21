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

public class SuppressionSondage {

    private final WebDriver driver = GenerateurDriver.driver;

    @Then("vérifier la suppression correct du Sondage")
    public void vérifierLaSuppressionCorrectDuSondage() {

        String  str1= ActionsCommunes.DataProvider("Question1_Creation_Sondage");
        WebElement modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SondageLocators.Premier_Sondage_Question)));

        String str2=driver.findElement(By.xpath(SondageLocators.Premier_Sondage_Question)).getAttribute("innerText");
        Assert.assertNotEquals(str1,str2);
    }

}
