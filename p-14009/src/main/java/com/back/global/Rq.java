package com.back.global;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Rq {
    private final String actionName;
    private final Map<String, String> paramsMap = new HashMap<>();

    public Rq(String cmd) {
        String[] cmdBits = cmd.split("\\?");
        actionName = cmdBits[0];


        if(cmdBits.length > 1) {
            String queryString = cmdBits[1].trim();

            String[] part = queryString.split("=");

            if(part.length > 1) {
                paramsMap.put(part[0], part[1]);
            }
        }
    }

    public int getParamAsInt(String action, int i) {
        if(paramsMap.get(action) == null) {
            return i;
        }

        return Integer.parseInt(paramsMap.get(action));
    }
}
