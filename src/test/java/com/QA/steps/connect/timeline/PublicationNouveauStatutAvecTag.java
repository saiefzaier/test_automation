package com.QA.steps.connect.timeline;

import com.QA.locators.CommonLocators;
import com.QA.locators.TimelineLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PublicationNouveauStatutAvecTag {

    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();
    private static int x;

    @And("l utilisateur choisit le profil du tag du statut dans la liste")
    public void lUtilisateurChoisitLeProfilDuTagdustatutDansLaListe() throws InterruptedException {

        String str = ActionsCommunes.DataProvider("Champ_Input_Statut").substring(1);
        Boolean modules = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.refreshed(ExpectedConditions.attributeContains(By.cssSelector(CommonLocators.Option_Liste_Profil_Tag), "innerText", str)));
        WebElement element = driver.findElement(By.cssSelector(CommonLocators.Option_Liste_Profil_Tag));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        action.pause(driver, 500);

    }

    @Then("Vérifier que le statut est publié et que le tag est affiché")
    public void vérifierQueLeStatutEstPubliéEtQueLeTagEstAffiché() {


        Boolean modules = (new WebDriverWait(driver, 7))
                .until(ExpectedConditions.attributeContains(By.xpath(TimelineLocators.Premiere_Publication_Timeline), "innerText", ActionsCommunes.DataProvider("Champ_Input_Statut")));
        String statut = driver.findElement(By.xpath(TimelineLocators.Premiere_Publication_Timeline)).getText();
        Assert.assertEquals(ActionsCommunes.DataProvider("Champ_Input_Statut"), statut);
        String str = driver.findElement(By.xpath("//*[@id=\"post-holder\"]/acc-timeline-post/div/div[3]/acc-timeline-post-status/div/div/p/span/span/span/a")).getText();
        Assert.assertTrue(ActionsCommunes.DataProvider("Champ_Input_Statut").contains(str));


    }

}
