package core;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AlternativeService {

    //ranking Alternatives by Vald criteria
    public static ArrayList<RankedAlternative> countValdCriteria(final ArrayList<Alternative> alternatives){
        return countCriteriaAndRank(alternatives, Type.MIN, SortOrder.DESCENDING);
    }

    public static ArrayList<RankedAlternative> countMaxMaxCriteria(final ArrayList<Alternative> alternatives){
        return countCriteriaAndRank(alternatives, Type.MAX, SortOrder.DESCENDING);
    }

    public static ArrayList<RankedAlternative> countRegretCriteria(final ArrayList<Alternative> alternatives){
        List<Integer> maxValues = new ArrayList<>();
        List<Alternative> newAlternatives = new ArrayList<>(alternatives);
            for (int i = 0; i <alternatives.get(i).getScores().size() ; i++) {
                int max = 0;
                for (Alternative alternative : alternatives) {
                    int result = alternative.getScores().get(i);
                    if (result > max) {
                        max = result;
                    }
                }
                for (int j = 0; j <alternatives.size() ; j++) {
                    newAlternatives.get(j).getScores().set(i, max - alternatives.get(j).getScores().get(i));
                }
            }
        return countCriteriaAndRank(alternatives, Type.MAX, SortOrder.ASCENDING);
    }

    private static ArrayList<RankedAlternative> countCriteriaAndRank(final ArrayList<Alternative> alternatives, final Type type, final SortOrder sortOrder){

        ArrayList<CriteriaPerAlternative> criteriaList = new ArrayList<CriteriaPerAlternative>();
        int result;

        for (Alternative alternative : alternatives) {
            if (type == Type.MAX) {
                result = Collections.max(alternative.getScores());                     //find resulting score per Alternative
            } else {
                result = Collections.min(alternative.getScores());
            }
            criteriaList.add(new CriteriaPerAlternative(result, alternative));      //add resulting score and Alternative it belongs to to an Array
        }
        if (sortOrder == SortOrder.DESCENDING) {
            criteriaList.sort(Collections.reverseOrder());                     //sort alternatives by  score to get rank
        }
        else{
            Collections.sort(criteriaList);
        }

        ArrayList<RankedAlternative> rankedAlternatives = new ArrayList<>();
        for (int i = 0; i <criteriaList.size() ; i++) {
            RankedAlternative rankedAlternative =                                        //set rank = index in ordered criteriaList + 1)
                    new RankedAlternative(criteriaList.get(i).getAlternative(),criteriaList.get(i).getValue(), i + 1);
            rankedAlternatives.add(rankedAlternative);
        }

        return rankedAlternatives;
    }

    private enum Type{
        MAX, MIN
    }

}
