package com.tuts.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class ReadFromJson {


    @Test
    public void readDataFromJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src/test/java/data/Test.json");
        Object objectParser = jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject) objectParser;
        String name = jsonObject.get("name").toString();
        Long age = (Long) jsonObject.get("age");
        JSONArray array = (JSONArray) jsonObject.get("skills");
        System.out.println("Name  :" + name);
        System.out.println("Age   :" + age);
        Iterator iterator = array.iterator();
        while (iterator.hasNext()) {
            System.out.println("Skill : " + iterator.next());
        }

    }
}
