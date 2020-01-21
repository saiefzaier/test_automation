package com.QA.steps.connect.timeline;

import com.QA.locators.TimelineLocators;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PublierUnAlbum {

    private final WebDriver driver = GenerateurDriver.driver;


    @Then("Vérifier que l album est publié")
    public void vérifierQueLAlbumEstPublié() {

         int nombreImage=0;

         List<WebElement> l=driver.findElements(By.cssSelector(TimelineLocators.Prmier_Album_Afficher_Photo));
         nombreImage=l.size();

        Assert.assertEquals(2,nombreImage);

      }


}
