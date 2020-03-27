package com.QA.steps.connect.news;

import com.QA.locators.CommonLocators;
import com.QA.locators.NewsLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommenterNewsAvecTag {

    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();
    private static int x ;

    @When("l'utilisateur clique sur la news ajoutée")
    public void lUtilisateurCliqueSurLaNewsAjoutée() throws InterruptedException {

        driver.navigate().refresh();
        List<WebElement> Element1 = driver.findElements(By.cssSelector(NewsLocators.Liste_News_Déroulants));
        for ( WebElement element : Element1 )
        {
            if (element.getAttribute("outerText").contains(ActionsCommunes.DataProvider("Champ_Input_Titre_News")))
            {
                element.click();
                Boolean modules = (new WebDriverWait(driver, 6))
                        .until(ExpectedConditions.attributeContains(By.xpath(NewsLocators.News_Active_Carroussel),"innerText",ActionsCommunes.DataProvider("Champ_Input_Titre_News")));
                action.pause(driver,500);
                driver.findElement(By.xpath(NewsLocators.News_Active_Carroussel2)).click();
                break;
            }
        }
        action.pause(driver,200);
        List<WebElement> Element2 = driver.findElements(By.cssSelector("span[class=mention]"));
        x= Element2.size();
    }


    @And("l utilisateur choisit le profil du tag du commentaire News dans la liste")
    public void lUtilisateurChoisitLeProfilDuTagDuCommentaireNewsDansLaListe() throws InterruptedException {

        String str = ActionsCommunes.DataProvider("Champs_Input_Commentaire").substring(1);
        Boolean modules = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.refreshed(ExpectedConditions.attributeContains(By.cssSelector(CommonLocators.Option_Liste_Profil_Tag), "innerText", str)));
        WebElement element = driver.findElement(By.cssSelector(CommonLocators.Option_Liste_Profil_Tag));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        action.pause(driver, 500);

    }

    @Then("Vérifier que le tag est affiché")
    public void vérifierQueLeTagEstAffiché()  {

        Boolean modules = (new WebDriverWait(driver, 7))
                .until(ExpectedConditions.attributeContains(By.xpath(NewsLocators.Premier_Commentaire_Sur_News),"innerText", ActionsCommunes.DataProvider("Champs_Input_Commentaire")));
        List<WebElement> Element3 = driver.findElements(By.cssSelector("span[class=mention]"));
        Assert.assertEquals( x + 1,Element3.size());
    }

}
