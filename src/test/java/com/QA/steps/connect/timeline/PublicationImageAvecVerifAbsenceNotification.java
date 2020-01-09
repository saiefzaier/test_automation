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

import java.util.List;

public class PublicationImageAvecVerifAbsenceNotification {

    private final WebDriver driver = GenerateurDriver.driver;
    private  ActionsCommunes action = new ActionsCommunes();
    private  String NomUser;


    @Then("verifier que l image a etait publie avec succes")
    public void verifierQueLImageAEtaitPublieAvecSucces() {
        WebElement modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TimelineLocators.Premiere_Image_Publier_Timeline )));

        Assert.assertTrue(driver.findElement(By.xpath(TimelineLocators.Premiere_Image_Publier_Timeline)).getAttribute("outerHTML").contains("documentsmanagement/api/document-mgm/load-images"));

       NomUser=driver.findElement(By.xpath(CommonLocators.Icone_Nom_Utilisateur)).getAttribute("innerText");

    }


    @Then("verifier que la notification n existe pas et que l utilisateur ne peut pas afficher la publication de l'image")
    public void verifierQueLaNotificationNExistePasEtQueLUtilisateurNePeutPasAfficherLaPublicationDeLImage() throws InterruptedException {


       String str1= ActionsCommunes.DataProvider("Champ_Input_Statut_Image");

        WebElement modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TimelineLocators.Container_Premiere_Publication )));

       String str2=driver.findElement(By.xpath(TimelineLocators.Container_Premiere_Publication)).getAttribute("innerText");

       Assert.assertFalse(str2.contains(str1));

       //Vérification de l'abscence d'une notification relative a la publication de la photo

        List<WebElement> l = driver.findElements(By.cssSelector(CommonLocators.Compteur_Notification));


        if(l.size()!=0) {

           boolean NotificationPresence=false;

            driver.findElement(By.xpath(CommonLocators.Bouton_Notifications_Portal)).click();
            action.pause(driver,1000);

            List<WebElement> l2=driver.findElements(By.xpath(CommonLocators.Liste_Notifications));

            for(WebElement element:l2){

               String str3=element.getAttribute("innerText");

                if ((str3.contains(NomUser)) && (str3.contains("il y a quelques secondes") || str3.contains("il y a une minute")) && (str3.contains("a ajouté une nouvelle publication"))) {
                    NotificationPresence=true;
                    break;
                }
            }
            Assert.assertFalse(NotificationPresence);
        }

    }


}
