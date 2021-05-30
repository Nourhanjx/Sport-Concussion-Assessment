package SCA;

import java.util.Vector;

public class Athlete {

    public final Vector<SymptomEvaluation> evaluationsList;

    public Athlete() {
        evaluationsList = new Vector<SymptomEvaluation>();
    }

    public int vectorSize() {
        return evaluationsList.size();
    }

    public static void SymptomEntering(Athlete athlete) {
        System.out.println("------------SYMPTOMS ENTERING ---------------");
        Symptoms symptom = new Symptoms();
        String[] symptoms;
        symptoms = symptom.SymptomsData();
        SymptomEvaluation evaluation = new SymptomEvaluation();
        String response;

        int i = 0;
        while (i < symptoms.length) {
            System.out.print(i + 1 + " - " + "Enter pain level( none (0), mild(1-2), moderate(3-4) & severity (5-6)) for " + " : " + symptoms[i] + " -> ");
            try {
                response = SportConcussionAssessmentUI.scanner.nextLine();
                int input = Integer.parseInt(response);
                if ((input >= 0) && (input <= 6)) {
                    evaluation.setEvalution(i, input);
                    i++;
                } else {
                    System.out.println("Error: Enter a Valid Number from 0 to 6");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Enter a Valid Number from 0 to 6");
            }
        }
        System.out.println("------------THANK YOU, WE ARE DONE ---------------");

        athlete.storeSymptomsToEvaluationList(evaluation);

    }

    public void evaluationSummary(Athlete athlete) {
        System.out.println("Enter number of game to view it's summary, minimum of 2 games");
        String response;
        if (evaluationsList.size() > 0) {
            response = SportConcussionAssessmentUI.scanner.nextLine();
            int input ;
            try {
                input = Integer.parseInt(response);
                if (input >= 1 && input <= evaluationsList.size()) {
                    System.out.println("You are viewing game summary number " + input);
                    SymptomEvaluation summary = evaluationsList.get(input - 1);
                    System.out.println(" Total number of symptoms: " + summary.totalNumberOfSymptoms());
                    System.out.println(" Symptom severity score: " + summary.severityScore());
                    System.out.println(" Overall rating - after comparing with the summary of the previous game: ");
                    athlete.displaySymptomRisk(input);
                } else {
                    System.out.println("couldn't  find the game you are looking for");
                }
            } catch (NumberFormatException e) {
                System.out.println("No evaluation");
            }
        }else
        { System.out.println("couldn't found an evaluation, please choose the first option to enter and store one"); }
    }

    public void storeSymptomsToEvaluationList(SymptomEvaluation lastElement) {
        // no evaluations
        System.out.println("------------YOUR SYMPTOMS ARE BEING STORED INTO THE SYSTEM ---------------");

        if (evaluationsList.size() > 5) {
            int shitElements=0;
            SymptomEvaluation evaluation = null;

            while(shitElements <= 3){
                evaluation = evaluationsList.get(shitElements + 1);
                shitElements++;
            }
            evaluationsList.set(shitElements, evaluation);
            evaluationsList.set(4, lastElement);
        } else {
            evaluationsList.add(lastElement);
        }
        System.out.println("------------YOUR SYMPTOMS STORED SUCCESSFULLY---------------");

    }

    public String displaySymptomRisk(int storedRate) {

        if (evaluationsList.size() >= 1) {
            try{
                System.out.println("------------HERE'S THE RISK LEVEL-------------");

                if ((storedRate - 2) >= 0) {
                    SymptomEvaluation previousRate = evaluationsList.get(storedRate-2);
                    SymptomEvaluation currentSymptom = new SymptomEvaluation();
                    if ((currentSymptom.totalNumberOfSymptoms() - previousRate.totalNumberOfSymptoms() < 3) && (currentSymptom.severityScore() - previousRate.severityScore()) < 10) {
                        return "GREEN ";
                    }
                    if (((currentSymptom.totalNumberOfSymptoms() - previousRate.totalNumberOfSymptoms()) < 3) && ((currentSymptom.severityScore() - previousRate.severityScore()) >= 10)) {
                        return "YELLOW ";
                    }
                    if (((currentSymptom.totalNumberOfSymptoms() - previousRate.totalNumberOfSymptoms()) >= 3) &&  ((currentSymptom.severityScore() - previousRate.severityScore()) >= 15)) {
                        return "RED ";
                    }
                    return "No ratings";
                } else {
                    return "No ratings";
                }
            }catch(NumberFormatException e){
                System.out.println("I am at exception");
                return "No ratings";
            }
        }else{
            System.out.println("No ratings, Please submit a rating first in order to be able to display the symptomts risk");
            return "";
        }
    }

}