package org.example;

import org.example.domain.Identifier;
import org.example.vehicles.Automobile;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Inventory {
    Set<Automobile> automobiles = new HashSet<>();

    public void add(Automobile automobile) {
        automobiles.add(automobile);
    }

    public int stockSize() {
        return automobiles.size();
    }

    public Set<Identifier> identifiers() {

        Set<Identifier> vinSet = new HashSet<>();
        for(Automobile automobile : automobiles){
            vinSet.add(automobile.getVin());
        }
        return vinSet;
        // equivalent to
//        return automobiles
//                .stream()
//                .map(Automobile::getVin)
//                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        // Your playground. Try to create new Car Track, chcek vin,
        // add Automobile to inventory.
    }
}
