package SCA;

import java.util.Vector;


public class Athlete {

    public final Vector<SymptomEvaluation> evaluationsList;

    public Athlete(){

        evaluationsList = new Vector<SymptomEvaluation>();
    }

    public int vectorSize(){
        return evaluationsList.size();
    }

    public static SymptomEvaluation enterSymptoms(){

        System.out.println("------------SYMPTOMS ENTERING ---------------");
        Symptoms symptom = new Symptoms();
        String [] symptoms;
        symptoms =  symptom.SymptomsData();
        SymptomEvaluation eval = new SymptomEvaluation();
        String response;

        int i = 0;
           while (i < symptoms.length) {
               System.out.print(  i+1 + " - " +"Enter pain level from 0 to 6 for "+" : " +symptoms[i]+ " " );
               try{
                   response = SportConcussionAssessmentUI.scanner.nextLine();
                   int input = Integer.parseInt(response);
                   if((input >= 0) && (input <= 6)){
                        eval.setEvalution(i, input);
                       i++;
                   }
                   else {
                       System.out.println("Error: Enter a Valid Number from 0 to 6");
                   }

               }catch(NumberFormatException e){
                   System.out.println("Error: Enter a Valid Number from 0 to 6");
               }
           }
        System.out.println("------------THANK YOU, WE ARE DONE ---------------");

        return eval;

    }

    public  void storeSymptomsToEvaluationList(SymptomEvaluation lastElement){
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

    public void evaluationSummary(){
        System.out.println("------------HERE'S THE SUMMARY OF YOUR SYMPTOMS-------------");
        System.out.println("Number of evaluations entered earlier : "+  vectorSize());
        String response;
        response = SportConcussionAssessmentUI.scanner.nextLine();
        int input = Integer.parseInt(response);
        if(vectorSize() > 0 ) {

            for (int i = 0; i < evaluationsList.size(); i++) {
                System.out.print("Enter " + (i + 1) + " to view the game symptoms summary");
                try{

                    if (input >= 1 && input <=vectorSize()) {
                        SymptomEvaluation summary = evaluationsList.get(input -1);
                        System.out.println(" Total number of symptoms: "+summary.totalNumberOfSymptoms());
                        System.out.println(" Symptom severity score: "+summary.severityScore());
                        System.out.println(" Overall rating - after comparing with the summary of the previous game: ");


                        System.out.println( summary.getOverallRating(input));
                    }
                }catch (NumberFormatException e){
                    System.out.println("Enter a Valid Number");
                }
              }
            response = SportConcussionAssessmentUI.scanner.nextLine();

        try {
            input = Integer.parseInt(response);
            SymptomEvaluation res = new SymptomEvaluation();
            if (input >= 1 && input <= res.totalNumberOfSymptoms()) {
                SymptomEvaluation summary = evaluationsList.get(input -1);
                System.out.println(" Total number of symptoms: "+summary.totalNumberOfSymptoms());
                System.out.println(" Symptom severity score: "+summary.severityScore());
                System.out.println(" Overall rating - after comparing with the summary of the previous game: ");
                System.out.println( summary.getOverallRating(input));
            } else {
                System.out.println("Please enter a Valid Number");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a Valid Number");
        }
        }
            else {
                System.out.println("Please enter a symptoms and pain scales first to be able to see their summary");
            }

        System.out.println("------------END OF SUMMARY-------------");

    }

    public void displayRisk(){
        System.out.println("------------HERE'S THE RISK LEVEL-------------");
        System.out.println(" Overall rating - after comparing with the summary of the previous game: ");
        SymptomEvaluation rating = new SymptomEvaluation();
        System.out.println( rating.getOverallRating(rating.totalNumberOfSymptoms()));
    }

    boolean checkPreEvaluation(int evaluationNumber){
            if(vectorSize()>1){
                if ((evaluationNumber-2) >= 0) {
                    evaluationsList.get(evaluationNumber-1).getOverallRating(evaluationNumber);
                    return true;
                } else {
                    return false;
                }
            }
            else{
                System.out.println("Please enter a symptom first in order to be able  to view it");
                return false;
            }
        }

}




