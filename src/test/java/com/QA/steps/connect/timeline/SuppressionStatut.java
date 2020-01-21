package com.QA.steps.connect.timeline;

import com.QA.locators.TimelineLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.EtapesCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuppressionStatut {

    private final WebDriver driver = GenerateurDriver.driver;


    @Then("verifier que la suppression du statut a été effectuée")
    public void verifierQueLaSuppressionDuStatutAÉtéEffectuée() {

        Boolean modules = (new WebDriverWait(driver, 7))
                .until(ExpectedConditions.refreshed(ExpectedConditions.not(ExpectedConditions.attributeContains(By.xpath(TimelineLocators.Premiere_Publication_Timeline), "textContent", ActionsCommunes.DataProvider("Champ_Input_Statut")))));
        String statut = driver.findElement(By.xpath(TimelineLocators.Premiere_Publication_Timeline)).getText();
        Assert.assertFalse(EtapesCommunes.listededonnees.contains(statut));

    }

}
