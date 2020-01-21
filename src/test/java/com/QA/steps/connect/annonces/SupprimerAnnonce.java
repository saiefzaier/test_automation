package com.QA.steps.connect.annonces;

import com.QA.locators.AnnoncesLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SupprimerAnnonce {

    private final WebDriver driver = GenerateurDriver.driver;
    private final JavascriptExecutor event = (JavascriptExecutor) driver;
    private ActionsCommunes action = new ActionsCommunes();
    private static String[] tab1;


    @And("L'utilisateur clique sur  supprimer Annonce")
    public void lUtilisateurCliqueSurSupprimerAnnonce() throws InterruptedException {
        //Remplir le tableau tab1  du contenu des annonces avant suppression

        List<WebElement> liste = driver.findElements(By.xpath(AnnoncesLocators.List_Annonces));
        int taille = liste.size();
        tab1 = new String[taille];

        for (int i = 0; i < taille; i++) {
            tab1[i] = liste.get(i).getText();
        }

        action.pause(driver, 500);
        driver.findElement(By.xpath(AnnoncesLocators.Bouton_Supprimer_Annonce)).click();


    }


    @Then("vérifier la suppression de l'annonce")
    public void vérifierLaSuppressionDeLAnnonce() throws InterruptedException {
        driver.navigate().refresh();
        action.pause(driver, 1000);
        //Remplir le tableau tab2  du contenu des annonces apres suppression
        //Faire la somme des différences entre les deux tableaux tab1 et tab2
        //Le nombre de différence doit etre supérieur a zero

        List<WebElement> liste = driver.findElements(By.xpath(AnnoncesLocators.List_Annonces));
        int taille = liste.size();
        String[] tab2 = new String[taille];

        for (int i = 0; i < taille; i++) {
            tab2[i] = liste.get(i).getText();
        }

        int nombreDeDifference = 0;
        for (int i = 0; i < taille; i++) {

            String chaine1 = tab1[i];
            String chaine2 = tab2[i];
            if (!chaine1.equals(chaine2)) {
                nombreDeDifference++;
            }

        }


        action.pause(driver, 500);

        Assert.assertNotEquals(nombreDeDifference, 0);


    }


}
