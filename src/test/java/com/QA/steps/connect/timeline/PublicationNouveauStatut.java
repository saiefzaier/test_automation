package com.QA.steps.connect.timeline;


import com.QA.locators.TimelineLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PublicationNouveauStatut {


    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();


    @Then("^Vérifier que le statut est publié$")
    public void vérifierQueLeStatutEstPublié() throws InterruptedException {

        Boolean modules = (new WebDriverWait(driver, 7))
                .until(ExpectedConditions.attributeContains(By.xpath(TimelineLocators.Premiere_Publication_Timeline), "innerText", ActionsCommunes.DataProvider("Champ_Input_Statut")));
        String statut = driver.findElement(By.xpath(TimelineLocators.Premiere_Publication_Timeline)).getText();
        Assert.assertEquals(ActionsCommunes.DataProvider("Champ_Input_Statut"), statut);
        action.pause(driver, 100);

    }
}
