package com.bigdata.model;

import com.google.gson.Gson;
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
            saleses = new Gson().fromJson(json, Sales[].class);
        } catch (Exception e) {
        }
    }

    public static Sales[] getSaleses() {
        return saleses;
    }
    
    
    
    
}
