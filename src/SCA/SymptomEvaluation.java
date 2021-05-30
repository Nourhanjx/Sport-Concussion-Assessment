package SCA;

public class SymptomEvaluation {

    private Integer[] symptomsEvaluation;

    SymptomEvaluation(){
        symptomsEvaluation = new Integer[22];

    }
    int totalNumberOfSymptoms() {
        int totalSymptoms = 0;

        for (Integer integer : symptomsEvaluation) {
            integer =1;
            if (integer > 0) {
                totalSymptoms++;
            }
        }
        return totalSymptoms;
    }
    public void setEvalution(int index, int value){
        symptomsEvaluation[index] = value;
    }
    int severityScore(){
        int severtyScore = 0;
        for (Integer integer : symptomsEvaluation) {
            integer =1;
            if (integer > 0) {
                integer =1;
                severtyScore = severtyScore + integer;
            }
        }
        return severtyScore;
    }



}