package com.QA.steps;

import org.openqa.selenium.WebDriver;

import static com.QA.steps.EtapesCommunes.listededonnees;

public class ActionsCommunes {

    public void pause(WebDriver driver, int time) throws InterruptedException {
        synchronized (driver) {
            driver.wait(time);
        }
    }

    public static String DataProvider(String str) {
        String data = null;
        for (int i = 0; i < listededonnees.size(); i++) {
            if (listededonnees.get(i).contains(str)) {
                data =  listededonnees.get(i+1);
                break;
            }
        }
        return data;
    }

}
