package core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class AlternativeController {


    @GetMapping("/")
    public RankedAlternativeCase index() {
        Alternative a1 = new Alternative(1,"alternative1", new ArrayList<Integer>(Arrays.asList(12,3,4,4)));
        Alternative a2 = new Alternative(2,"alternative2", new ArrayList<Integer>(Arrays.asList(12,2,1,0)));
        Alternative a3 = new Alternative(3,"alternative3", new ArrayList<Integer>(Arrays.asList(8,1,1,5)));
        Alternative a4 = new Alternative(4,"alternative4", new ArrayList<Integer>(Arrays.asList(7,7,7,5)));
        ArrayList<Alternative> alternatives = new ArrayList<>(Arrays.asList(a1,a2,a3,a4));
        ArrayList<RankedAlternative> rankedAlternatives = AlternativeModel.countValdCriteria(alternatives);
        RankedAlternativeCase rankedAlternativeCase = new RankedAlternativeCase(rankedAlternatives, new ArrayList<String>(Arrays.asList("score1","score2","score3","score4")),0);

        return rankedAlternativeCase;

//        return "<p>Available Commands:</p>" +
//                "<p>findAllBooks <a href=\"/test/\">here</a></p>";

    }

}
