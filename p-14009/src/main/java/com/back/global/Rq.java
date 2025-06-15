package com.back.global;

import java.util.Arrays;
import java.util.Map;

public class Rq {
    private final String actionName;
//    private final Map<String, String> paramsMap;

    public Rq(String cmd) {
        String[] cmdBits = cmd.split("\\?");
        actionName = cmdBits[0];


    }

    public int getParamAsInt(String id, int i) {
        return 1;
    }
}
