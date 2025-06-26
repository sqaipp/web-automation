package com.automation.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomHelper {

    public String getRandomAlphanumericString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public String getRandomNumberAsString(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String getRandomAlphabeticString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public void getRandomNames() {
        String[] fName = {"Muchlis", "Majid", "Ryan", "Saesar", "Resha", "Lynet",
                "Gabby", "Puyono", "Dewi", "Ovi", "Aziza", "Nurin", "Dimas"};
        String[] lName = {"Doe", "Smith", "Johnson", "Williams", "Jones", "Brown", "Hood"};
        Random random = new Random();
        String randomName = fName[random.nextInt(fName.length)] + " " + lName[random.nextInt(lName.length)];
    }

    public <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

}
