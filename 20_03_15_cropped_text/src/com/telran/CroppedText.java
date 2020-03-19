package com.telran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CroppedText {
    /**
     * crop the text so that it contains no more than k symbols. If the symbols in the end do not compose a ward,
     * than remove them down to the previous word.
     * @param text String to crop
     * @param k the text length limit
     * @return cropped text according to the rule
     */
    public String getCroppedText (String text, int k){
        int length = text.length();

        if(k>=length)
            return text;

        String res = text.substring(0,k+1);
        int lastSpaceIndex = res.lastIndexOf(" ");
        res = lastSpaceIndex<0?"":res.substring(0,lastSpaceIndex);

        return res;

//        String substringTxt  = text.substring(0,k);
//        List<String> listText = Arrays.asList(text.split(" "));
//        List<String> listSubstring = Arrays.asList(substringTxt.split(" "));
//
//        List<String>res = new ArrayList<>(k);
//
//        for (int i = 0; i <listText.size() ; i++) {
//            for (int j = 0; j <listSubstring.size() ; j++) {
//                if (listText.get(i).compareTo(listSubstring.get(j))==0)
//                    res.add(listText.get(i));
//
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//
//        for (String word: res){
//            sb.append(word+" ");
//        }
//        String croppedText = sb.toString();
//        String result = croppedText;
//
//        if(croppedText.length()>k){
//            result = croppedText.substring(0,k);
//        }
//
//        return result;
    }
}
