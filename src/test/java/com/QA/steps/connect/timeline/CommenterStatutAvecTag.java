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


public class CommenterStatutAvecTag {

    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();


    @And("l utilisateur choisit le profil du tag du commentaire dans la liste")
    public void lUtilisateurChoisitLeProfilDuTagDuCommentaireDansLaListe() throws InterruptedException {

        String s = ActionsCommunes.DataProvider("Champs_Input_Commentaire").substring(1);
        Boolean modules = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.refreshed(ExpectedConditions.attributeContains(By.cssSelector(CommonLocators.Option_Liste_Profil_Tag), "innerText", s)));
        WebElement element = driver.findElement(By.cssSelector(CommonLocators.Option_Liste_Profil_Tag));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        action.pause(driver, 500);

    }

    @Then("Vérifier que le tag est affiché correctement sous le statut")
    public void vérifierQueLeTagEstAffichéCorrectementSousLeStatut() {

        String str = (ActionsCommunes.DataProvider("Champs_Input_Commentaire")).substring(1);
        Boolean modules = (new WebDriverWait(driver, 7))
                .until(ExpectedConditions.attributeContains(By.xpath(TimelineLocators.Contenu_Commentaire_avec_TAG),"innerText", str));
        Assert.assertEquals(str, driver.findElement(By.xpath(TimelineLocators.Contenu_Commentaire_avec_TAG)).getText());

    }

}
