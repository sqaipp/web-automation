package com.automation.utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class APISample {

    public static void loop2Array() throws IOException {
        String keyword_search_plu = "test1, test2, test3";
        String[] keywordList = keyword_search_plu.split(", ");
        String num = "1, 1, 2";
        String[] numList = num.split(", ");

        for (int i = 0; i < numList.length; i++) {
            String name = keywordList[i];
            String numm = numList[i];
            System.out.println(name + ": " + numm);
        }
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

    public static void splitLastWord() throws IOException {
        String one = "Düsseldorf - Zentrum - Günnewig Uebachs";

        String[] bits = one.split("-");
        String lastOne = bits[bits.length-1];
        System.out.println(lastOne);
    }

    public static void main(String[] args) throws IOException {
        //loop2Array();
        //splitLastWord();
        List<String> list1 = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        List<String> list2 = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));

        List<String> list3 = new APISample().intersection(list1, list2);

        List<String> arrlist2 = list3.subList(0, 3);
        System.out.println("Sublist of arrlist: " + arrlist2);

    }
}
