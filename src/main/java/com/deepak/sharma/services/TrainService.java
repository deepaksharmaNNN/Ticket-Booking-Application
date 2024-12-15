package com.deepak.sharma.services;

import com.deepak.sharma.entities.Train;

import java.util.List;
import java.util.stream.Collectors;

public class TrainService {

    private List<Train> trainList;
    public void getTrainDetails() {
        System.out.println("Train details");
    }

    public List<Train> searchTrains(String source, String destination) {
        System.out.println("Searching trains from " + source + " to " + destination);
        return trainList.stream().filter(train -> {
            return train.getStations().contains(source) && train.getStations().contains(destination);
        }).collect(Collectors.toList());
    }
}
