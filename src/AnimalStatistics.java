// Name: Amal Johnson
// Student ID: 21263175

public class AnimalStatistics {

    // Data field
    private AnimalShelter animalShelter;

    // Constructor
    public AnimalStatistics(AnimalShelter animalShelter) {
        this.animalShelter = animalShelter;
    }

    // Method to display the total number of each type of animal.
    public void displayTotalAnimalsByType(String animalType){
        int totalNoOfAnimals = animalShelter.getTotalAnimalsByType(animalType);
        System.out.println("Total number of " + animalType + "s taken into shelter: " + totalNoOfAnimals);
    }

    // Method to display the average number of days each type of animal was in the shelter.
    public void displayAverageDaysInShelterByType(String animalType) {
        int averageDays = animalShelter.getAverageDaysInShelterByType(animalType);
        System.out.println("Average number of days in shelter for " + animalType + "s: " + averageDays);
    }

    // Method to display the longest period of time a particular animal type was in the shelter.
    public void displayLongestStayDaysByType(String animalType) {
        int longestStayDays = animalShelter.getLongestStayDaysByType(animalType);
        System.out.println("Longest period of time " + animalType + "s were in the shelter: " + longestStayDays + " days");
    }

    // Method to display the annual cost of running the shelter.
    public void displayAnnualCost() {
        double annualCost = animalShelter.calculateAnnualCost();
        System.out.println("Annual cost of running the shelter: €" + annualCost);
    }
}


