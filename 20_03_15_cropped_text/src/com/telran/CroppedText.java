package com.telran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CroppedText {

    public String getCroppedText (String text, int k){
        String substringTxt  = text.substring(0,k);
        List<String> listText = Arrays.asList(text.split(" "));
        List<String> listSubstring = Arrays.asList(substringTxt.split(" "));

        List<String>res = new ArrayList<>(k);

        for (int i = 0; i <listText.size() ; i++) {
            for (int j = 0; j <listSubstring.size() ; j++) {
                if (listText.get(i).compareTo(listSubstring.get(j))==0)
                    res.add(listText.get(i));

            }
        }
        StringBuilder sb = new StringBuilder();

        for (String word: res){
            sb.append(word+" ");
        }
        String croppedText = sb.toString();
        String result = croppedText;

        if(croppedText.length()>k){
            result = croppedText.substring(0,k);
        }

        return result;
    }
}
