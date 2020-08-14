package com.clockon.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ClockOnModel {
    public static List<Map<String, String>> employees;   // 員工資料
    public static List<Map<String, String>> clockOnlogs; // 打卡紀錄
    static {
        employees = new ArrayList<>();
        Map<String, String> emp1 = new LinkedHashMap<>();
        emp1.put("name", "john");
        emp1.put("no", "a01");
        Map<String, String> emp2 = new LinkedHashMap<>();
        emp2.put("name", "mary");
        emp2.put("no", "b02");
        Map<String, String> emp3 = new LinkedHashMap<>();
        emp3.put("name", "test");
        emp3.put("no", "000");
        employees.add(emp1);
        employees.add(emp2);
        
        clockOnlogs = new ArrayList<>();
        Map<String, String> log = new LinkedHashMap<>();
        log.put("no", "000");
        log.put("time", new Date().toString());
    }
}
