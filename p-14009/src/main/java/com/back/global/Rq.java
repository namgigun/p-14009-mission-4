package com.back.global;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class Rq {
    private final String actionName;
    private final Map<String, String> paramsMap = new HashMap<>();

    public Rq(String cmd) {
        String[] cmdBits = cmd.split("\\?");
        actionName = cmdBits[0];


        if(cmdBits.length > 1) {
            String queryString = cmdBits[1].trim();

            String[] part1 = queryString.split("&");

            for(String s : part1) {
                String[] part2 = s.split("=");

                if(part2.length > 1) {
                    paramsMap.put(part2[0], part2[1]);
                }
            }
        }
    }

    public int getParamAsInt(String action, int defaultValue) {
        try {
            return Integer.parseInt(paramsMap.get(action));
        } catch (NullPointerException | NumberFormatException e) {
            return defaultValue;
        }
    }

    public String getParam(String searchKeyword, String defaultValue) {
        if(paramsMap.get(searchKeyword) == null) {
            return defaultValue;
        }

        return paramsMap.get(searchKeyword);
    }
}
