package core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@CrossOrigin
@RestController
public class AlternativeController {


//    @GetMapping("/")
//    public AlternativeCase index() {
//        Alternative a1 = new Alternative(1,"alternative1", new ArrayList<Double>(Arrays.asList(12.0, 3.0, 4.0)));
//        Alternative a2 = new Alternative(2,"alternative2", new ArrayList<Double>(Arrays.asList(9.0, 2.0, 0.0)));
//        Alternative a3 = new Alternative(3,"alternative3", new ArrayList<Double>(Arrays.asList(6.0, 8.0, 7.0)));
//        Alternative a4 = new Alternative(4,"alternative4", new ArrayList<Double>(Arrays.asList(6.0, 6.0, 4.0)));
//        ArrayList<Alternative> alternatives = new ArrayList<>(Arrays.asList(a1,a2,a3,a4));
//        AlternativeCase alternativeCase = new AlternativeCase();
//        alternativeCase.setAlternatives(alternatives);
//        alternativeCase.setCriteriaType(1);
//        alternativeCase.setConditions(new ArrayList<String>(Arrays.asList("c1","c2","c3","c4")));
////        ArrayList<RankedAlternative> rankedAlternatives1 = AlternativeService.countValdCriteria(alternatives);
////        ArrayList<RankedAlternative> rankedAlternatives2 = AlternativeService.countMaxMaxCriteria(alternatives);
////        ArrayList<RankedAlternative> rankedAlternatives3 = AlternativeService.countGurwitzCriteria(alternatives);
////        ArrayList<RankedAlternative> rankedAlternatives4 = AlternativeService.countRegretCriteria(alternatives);
////        ArrayList<RankedAlternative> rankedAlternative5 = AlternativeService.countLaplasCriteria(alternatives);
////        RankedAlternativeCase rankedAlternativeCase = new RankedAlternativeCase(rankedAlternatives1, new ArrayList<String>(Arrays.asList("score1","score2","score3","score4")),0);
////        Collections.sort(rankedAlternatives1);
////        return rankedAlternativeCase;
//        return alternativeCase;
//    }

    @PostMapping("/rank")
    public RankedAlternativeCase getRankedAlternative(@RequestBody AlternativeCase alternativeCase)
    {
        ArrayList <RankedAlternative> rankedAlternativeList;
        switch (alternativeCase.getCriteriaType()){
            case 1:
                rankedAlternativeList = AlternativeService.countValdCriteria(alternativeCase.getAlternatives());
                break;
            case 2:
                rankedAlternativeList = AlternativeService.countMaxMaxCriteria(alternativeCase.getAlternatives());
                break;
            case 3:
                rankedAlternativeList = AlternativeService.countGurwitzCriteria(alternativeCase.getAlternatives());
                break;
            case 4:
                rankedAlternativeList = AlternativeService.countRegretCriteria(alternativeCase.getAlternatives());
                break;
            case 5:
                rankedAlternativeList = AlternativeService.countLaplasCriteria(alternativeCase.getAlternatives());
                break;
                default:
                    rankedAlternativeList =  AlternativeService.countValdCriteria(alternativeCase.getAlternatives());
                    break;
        }
        Collections.sort(rankedAlternativeList);
        return new RankedAlternativeCase(rankedAlternativeList,
                alternativeCase.getConditions(),
                alternativeCase.getCriteriaType());


    }

}
