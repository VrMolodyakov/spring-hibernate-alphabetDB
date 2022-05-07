package com.example.HiberTest.Statistics;

import com.example.HiberTest.Entities.strStat;
import com.example.HiberTest.Repositories.strStatRepoImpl;
import com.example.HiberTest.Repositories.subStrRepoImpl;
import com.example.HiberTest.Text.TextParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class statRecorder {

    @Autowired
    subStrRepoImpl subStrRepo;

    @Autowired
    strStatRepoImpl strStatRepo;

    @Autowired
    characterStats stat;


    public void recordAllSubstring(){
        stat.getTextForStatistics();
        stat.getStatistics();
       // List<String> result = stat.getValuableSubStr();
       // subStrRepo.addSubStringFromText(result);
    }

    public void recordTextStatistics(Integer textId){
        recordAllSubstring();

        Map<String,Integer> map = stat.getSubStringsStatistics();
        Map<String,Integer> sortedMap = map.entrySet().stream()
                                                      .sorted((e1,e2) -> Integer.compare(e1.getKey().length(),e2.getKey().length()))
                                                      .collect(Collectors.toMap(Map.Entry::getKey,
                                                                                Map.Entry::getValue,
                                                                                (e1, e2) -> e1, LinkedHashMap::new));
        int oneOrTwoChar = 0,threeChar = 0;
        for(Map.Entry<String,Integer> me : sortedMap.entrySet()){
            if(me.getKey().length() <3)
                ++oneOrTwoChar;
            else if(me.getKey().length() == 3)
                ++threeChar;
        }

        Integer length = stat.getLength();
        int resultSize = oneOrTwoChar + (threeChar*5)/100;
        /*sortedMap.entrySet().stream()
                            .limit(resultSize)
                            .forEach( e -> strStatRepo.save(
                                                            new strStat(
                                                                    textId,
                                                                    subStrRepo.findByValue(e.getKey()).getId(),
                                                                    e.getValue(),
                                                           1+length - e.getKey().length()
                                                            )));*/

        int loopCounter =0;
        for(Map.Entry<String,Integer> me : sortedMap.entrySet()){

            Integer strId = subStrRepo.findByValue(me.getKey()).getId();
            Integer count = me.getValue();
            Integer possiblyCount = 1 + length - me.getKey().length();
           // strStatRepo.save( new strStat(textId,strId,count,possiblyCount));

            if(loopCounter<resultSize)
                ++loopCounter;
            else
                break;
        }

        //subStrRepo.addSubStringFromText();
    }
}
