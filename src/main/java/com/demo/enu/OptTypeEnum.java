package com.demo.enu;

import java.util.HashMap;
import java.util.Map;

public enum OptTypeEnum {


    IN("1", "入库"),
    OUT("2", "出库");

    OptTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private String code;
    private String name;

    public static Map<String, String> getMap(){
        Map<String, String> map = new HashMap<>();
        for(OptTypeEnum e : OptTypeEnum.values()){
            map.put(e.code, e.name);
        }
        return map;
    }

}
