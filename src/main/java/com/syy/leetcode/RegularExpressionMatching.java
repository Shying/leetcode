package com.syy.leetcode;

import java.util.*;
import java.util.List;

public class RegularExpressionMatching {

    public List<List<Character>> splitString(String s) {
        List<List<Character>> splits = new ArrayList<List<Character>>();
        Character lastKey = null;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            Character key = ch;
            if(ch == '*'){
                key = lastKey;
            }
            if(key != lastKey){
                splits.add(new ArrayList<Character>());
            }
            splits.get(splits.size() - 1).add(ch);
            lastKey = key;
        }
        return splits;
    }

    public boolean isMatch0(String s, String p) {
        if(p.indexOf('*') == -1 && p.indexOf('.') == -1) {
            return s.equals(p);
        }

//        将s分组，以每个字符出现次数为准
        List<List<Character>> sSplits = this.splitString(s);
        List<List<Character>> pSplits = this.splitString(p);
        int sIndex = 0;
        int pIndex = 0;
        while(sIndex < sSplits.size() && pIndex < pSplits.size()){
            List<Character> sSub = sSplits.get(sIndex);
            List<Character> pSub = pSplits.get(pIndex);

            char sCh = sSub.get(0);
            char pCh = pSub.get(0);
            if(pCh == sCh){
                if(sSub.size() == pSub.size()){
//                    equal
                    sIndex++;
                    pIndex++;
                    continue;
                }else {
                    if(pSub.indexOf('*') >= 0){
//                        equal
                        sIndex++;
                        pIndex++;
                        continue;
                    }else {
//                        检查下个p是否是.
                        if(pIndex + 1 < pSplits.size()){
                            char nextStart = pSplits.get(pIndex + 1).get(0);
                            if(nextStart == '.') {

                            }
                        }else{
                            return false;
                        }

                    }
                }

            }else if (pCh == '.') {

            }else {
                return false;
            }
        }

        return true;
    }

    public boolean isMatch(String s, String p) {
        int sP = 0;
        int pP = 0;
        char pLast = '.';
        for(; sP < s.length(); sP++){
            char pChar = p.charAt(pP);
            char sChar = s.charAt(sP);
            if(sChar == pChar){
                pP++;
            }else{
                if(pChar == '*'){
                    pChar = pLast;
                }
                if(sChar == pChar){

                }
            }

            pLast = pChar;
        }
        return false;
    }
}
