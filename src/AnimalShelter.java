// Name: Amal Johnson
// Student ID: 21263175

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class AnimalShelter {

    // Data fields
    private List<Animal> animals;
    private double dailyCostDog;
    private double dailyCostCat;
    private double dailyCostDonkey;
    private CSVFileManager csvFileManager;

    // Constructor
    public AnimalShelter(double dailyCostDog, double dailyCostCat, double dailyCostDonkey, String filePath) {
        this.animals = new ArrayList<>();
        this.dailyCostDog = dailyCostDog;
        this.dailyCostCat = dailyCostCat;
        this.dailyCostDonkey = dailyCostDonkey;
        this.csvFileManager = new CSVFileManager(filePath);
        loadAnimalsFromCSV();
    }

    // Loading existing data from CSV file
    private void loadAnimalsFromCSV() {
        animals.clear(); // Clearing the list to avoid duplicates
        List<String[]> data = csvFileManager.readData();
        for (String[] values : data) {
            if (values.length >= 3) {
                String type = values[0];
                String name = values[1];
                LocalDate intakeDate = LocalDate.parse(values[2]);
                LocalDate rehomingDate = values.length > 3 && !values[3].isEmpty() ? LocalDate.parse(values[3]) : null;
                Animal animal = new Animal(type, name, intakeDate);
                animal.setRehomingDate(rehomingDate);
                animals.add(animal);
            } else {
                System.out.println("Skipping invalid line in CSV: " + Arrays.toString(values));
            }
        }
    }


    // Method to add a new animal to the shelter system.
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    // Method to add/change the rehoming date of an animal in the system.
    public void updateAnimalRehomingDate(String animalName, LocalDate rehomingDate) {
        for (Animal animal : animals) {
            if (animal.getName().equals(animalName)) {
                animal.setRehomingDate(rehomingDate);
                break;
            }
        }
    }

    // Method to return the total number of each type of animal.
    public int getTotalAnimalsByType(String animalType) {
        int count = 0;
        for (Animal animal : animals) {
            if (animal.getType().equalsIgnoreCase(animalType)) {
                count++;
            }
        }
        return count;
    }

    // Method to calculate the average number of days a particular type of animal was in the shelter.
    public int getAverageDaysInShelterByType(String animalType) {
        int totalDays = 0;
        int count = 0;
        for (Animal animal : animals) {
            if (animal.getType().equalsIgnoreCase(animalType)) {
                totalDays += animal.getDaysInShelter();
                count++;
            }
        }
        return count > 0 ? totalDays / count : 0;
    }

    // Method to calculate the longest period of time that a particular type of animal was in the shelter.
    public int getLongestStayDaysByType(String animalType) {
        int longestStayDays = 0;
        for (Animal animal : animals) {
            if (animal.getType().equalsIgnoreCase(animalType)) {
                int daysInShelter = animal.getDaysInShelter();
                if (daysInShelter > longestStayDays) {
                    longestStayDays = daysInShelter;
                }
            }
        }
        return longestStayDays;
    }

    // Method to calculate the annual cost of running the shelter based on the daily cost of keeping each type of animal.
    public double calculateAnnualCost() {
        double totalCost = 0;
        for (Animal animal : animals) {
            double dailyCost = 0;
            switch (animal.getType().toLowerCase()) {
                case "dog":
                    dailyCost = dailyCostDog;
                    break;
                case "cat":
                    dailyCost = dailyCostCat;
                    break;
                case "donkey":
                    dailyCost = dailyCostDonkey;
                    break;

            }
            totalCost += dailyCost * animal.getDaysInShelter();
        }
        return totalCost;
    }

    // Method to save animal details to CSV File.
    public void saveAnimalsToCSV() {
        List<String[]> data = new ArrayList<>();
        for (Animal animal : animals) {
            String[] values = {
                    animal.getType(),
                    animal.getName(),
                    animal.getIntakeDate().toString(),
                    animal.getRehomingDate() != null ? animal.getRehomingDate().toString() : ""
            };
            data.add(values);
        }
        csvFileManager.writeData(data);
    }
}
