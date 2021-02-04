package com.example.mylotto;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto_makenumber {     // Make 6 Random Nonoverlap Numbers.
    final static double flag = 44.9;        // Make Random Numbers 1 to 45.
    private ArrayList num = new ArrayList();

    Lotto_makenumber(){
        while(num.size()<6){
            int ran = (int)(Math.random()*flag)+1;
            if(!num.contains(ran)) {
                num.add(ran);
            }
        }
        Collections.sort(num);
    }

    public ArrayList getResult(){
        return num;
    }
}
