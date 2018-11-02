package com.demo.enu;

import java.util.HashMap;
import java.util.Map;

public enum CategoryEnum {


    WJ("01", "文具"),
    SP("02", "食品"),
    SH("03", "生活用品"),
    ;

    private String code;
    private String name;

    CategoryEnum(String code, String name){
        this.code = code;
        this.name = name;
    }

    public static Map<String, String> getMap(){
        Map<String, String> map = new HashMap<>();
        for(CategoryEnum e : CategoryEnum.values()){
            map.put(e.code, e.name);
        }
        return map;
    }

}
