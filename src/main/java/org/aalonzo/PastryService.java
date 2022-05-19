package org.aalonzo;

import java.util.Stack;

public class PastryService {

    public static final String WITH = "with";
    public static final String AND = "and";
    public String getName(Pastry pastry) {
        Stack<String> pastriesLevels = getPastryLevels(pastry);
        return generateName(pastriesLevels);

    }

    private String generateName(Stack<String> pastriesLevels) {
        StringBuilder name = new StringBuilder(pastriesLevels.pop());
        if(!pastriesLevels.isEmpty()){
            name.append(" " + WITH + " ").append(pastriesLevels.pop());
        }
        while(!pastriesLevels.isEmpty()){
            name.append(" " + AND + " ").append(pastriesLevels.pop());
        }
        return name.toString();
    }

    private Stack<String> getPastryLevels(Pastry pastry) {
        Stack<String> pastriesLevels = new Stack<>();
        while(pastry != null){
            pastriesLevels.add(pastry.name());
            pastry = pastry.getWhatImTopping();
        }
        return pastriesLevels;
    }
}
