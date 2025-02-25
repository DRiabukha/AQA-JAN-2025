package org.prog.collections;

//TODO: write collection of cars (MAP/SET/LIST)
//TODO: WHERE: CAR CAN HAVE NO OWNER
//TODO: WHERE: CAR CAN HAVE 1 OR MORE OWNERS
//TODO: Write method that will print all owners sharing car

import org.prog.parent.Car;

import java.util.*;

/**
 * Car1 -> John
 * Car2 -> John, Jane
 * Car3 -> Jane
 * Car4 ->
 * Car5 -> Sarah, Peter
 * Car6 -> Peter
 * Car7 -> Bob
 * Car8 -> Ivy
 * expected result: Peter, Sarah, John, Jane
 */

public class CollectionsHomework {

    public static void main(String[] args) {
        String driver1 = "John";
        String driver2 = "Jane";
        String driver3 = "Sarah";
        String driver4 = "Peter";
        String driver5 = "Bob";
        String driver6 = "Ivy";


        Map<String, List<String>> cars = new HashMap<>();
        cars.put("Car1", new ArrayList<>());
        cars.put("Car2", new ArrayList<>());
        cars.put("Car3", new ArrayList<>());
        cars.put("Car4", new ArrayList<>());
        cars.put("Car5", new ArrayList<>());
        cars.put("Car6", new ArrayList<>());
        cars.put("Car7", new ArrayList<>());
        cars.put("Car8", new ArrayList<>());


        cars.get("Car1").add(driver1);

        cars.get("Car2").add(driver1);
        cars.get("Car2").add(driver2);

        cars.get("Car3").add(driver2);

        // Car4 have no driver

        cars.get("Car5").add(driver3);
        cars.get("Car5").add(driver4);

        cars.get("Car6").add(driver4);

        cars.get("Car7").add(driver5);

        cars.get("Car8").add(driver6);

        whoShareCar(cars);
    }

    public static void whoShareCar(Map<String, List<String>> cars) {
        Set<String> sharedDrivers = new HashSet<>();

        for (List<String> drivers : cars.values()) {
            if (drivers.size() > 1) {
                sharedDrivers.addAll(drivers);
            }
        }

        System.out.println(sharedDrivers);
    }
}

