package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlternativeService {


    public static ArrayList<RankedAlternative> countValdCriteria(final ArrayList<Alternative> alternatives){
        ArrayList<CriteriaPerAlternative> criteriaList = new ArrayList<>();
        double result;
        for (Alternative alternative : alternatives) {
            result = Collections.min(alternative.getScores());
            criteriaList.add(new CriteriaPerAlternative(result, alternative));      //add resulting score and Alternative it belongs to to an Array
        }
            criteriaList.sort(Collections.reverseOrder());                     //sort alternatives by  score to get rank

        return setRank(criteriaList);
    }

    public static ArrayList<RankedAlternative> countMaxMaxCriteria(final ArrayList<Alternative> alternatives){

        ArrayList<CriteriaPerAlternative> criteriaList = new ArrayList<>();
        double result;
        for (Alternative alternative : alternatives) {
            result = Collections.max(alternative.getScores());
            criteriaList.add(new CriteriaPerAlternative(result, alternative));
        }
        criteriaList.sort(Collections.reverseOrder());

        return setRank(criteriaList);
    }

    public static ArrayList<RankedAlternative> countGurwitzCriteria(final ArrayList<Alternative> alternatives){
        double lambda = 0.6;
        ArrayList<CriteriaPerAlternative> criteriaList = new ArrayList<>();
        double result;
        for (Alternative alternative:
             alternatives) {
            double lambdaMax = lambda * alternative.getScores().stream().max(Double::compareTo).get();
            double lambdaMin = (1 - lambda) * alternative.getScores().stream().min(Double::compareTo).get();
            result = lambdaMax + lambdaMin;
            criteriaList.add(new CriteriaPerAlternative(result, alternative));
        }
        criteriaList.sort(Collections.reverseOrder());

        return setRank(criteriaList);
    }

    public static ArrayList<RankedAlternative> countRegretCriteria(final ArrayList<Alternative> alternatives){
        List<Integer> maxValues = new ArrayList<>();
        List<Alternative> newAlternatives = cloneAlternatives(alternatives);
            for (int i = 0; i <alternatives.get(0).getScores().size() ; i++) {
                double max = 0;
                for (Alternative alternative : alternatives) {
                    Double result = alternative.getScores().get(i);
                    if (result > max) {
                        max = result;
                    }
                }
                for (int j = 0; j <alternatives.size() ; j++) {
                    newAlternatives.get(j).getScores().set(i, max - alternatives.get(j).getScores().get(i));
                }
            }
        ArrayList<CriteriaPerAlternative> criteriaList = new ArrayList<>();
        double result;
        for (int i = 0; i < newAlternatives.size() ; i++) {
            result = Collections.max(newAlternatives.get(i).getScores());
            criteriaList.add(new CriteriaPerAlternative(result, alternatives.get(i))); //getting previous alternative value
        }
        Collections.sort(criteriaList);

        return setRank(criteriaList);
    }


    public static ArrayList<RankedAlternative> countLaplasCriteria(final ArrayList<Alternative> alternatives) {
        ArrayList<CriteriaPerAlternative> criteriaList = new ArrayList<>();
        double result;
        for (Alternative alternative : alternatives){
            result = alternative.getScores().stream().mapToDouble(Double::doubleValue).sum()
                    /alternative.getScores().size();
            criteriaList.add(new CriteriaPerAlternative(result, alternative));
        }
        criteriaList.sort(Collections.reverseOrder());

        return setRank(criteriaList);
    }

    private static ArrayList<RankedAlternative> setRank(final ArrayList<CriteriaPerAlternative> criteriaList) {

        ArrayList<RankedAlternative> rankedAlternatives = new ArrayList<>();
        for (int i = 0; i <criteriaList.size() ; i++) {
            RankedAlternative rankedAlternative =                                        //set rank = index in ordered criteriaList + 1)
                    new RankedAlternative(criteriaList.get(i).getAlternative(),criteriaList.get(i).getValue(), i + 1);
            rankedAlternatives.add(rankedAlternative);
        }

        return rankedAlternatives;
    }

    private static List<Alternative> cloneAlternatives(ArrayList<Alternative> alternatives) {
        List<Alternative> clonedAlternativeList = new ArrayList<>();
        for (Alternative alternative : alternatives)
        {
            Alternative clonedAlternative = new Alternative(alternative.getSerialNumber(),
                    alternative.getName(),
                    new ArrayList<Double>(alternative.getScores()));
            clonedAlternativeList.add(clonedAlternative);
        }
        return clonedAlternativeList;
    }
}
