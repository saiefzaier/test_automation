package com.QA.steps.connect.enquete;

import com.QA.locators.EnqueteLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuppressionEnquete {


    private final WebDriver driver = GenerateurDriver.driver;


    @Then("verifier que la suppression correct de l'enquete")
    public void verifierQueLaSuppressionCorrectDeLEnquete() {


        String  str1= ActionsCommunes.DataProvider("Libelle_Enquete_Creation");
        WebElement modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(EnqueteLocators.Premiere_Enquete_Libelle)));
        Boolean modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.not(ExpectedConditions.attributeToBe(By.xpath(EnqueteLocators.Premiere_Enquete_Libelle), "innerText",str1)));
        String str2=driver.findElement(By.xpath(EnqueteLocators.Premiere_Enquete_Libelle)).getAttribute("innerText");
        Assert.assertNotEquals(str1,str2);

    }


}
