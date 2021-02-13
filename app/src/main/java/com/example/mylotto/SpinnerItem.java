package com.example.mylotto;

import java.util.ArrayList;

public class SpinnerItem {
    private ArrayList<Integer> list = new ArrayList<>();
    // Set Spinner 1, 2, 3, 4, 5 for make Lotto Times
    SpinnerItem(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }
}
