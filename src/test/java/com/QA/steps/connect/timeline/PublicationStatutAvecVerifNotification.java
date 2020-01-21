package com.QA.steps.connect.timeline;

import com.QA.locators.CommonLocators;
import com.QA.locators.SondageLocators;
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

public class PublicationStatutAvecVerifNotification {


    private static final WebDriver driver = GenerateurDriver.driver;


    @Then("verifier que la notification existe et l'utilisateur peut afficher la publication")
    public void verifierQueLaNotificationExisteEtLUtilisateurPeutAfficherLaPublication() {

       driver.findElement(By.xpath(CommonLocators.Bouton_Notifications_Portal)).click();

       WebElement modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(CommonLocators.Premier_User_Nom_Notification)));

        String str1=driver.findElement(By.xpath(CommonLocators.Premier_User_Nom_Notification)).getAttribute("innerText");
        Assert.assertEquals("Blanche Beauchamp",str1);




       driver.findElement(By.xpath(CommonLocators.Première_Notification_Portal)).click();

        WebElement modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TimelineLocators.Premiere_Publication_Timeline_Notification)));

       String str2= driver.findElement(By.xpath(TimelineLocators.Premiere_Publication_Timeline_Notification)).getAttribute("innerText");
       String str3= ActionsCommunes.DataProvider("Champ_Input_Statut");

       Assert.assertEquals(str3,str2);


    }


}
