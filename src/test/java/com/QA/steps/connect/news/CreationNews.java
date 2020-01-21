package com.QA.steps.connect.news;


import com.QA.locators.NewsLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CreationNews {

    private final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();


    @And("l'utilisateur selectionne la date actuelle du champ date de publication")
    public void lUtilisateurSelectionneLaDateActuelleDuChampDateDePublication() {

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(date);
        driver.findElement(By.xpath(NewsLocators.Champ_Input_Date_Debut_News)).sendKeys(strDate);
    }


    @And("l utilisateur upload une photo dans la News")
    public void lUtilisateurUploadUnePhotoDansLaNews() throws InterruptedException {

        driver.findElement(By.id(NewsLocators.Upload_Image_News)).sendKeys(System.getProperty("user.dir") + "/src/test/resources/imagespourtest/imagetest.jpg");
        action.pause(driver, 150);
        WebElement element = driver.findElement(By.xpath(NewsLocators.Bouton_Validation_Upload_Image));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }


    @Then("vérifier la création de la nouvelle news")
    public void vérifierLaCréationDeLaNouvelleNews() throws InterruptedException {

        action.pause(driver, 100);
        Assert.assertEquals(ActionsCommunes.DataProvider("Champ_Input_Titre_News"), driver.findElement(By.xpath(NewsLocators.Premier_Element_Liste_News)).getText());

    }
}

