package com.QA.steps.connect.sondage;

import com.QA.locators.SondageLocators;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifAvancementSondage {

    private final WebDriver driver = GenerateurDriver.driver;
    @Then("verifier que l avancement du sondage est egale a {int}%")
    public void verifierQueLAvancementDuSondageEstEgaleA(int arg0) {

        String str1=Integer.toString(arg0)+"%";
        Boolean modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.attributeToBe(By.xpath(SondageLocators.Avancement_Sondage), "innerText",str1));
        Assert.assertEquals(driver.findElement(By.xpath(SondageLocators.Avancement_Sondage)).getAttribute("innerText"),str1);
    }


}
