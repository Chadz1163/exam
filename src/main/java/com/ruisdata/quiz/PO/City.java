package com.ruisdata.quiz.PO;

import lombok.Data;

@Data
public class City implements Comparable<City>{

    private Integer id;
    private String cityName;

    @Override
    public int compareTo(City o) {
        int i = this.getId() - o.getId();
        return i;
    }

}
