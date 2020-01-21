package com.QA.steps.connect.sondage;

import com.QA.locators.SondageLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreationSondageAvecDateDeFin {

    private final WebDriver driver = GenerateurDriver.driver;
    Calendar calendar;
    DateFormat frm;

    @And("l utilisateur saisit la date de fin du sondage")
    public void lUtilisateurSaisitLaDateDeFinDuSondage() {

          frm = new SimpleDateFormat("dd/MM/yyyy");
          calendar = Calendar.getInstance();
          calendar.add(Calendar.DATE,4);
          String DateDeClotureSondage=frm.format(calendar.getTime());
          driver.findElement(By.xpath(SondageLocators.Champ_Date_Sondage)).sendKeys(DateDeClotureSondage);

    }


    @Then("vérifier que le nombre affiché correspond au nombre de jours restants")
    public void vérifierQueLeNombreAffichéCorrespondAuNombreDeJoursRestants() {


        String str1=" J--3";

        WebElement modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(SondageLocators.Sondage_JoursRestants_Afficher)));

        Boolean modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.attributeToBe(By.xpath(SondageLocators.Sondage_JoursRestants_Afficher), "innerText",str1));

        Assert.assertEquals(str1,driver.findElement(By.xpath(SondageLocators.Sondage_JoursRestants_Afficher)).getAttribute("innerText"));

    }

}
