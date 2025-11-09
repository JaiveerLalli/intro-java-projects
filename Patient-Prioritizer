//Jaiveer Lalli
// 11-01-25
// CSE 121
// P2: Priortizing patients
// TA: Nhan Truong
// This class builds a program that determines whether patients the intensity of care needed
// for specific patients depending on factors that would likely indicate health
// by taking in parameters for various methods to give a priority score
import java.util.*;
public class PatientPrioritizer {
    
    public static final int HOSPITAL_ZIP = 12345;
    
    // calls methods throughout program to print out final results
    // by using a while loop to keep the program going until the user
    // inputs "quit" for patient name
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        intro();
        int amountRan = 0;
        int highScore = 0;
        String nameOfPatient = patientName(console);
        while (!nameOfPatient.equals("quit")) {
            int score = patientInfo(console);
            console.nextLine();
            priorityPrint(nameOfPatient, score);
            amountRan++;
            if (score > highScore) {
                highScore = score;
            }
            System.out.println();
            nameOfPatient = patientName(console);
        }
        overallStats(amountRan, highScore);
    }
    // prints out the intro message
    public static void intro() {
        System.out.println("Hello! We value you and your time, so we will help");
        System.out.println("you prioritize which patients to see next!");
        System.out.println("Please answer the following questions about the next patient so");
        System.out.println("we can help you do your best work :)");
        System.out.println();
    }
    // method returns the patients name
    public static String patientName(Scanner console) {
        System.out.println("Please enter the next patient's name or \"quit\" to end the program.");
        System.out.print("Patient's name: ");
        String namePatient = console.nextLine();
        return namePatient;
    }
    // asks for various kinds of information for the patient including
    // age, zipcode, insurance, pain level, and temperature
    public static int patientInfo(Scanner console) {
        System.out.print("Patient age: ");
        int agePatient = console.nextInt();
        System.out.print("Patient zip code: ");
        int zipCode = console.nextInt();
        String strZipCode = String.valueOf(zipCode);
        while (strZipCode.length() != 5) {
            System.out.print("Invalid zip code, enter valid zip code: ");
            zipCode = console.nextInt();
            strZipCode = String.valueOf(zipCode);
        }
        System.out.print("Is our hospital \"in network\" for the patient's insurance? ");
        String answer = console.next();
        System.out.print("Patient pain level (1-10): ");
        int painLevel = console.nextInt();
        while (painLevel < 1 || painLevel > 10) {
            System.out.print("Invalid pain level, enter valid pain level (1-10): ");
            painLevel = console.nextInt();
        }
        System.out.print("Patient temperature (in degrees Fahrenheit): ");
        double patientTemperature = console.nextDouble();
        return priority(agePatient, zipCode, answer, painLevel, patientTemperature);
    }
    // this method determines and returns the priority score depending on the intensity of care
    // the patient needs
    public static int priority(int age, int zip, String insurance, int pain, double temperature) {
        int score = 75;
        if (age < 12 || age >= 75) {
            score += 54;
        }
        if (fiveDigits(zip)) {
            if ((zip / 10000 % 10) == (HOSPITAL_ZIP / 10000 % 10) 
                && (zip / 1000 % 10) == (HOSPITAL_ZIP / 1000 % 10)) {
                score += 32 + 17;
            } else if ((zip / 10000 % 10) == (HOSPITAL_ZIP / 10000 % 10)) {
                score += 32;
            }
        }
        if (insurance.equals("y") || insurance.equals("yes")) {
            score += 22; 
        }
        if (pain < 7) {
            score += pain + 10;
        } else {
            score += pain + 100;
        }
        if (temperature > 100.4) {
            score += 43;
        }
        return score;
    }
    // delivers a summary of a patient and determines whether they are high, medium, or low
    // priority
    public static void priorityPrint(String name, int score) {
        System.out.println("We have found patient " + name + 
                " to have a priority score of: " + score);
        if (score >= 271) {
            System.out.println("We have determined this patient is high priority,");
            System.out.println("and it is advised to call an appropriate medical provider ASAP.");
        } else if (score >= 121) {
            System.out.println("We have determined this patient is medium priority.");
            System.out.println("Please assign an appropriate medical provider to their case");
            System.out.println("and check back in with the patient's condition in a little while.");
        } else {
            System.out.println("We have determined this patient is low priority.");
            System.out.println("Please put them on the waitlist for " +
                    "when a medical provider becomes available.");
        }
        System.out.println();
        System.out.println("Thank you for using our system!");
        System.out.println("We hope we have helped you do your best!");
    }
    // this method summarizes the method by including the amount of patients
    // as well as the highest score found throughout the day
    public static void overallStats(int numPatients, int maxScore) {
        System.out.println("Statistics for the day:");
        System.out.println("..." + numPatients + " patients were helped");
        System.out.println("...the highest priority patient we saw had a score of " + maxScore);
        System.out.println("Good job today!");
    }

    // [This method is given to you. You should use it as is and not make any edits!]
    // Determines if the given integer has five digits.
    // Parameters:
    //   - val: the integer whose digits will be counted
    // Returns:
    //   - boolean: true if the given integer has 5 digits, and false otherwise.
    public static boolean fiveDigits(int val) {
        val = val / 10000; // get first digit
        if (val == 0) { // has less than 5 digits
            return false;
        } else if (val / 10 == 0) { // has 5 digits
            return true;
        } else { // has more than 5 digits
            return false; 
        }
        // NOTE: the above can be written with improved "boolean zen" as follows: 
        // return val != 0 && val / 10 == 0;
        }
    } 
