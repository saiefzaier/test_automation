package com.QA.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class streams {

    public static Properties readers() {

        Properties config = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/Configuration.properties");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            config.load(fis);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return config;
    }






}
