package com.deepak.sharma.entities;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainName;
    private List<List<Integer>> seats;
    private Map<String, Date> schedule;
    private List<String> stations;
}
