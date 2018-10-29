package core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;


@RestController
public class AlternativeController {


    @GetMapping("/")
    public RankedAlternativeCase index() {
        Alternative a1 = new Alternative(1,"alternative1", new ArrayList<>(Arrays.asList(12,3,4,4)));
        Alternative a2 = new Alternative(2,"alternative2", new ArrayList<>(Arrays.asList(12,2,1,0)));
        Alternative a3 = new Alternative(3,"alternative3", new ArrayList<>(Arrays.asList(8,1,1,5)));
        Alternative a4 = new Alternative(4,"alternative4", new ArrayList<>(Arrays.asList(7,7,7,5)));
        ArrayList<Alternative> alternatives = new ArrayList<>(Arrays.asList(a1,a2,a3,a4));
        ArrayList<RankedAlternative> rankedAlternatives = AlternativeService.countValdCriteria(alternatives);
        RankedAlternativeCase rankedAlternativeCase = new RankedAlternativeCase(rankedAlternatives, new ArrayList<String>(Arrays.asList("score1","score2","score3","score4")),0);

        return rankedAlternativeCase;

//        return "<p>Available Commands:</p>" +
//                "<p>findAllBooks <a href=\"/test/\">here</a></p>";

    }

    @GetMapping("/rank")
    public RankedAlternativeCase getRankedAlternative(@RequestBody AlternativeCase alternativeCase)
    {
        ArrayList <RankedAlternative> rankedAlternativeList;
        switch (alternativeCase.getCriteriaType()){
            case 1:
                rankedAlternativeList = AlternativeService.countValdCriteria(alternativeCase.getAlternatives());
                break;
            case 2:
                rankedAlternativeList = AlternativeService.countValdCriteria(alternativeCase.getAlternatives());
                break;
            case 3:
                rankedAlternativeList = AlternativeService.countValdCriteria(alternativeCase.getAlternatives());
                break;
            case 4:
                rankedAlternativeList = AlternativeService.countValdCriteria(alternativeCase.getAlternatives());
                break;
            case 5:
                rankedAlternativeList = AlternativeService.countValdCriteria(alternativeCase.getAlternatives());
                break;
                default:
                    rankedAlternativeList =  AlternativeService.countValdCriteria(alternativeCase.getAlternatives());
                    break;
        }
        return new RankedAlternativeCase(rankedAlternativeList,
                alternativeCase.getConditions(),
                alternativeCase.getCriteriaType());


    }

}
