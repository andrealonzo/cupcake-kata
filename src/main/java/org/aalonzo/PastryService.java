package org.aalonzo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PastryService {

    public static final String WITH = "with";
    public static final String AND = "and";
    public String getName(Decorator pastry) {
        Stack<String> pastriesLevels = getPastryLevels(pastry);
        String name = generateName(pastriesLevels);
        return  name;

    }

    private String generateName(Stack<String> pastriesLevels) {
        String name = pastriesLevels.pop();
        if(!pastriesLevels.isEmpty()){
            name += " " + WITH + " " + pastriesLevels.pop();
        }
        while(!pastriesLevels.isEmpty()){
            name += " " + AND + " " + pastriesLevels.pop();
        }
        return name;
    }

    private Stack<String> getPastryLevels(Decorator pastry) {
        Stack <String>pastriesLevels = new Stack();
        while(pastry != null){
            pastriesLevels.add(pastry.toString());
            pastry = pastry.getInner();
        }
        return pastriesLevels;
    }
}
