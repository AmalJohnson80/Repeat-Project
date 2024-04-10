// Name: Amal Johnson
// Student ID: 21263175

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String csvFilePath = "animal_details.csv";
        AnimalShelter animalShelter = new AnimalShelter(3.0, 2.0, 5.0, csvFilePath);
        AnimalStatistics animalStatistics = new AnimalStatistics(animalShelter);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nAnimal Shelter System Menu:");
            System.out.println("1. Add new animal");
            System.out.println("2. Update animal rehoming date");
            System.out.println("3. Display average days in shelter for an animal type");
            System.out.println("4. Display longest stay days for an animal type");
            System.out.println("5. Display the total number of animals in the shelter by animal type");
            System.out.println("6. Display annual cost of running the shelter");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                // Adding a new animal to the system.
                case 1:
                    System.out.println("Enter animal type (dog/cat/donkey): ");
                    String type = scanner.nextLine();
                    System.out.println("Enter animal name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter intake date (yyyy-mm-dd): ");
                    LocalDate intakeDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    Animal newAnimal = new Animal(type, name, intakeDate);
                    animalShelter.addAnimal(newAnimal);
                    break;
                // Adding/changing the rehoming date of the animal.
                case 2:
                    System.out.println("Enter animal name: ");
                    String animalName = scanner.nextLine();
                    System.out.println("Enter rehoming date (yyyy-mm-dd): ");
                    LocalDate rehomingDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    animalShelter.updateAnimalRehomingDate(animalName, rehomingDate);
                    break;
                // Retrieving the average number of days dogs/cats/donkeys were in the shelter.
                case 3:
                    System.out.println("Enter animal type (dog/cat/donkey): ");
                    String animalType = scanner.nextLine();
                    animalStatistics.displayAverageDaysInShelterByType(animalType);
                    break;
                // Retrieving the longest period of time dogs/cats/donkeys were in the shelter.
                case 4:
                    System.out.println("Enter animal type (dog/cat/donkey): ");
                    animalType = scanner.nextLine();
                    animalStatistics.displayLongestStayDaysByType(animalType);
                    break;
                // Retrieving the total number of each animal type taken into the shelter.
                case 5:
                    System.out.println("Enter animal type (dog/cat/donkey): ");
                    animalType = scanner.nextLine();
                    animalStatistics.displayTotalAnimalsByType(animalType);
                    break;
                // Retrieving the annual cost of running the shelter.
                case 6:
                    animalStatistics.displayAnnualCost();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
        animalShelter.saveAnimalsToCSV();
    }
}