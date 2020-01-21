package com.QA.steps.connect.timeline;

import com.QA.locators.SondageLocators;
import com.QA.locators.TimelineLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PublierVideo {

    private final WebDriver driver = GenerateurDriver.driver;


    @Then("Vérifier que la vidéo est publiée")
    public void vérifierQueLaVidéoEstPubliée() {

        String str1= ActionsCommunes.DataProvider("Champ_Input_Statut_Video");

        Boolean modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.attributeToBe(By.xpath(TimelineLocators.Premiere_Publication_TimeLine_Statut), "innerText", str1));
        String str2=driver.findElement(By.xpath(TimelineLocators.Premiere_Publication_TimeLine_Statut)).getAttribute("innerText")  ;

        Assert.assertEquals(str1,str2);

        Assert.assertTrue(driver.findElement(By.xpath(TimelineLocators.Premiere_Video_Publier_Timeline)).getAttribute("outerHTML").contains("/documentsmanagement/api/document-mgm/load-images"));


    }



}
