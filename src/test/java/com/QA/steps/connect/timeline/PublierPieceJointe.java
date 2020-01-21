package com.QA.steps.connect.timeline;

import com.QA.locators.TimelineLocators;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PublierPieceJointe {

    private final WebDriver driver = GenerateurDriver.driver;


    @Then("Vérifier que la pièce jointe est publié")
    public void vérifierQueLaPièceJointeEstPublié() {
        String str1="DocumentTest.xlsx";
        Boolean modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.attributeToBe(By.xpath(TimelineLocators.Premiere_Publication_Timeline), "innerText", str1));
        String str2=driver.findElement(By.xpath(TimelineLocators.Premiere_Publication_Timeline)).getAttribute("innerText");
        Assert.assertEquals(str1,str2);

    }

}
