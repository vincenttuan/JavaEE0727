package com.bigdata.model;

import java.io.File;
import java.util.Scanner;

public class SalesModel {

    private static Sales[] saleses;

    static {
        try {
            // json file
            String path = "src\\main\\java\\com\\bigdata\\model\\csvjson.json";
            File file = new File(path);
            String json = new Scanner(file).useDelimiter("\\A").next();
            
        } catch (Exception e) {
        }

    }
}
