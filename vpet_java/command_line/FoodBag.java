package command_line;

import java.util.ArrayList;

public class FoodBag {
    private ArrayList<String> foodNamesList;
    private ArrayList<Integer> foodCodesList;
    private ArrayList<Integer> foodQuantityList;
    private ArrayList<String> foodDescriptionsList;

    public FoodBag() {
        foodNamesList = new ArrayList<>();
        foodCodesList = new ArrayList<>();
        foodDescriptionsList = new ArrayList<>();
    }

    public ArrayList<String> getNamesList() {
        return foodNamesList;
    }

    public ArrayList<Integer> getCodesList() {
        return foodCodesList;
    }

    public ArrayList<String> getDescriptionsList() {
        return foodDescriptionsList;
    }

    public ArrayList<Integer> getQuantityList() {
        return foodQuantityList;
    }
}