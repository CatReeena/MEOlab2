package core;

import java.util.ArrayList;
import java.util.Collections;

public class AlternativeModel {

    //ranking Alternatives by Vald criteria

    public static ArrayList<RankedAlternative> countValdCriteria(final ArrayList<Alternative> alternatives){

        ArrayList<CriteriaPerAlternative> criteriaList = new ArrayList<CriteriaPerAlternative>();
        int min;

        for (int i = 0; i <alternatives.size() ; i++) {
            min = Collections.min(alternatives.get(i).getScores());                     //find min score per Alternative
            criteriaList.add(new CriteriaPerAlternative(min, alternatives.get(i)));      //add min score and Alternative it belongs to to an Array
        }
        Collections.sort(criteriaList, Collections.reverseOrder());                     //sort alternatives by min score to get rank

        ArrayList<RankedAlternative> rankedAlternatives = new ArrayList<>();
        for (int i = 0; i <criteriaList.size() ; i++) {
            RankedAlternative rankedAlternative =                                        //set rank = index in ordered criteriaList + 1)
                    new RankedAlternative(criteriaList.get(i).getAlternative(),criteriaList.get(i).getValue(), i + 1);
            rankedAlternatives.add(rankedAlternative);
        }

        return rankedAlternatives;
    }
}
