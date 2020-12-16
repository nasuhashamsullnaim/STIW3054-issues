package my.issues.issue15;

import java.util.ArrayList;

public class animalArrayList {

    public static void main(String[] args) {

        animal animal1 = new animal("Tiger");
        animal animal2 = new animal("Elephant");
        animal animal3 = new animal("Lion");
        animal animal4 = new animal("Cat");
        animal animal5 = new animal("Dog");
        animal animal6 = new animal("Bird");

        ArrayList<animal> carList = new ArrayList<>();
        carList.add(animal1);
        carList.add(animal2);
        carList.add(animal3);
        System.out.println(carList); //Add 3 objects in arrayList

        carList.remove(animal3);  //Remove last object fro arrayList
        System.out.println(carList);

        carList.add(animal4);
        System.out.println(carList);  //Add new objects

        carList.remove(animal1);  //Remove first object fro arrayList
        System.out.println(carList);

        carList.add(animal5);
        System.out.println(carList);  //Add new objects

        carList.add(animal6);
        System.out.println(carList);  //Add new objects

        carList.remove(animal2);  //Remove last object fro arrayList
        System.out.println(carList);

    }
}
