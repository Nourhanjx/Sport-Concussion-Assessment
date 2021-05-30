package SCA;

public class SymptomEvaluation {

    private final Integer [] symptomsEvaluation;

    SymptomEvaluation(){
       symptomsEvaluation = new Integer[22];

    }

    public int getEvaluation(int index){
        return symptomsEvaluation[index];
    }

    public void setEvalution(int index, int value){
        symptomsEvaluation[index] = value;
    }

    int totalNumberOfSymptoms(){
        int totalSymptoms = 0;
        for (Integer integer : symptomsEvaluation) {
            if (integer > 0) {
                totalSymptoms++;
            }
        }
        return totalSymptoms;
    }

    int severityScore(){
        int severtyScore = 0;
        for (Integer integer : symptomsEvaluation) {
            if (integer > 0) {
                severtyScore = severtyScore + integer;
            }
        }
        return severtyScore;
    }

    public String getOverallRating(int EvNo) {
        Athlete eval = new Athlete();
        SymptomEvaluation noEvaluation = eval.evaluationsList.get(EvNo-2);
        Athlete Ath = new Athlete();
        String result = null;

        if(Ath.checkPreEvaluation(EvNo)){
            if ((Math.abs(totalNumberOfSymptoms() - noEvaluation.totalNumberOfSymptoms()) < 3) && (Math.abs(severityScore() - noEvaluation.severityScore()) < 10)) {
                result = "No difference";
            }
            if ((Math.abs(totalNumberOfSymptoms() - noEvaluation.totalNumberOfSymptoms()) < 3) && (Math.abs(severityScore() - noEvaluation.severityScore()) >= 10)) {
                result = "Unsure";
            }
            if ((Math.abs(totalNumberOfSymptoms() - noEvaluation.totalNumberOfSymptoms()) >= 3)  &&  (Math.abs(severityScore() - noEvaluation.severityScore()) >= 15)) {
                result = "Very different";
            }
        }
        return result;

    }

}
