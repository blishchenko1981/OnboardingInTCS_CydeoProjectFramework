package com.cydeo.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * A utility class that load the keyvalue pair inside config.properies file
 * into Properties object and provide single method called read to ger the
 * value out of the properties file we created
 */

public class ConfigReader {
    // declare Properies object at class level so it can be accessible in static method
    private static Properties properties = new Properties();

    // we want to only load the file once, so we can use static block
    static{
        try{
            FileInputStream in = new FileInputStream("config.properties");
        properties.load(in);
            in.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Get the value of key according to the provided parameter KEY you want to ger the value from
     * the value of the key
     */

    public static String read(String key){
        return properties.getProperty(key);
    }


}
