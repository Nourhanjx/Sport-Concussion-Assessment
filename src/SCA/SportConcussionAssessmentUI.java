package SCA;

import java.util.Scanner;

public class SportConcussionAssessmentUI {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String [] args){

        String response = "";
        Athlete athlete = new Athlete();

        while (true){
            System.out.print("Welcome to the sport concussion assessment"+ System.lineSeparator() + "Please Choose an option from below" + System.lineSeparator() + "1- Enter Symptoms concerns on pain level scale" + System.lineSeparator() + "2- Display Symptoms Summary" + System.lineSeparator() + "3- Display Symptoms Risk " + System.lineSeparator() + "4- Exit the application" + System.lineSeparator());
            SymptomEvaluation res;
            response = scanner.nextLine();
            int input = Integer.parseInt(response);
            if(input==1){
               res = Athlete.enterSymptoms();
               athlete.storeSymptomsToEvaluationList(res);
               System.out.println("You have entered your symptoms successfully");
            }
           else  if(input==2){
                athlete.evaluationSummary();
            }
           else if(input==3){
                athlete.displayRisk();
            }
         else if (response.equals("exit") || response.equals("Exit")) {
             System.out.print("Thank you for using the application");
                break;
            } else {
                System.out.println("Wrong Option please enter a valid number ");
            }
        }
        scanner.close();

    }

}
