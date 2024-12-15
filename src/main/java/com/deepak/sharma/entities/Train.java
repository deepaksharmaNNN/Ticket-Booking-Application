package com.deepak.sharma.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainName;
    private List<List<Integer>> seats;
    private Map<String, LocalDateTime> schedule;
    private List<String> stations;
}
