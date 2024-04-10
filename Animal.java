// Name: Amal Johnson
// Student ID: 21263175

import java.time.LocalDate;

public class Animal {
    // Data fields
    private String type;
    private String name;
    private LocalDate intakeDate;
    private LocalDate rehomingDate;

    // Constructor
    public Animal(String type, String name, LocalDate intakeDate) {
        this.type = type;
        this.name = name;
        this.intakeDate = intakeDate;
        this.rehomingDate = null;
    }

    // Get and set methods
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public LocalDate getIntakeDate() {
        return intakeDate;
    }

    public LocalDate getRehomingDate() {
        return rehomingDate;
    }

    public void setRehomingDate(LocalDate rehomingDate) {
        this.rehomingDate = rehomingDate;
    }

    /** Method to return the number of days an animal was in the shelter. */
    public int getDaysInShelter() {
        if (rehomingDate != null) {
            return (int) intakeDate.until(rehomingDate).getDays();
        }
        return (int) intakeDate.until(LocalDate.now()).getDays();
    }
}
