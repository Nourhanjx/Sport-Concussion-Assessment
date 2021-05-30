package SCA;

import SCA.Athlete;

import java.util.Scanner; // Import the Scanner class

public class SportConcussionAssessmentUI {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        String response = "";
        Athlete athlete = new Athlete();

        while (true) {

            System.out.print("Welcome to the sport concussion assessment"+ System.lineSeparator() + "Please Choose an option from below" + System.lineSeparator() + "1- Enter Symptoms concerns on pain level scale" + System.lineSeparator() + "2- Display Symptoms Summary" + System.lineSeparator() + "3- Display Symptoms Risk " + System.lineSeparator() + "4- Exit the application" + System.lineSeparator());
            response = scanner.nextLine();

            try{
                int input = Integer.parseInt(response);

                // New Evaluation
                if (input == 1) {
                    Athlete.SymptomEntering(athlete);
                    System.out.println("You have entered your symptoms successfully");

                } else if (input == 2) {

                    athlete.evaluationSummary(athlete);

                } else if (input == 3) {
                    int risk = athlete.vectorSize();
                    athlete.displaySymptomRisk(risk);
                }
                else if (input==4 || response.equals("Exit")) {
                    System.out.print("Thank you for using the application");
                    break;
                }
                else {
                    System.out.println("Wrong Option please enter a valid number ");
                }
            }catch (NumberFormatException e){
                System.out.println("Wrong Option please enter a valid number ");
            }


        }
        scanner.close();

    }

}