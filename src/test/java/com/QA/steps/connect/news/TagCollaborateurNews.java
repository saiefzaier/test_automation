package com.QA.steps.connect.news;

import com.QA.locators.CommonLocators;
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

import java.util.List;

public class TagCollaborateurNews {

    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();


    @And("l utilisateur choisit le profil du tag dans le corps de la News")
    public void lUtilisateurChoisitLeProfilDuTagDansLeCorpsDeLaNews() throws InterruptedException {

        String str = ActionsCommunes.DataProvider("Champ_Input_Texte_News").substring(1);
        Boolean modules = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.refreshed(ExpectedConditions.attributeContains(By.cssSelector(CommonLocators.Option_Liste_Profil_Tag), "innerText", str)));
        WebElement element = driver.findElement(By.cssSelector(CommonLocators.Option_Liste_Profil_Tag));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        action.pause(driver, 500);

    }

    @Then("vérifier que le tag est affiché correctement dans la News ajoutée")
    public void vérifierQueLeTagEstAffichéCorrectementDansLaNewsAjoutée() throws InterruptedException {

        action.pause(driver, 300);
        WebElement modules = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CommonLocators.Notification_Simple)));
        Assert.assertTrue(driver.findElement(By.cssSelector(CommonLocators.Notification_Simple)).getText().contains("succès"));
        List<WebElement> Element3 = driver.findElements(By.cssSelector("span[class=mention]"));
        Assert.assertEquals(1, Element3.size());

    }


}
