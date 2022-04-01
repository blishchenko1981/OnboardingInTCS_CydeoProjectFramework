package com.cydeo.utility;

public class BrowserUtil {

    public static void waitAlittle(int second){


        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



}
