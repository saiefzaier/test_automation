package com.QA.steps.talent.configuration;

import com.QA.locators.ConfigurationTalentLocators;
import com.QA.steps.ActionsCommunes;
import com.QA.steps.GenerateurDriver;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AjoutClassificationDeCompetence {

    private static final WebDriver driver = GenerateurDriver.driver;
    private ActionsCommunes action = new ActionsCommunes();
    private static int nombrePage;
    private static int dernierLibelleAfficherIndice;

    @And("verifier que le dernier libelle {string}")
    public void verifierQueLeDernierLibelle(String libelle) throws InterruptedException {



        String str1=driver.findElement(By.cssSelector(ConfigurationTalentLocators.Liste_Nombre_Classification_Afficher)).getAttribute("innerText");

        //récuperer le nombre d'element

        int pos1=str1.indexOf("de")+3;
        int pos2=str1.indexOf("entrées")-1;


        //recuperer le nombre de page

        String str3= str1.substring(pos1, pos2);

        int i = Integer.parseInt(str3);


        nombrePage = i/10;


        if(i%10!=0) {
            nombrePage++;
        }

      //Calculer le nombre de click

        int nbClick=nombrePage-1;


      if(nombrePage==1){

          String libelleAffiche= driver.findElement(By.xpath(ConfigurationTalentLocators.Derniere_Classification_Affichee_Libelle)).getAttribute("title");
          Assert.assertEquals(libelleAffiche,libelle);

      }
      else{

          boolean trouve=false;
          int j=1;

          while(trouve==false && j<=nbClick){

              driver.findElement(By.cssSelector(ConfigurationTalentLocators.Bouton_Pagination_Competence_Classification)).click();
              action.pause(driver,1000);

              //rechercher l'indice du derniere element de la liste

              List<WebElement> list =driver.findElements(By.xpath(ConfigurationTalentLocators.Liste_Calification_Configuration_Talent));
              dernierLibelleAfficherIndice=list.size();


              String beforeXpath="/html/body/app-root/app-layout/div/section/div/acc-hr-talent-component/acc-hr-talent-configuration/div[2]/div[2]/section/acc-evaluation-configuration-classication/div[2]/section/div[2]/div/div[1]/acc-evaluation-configuration-classification-table/table/tbody/tr[";
              String afterXpath="]/td[1]";

              String actualXpath=beforeXpath+dernierLibelleAfficherIndice+afterXpath;
              WebElement element=driver.findElement(By.xpath(actualXpath));
              String test=element.getAttribute("title");

              if(test.equals(libelle)){
                  trouve=true;
                  break;
              }

              j++;

          }

           Assert.assertTrue(trouve);
      }






      /*

        WebElement modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ConfigurationTalentLocators.Derniere_Classification_Affichee_Libelle)));

        Boolean modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.attributeToBe(By.xpath(ConfigurationTalentLocators.Derniere_Classification_Affichee_Libelle), "title", arg0));

        String str1= driver.findElement(By.xpath(ConfigurationTalentLocators.Derniere_Classification_Affichee_Libelle)).getAttribute("title");

        Assert.assertEquals(str1,arg0);


       */


    }


    @And("verifier que la derniere classification parent {string}")
    public void verifierQueLaDerniereClassificationParent(String classification) {




         if(nombrePage==1){

             String classificationAffiche= driver.findElement(By.xpath(ConfigurationTalentLocators.Derniere_Classification_Affichee_ClassificationParent)).getAttribute("innerText");
             Assert.assertEquals(classificationAffiche,classification);

         }
         else{



             String beforeXpath="/html/body/app-root/app-layout/div/section/div/acc-hr-talent-component/acc-hr-talent-configuration/div[2]/div[2]/section/acc-evaluation-configuration-classication/div[2]/section/div[2]/div/div[1]/acc-evaluation-configuration-classification-table/table/tbody/tr[";
             String afterXpath="]/td[2]";


             String actualXpath=beforeXpath+dernierLibelleAfficherIndice+afterXpath;
             WebElement element=driver.findElement(By.xpath(actualXpath));
             String test=element.getAttribute("innerText");



              Assert.assertEquals(classification,test);



         }


        /*
        WebElement modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ConfigurationTalentLocators.Derniere_Classification_Affichee_ClassificationParent)));

        Boolean modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.attributeToBe(By.xpath(ConfigurationTalentLocators.Derniere_Classification_Affichee_ClassificationParent), "innerText", arg0));

        String str1= driver.findElement(By.xpath(ConfigurationTalentLocators.Derniere_Classification_Affichee_ClassificationParent)).getAttribute("innerText");

        Assert.assertEquals(str1,arg0);

        */




    }


    @And("verifier que la derniere echelle {string}")
    public void verifierQueLaDerniereEchelle(String echelle) {


        if(nombrePage==1){

            String echelleAffiche= driver.findElement(By.xpath(ConfigurationTalentLocators.Derniere_Classification_Affichee_Echelle)).getAttribute("innerText");
            Assert.assertEquals(echelleAffiche,echelle);

        }
        else{



            String beforeXpath="/html/body/app-root/app-layout/div/section/div/acc-hr-talent-component/acc-hr-talent-configuration/div[2]/div[2]/section/acc-evaluation-configuration-classication/div[2]/section/div[2]/div/div[1]/acc-evaluation-configuration-classification-table/table/tbody/tr[";
            String afterXpath="]/td[3]";


            String actualXpath=beforeXpath+dernierLibelleAfficherIndice+afterXpath;
            WebElement element=driver.findElement(By.xpath(actualXpath));
            String test=element.getAttribute("innerText");



            Assert.assertEquals(echelle,test);



        }






       /*
        WebElement modules1 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ConfigurationTalentLocators.Derniere_Classification_Affichee_Echelle)));

        Boolean modules2 = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.attributeToBe(   By.xpath(ConfigurationTalentLocators.Derniere_Classification_Affichee_Echelle), "innerText", arg0));

        String str1= driver.findElement(By.xpath(ConfigurationTalentLocators.Derniere_Classification_Affichee_Echelle)).getAttribute("innerText");

        Assert.assertEquals(str1,arg0);

      */


    }


}
