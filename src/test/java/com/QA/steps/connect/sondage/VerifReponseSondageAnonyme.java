package com.QA.steps.connect.sondage;

import com.QA.locators.SondageLocators;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifReponseSondageAnonyme {

    private final WebDriver driver = GenerateurDriver.driver;

    @Then("verifier que le vote est anonyme")
    public void verifierQueLeVoteEstAnonyme() {

        String  str1= driver.findElement(By.xpath(SondageLocators.Nombre_De_Vote_Sondage_Anonyme)).getAttribute("innerHTML");
        WebElement modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SondageLocators.Premier_Sondage_Question)));
        String str2="1";
        Assert.assertEquals(str2,str1);

    }


}
