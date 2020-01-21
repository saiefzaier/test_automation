package com.QA.steps.connect.timeline;

import com.QA.locators.CommonLocators;
import com.QA.locators.TimelineLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PublicationImageAvecVerifNotification {


    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();
    private static String codeImage;


    @Then("verifier que l image a etait publie")
    public void verifierQueLImageAEtaitPublie() {

        String str1=ActionsCommunes.DataProvider("Champ_Input_Statut_Image");

        Boolean modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.attributeToBe(By.cssSelector(TimelineLocators.Premiere_Pulication_Statut), "innerText", str1));


        WebElement modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TimelineLocators.Premiere_Image_Publier_Timeline )));

        Assert.assertTrue(driver.findElement(By.xpath(TimelineLocators.Premiere_Image_Publier_Timeline)).getAttribute("outerHTML").contains("documentsmanagement/api/document-mgm/load-images"));

        codeImage=driver.findElement(By.cssSelector(TimelineLocators.Premiere_Image_Publier_Timeline_Afficher)).getAttribute("outerHTML");

        int pos = codeImage.indexOf("codeFile");


        codeImage=codeImage.substring(pos);



    }


    @Then("verifier que la notification existe et l'utilisateur peut afficher la publication image")
    public void verifierQueLaNotificationExisteEtLUtilisateurPeutAfficherLaPublicationImage() throws InterruptedException {

        driver.findElement(By.xpath(CommonLocators.Bouton_Notifications_Portal)).click();
        action.pause(driver,1000);

        driver.findElement(By.xpath(CommonLocators.Première_Notification_Portal)).click();
        action.pause(driver,1000);

        WebElement modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TimelineLocators.Premiere_Image_Publier_Timeline)));

        String str2= driver.findElement(By.cssSelector(TimelineLocators.Premiere_Image_Publier_Timeline_Afficher)).getAttribute("outerHTML");


        Assert.assertTrue(str2.contains(codeImage));

    }



}
