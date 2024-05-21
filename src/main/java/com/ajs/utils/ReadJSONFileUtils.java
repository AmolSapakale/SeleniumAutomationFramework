package com.ajs.utils;

import com.ajs.constants.FrameworkConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ReadJSONFileUtils {

    public static Object[] getJsonData() {


        HashMap<String, Object> map;
        try {
            map = new ObjectMapper().readValue(new File(FrameworkConstants.getJSONFilePath()),
                                                        new TypeReference<HashMap<String, Object>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new Object[]{map};

    }
}




