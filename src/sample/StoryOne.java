package sample;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.util.ArrayList;
import java.util.List;

public class StoryOne implements ICrossingStrategy {
    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        int i=0;
        for( i=0;i<boatRiders.size();i++){
            if(boatRiders.get(i).getEatingRank()==4)
                break;
        }
        if(boatRiders.size()>2 || i==boatRiders.size() || boatRiders.size()==0)
        return false;
        else {
            for (int j = 1; j < rightBankCrossers.size(); j++) {

                if (Math.abs(rightBankCrossers.get(0).getEatingRank() - (rightBankCrossers.get(j).getEatingRank())) == 1) {
                    return false;
                }
            }
            for (int j = 1; j < leftBankCrossers.size(); j++) {
                if (Math.abs(leftBankCrossers.get(0).getEatingRank() - (leftBankCrossers.get(j).getEatingRank())) == 1) {
                    return false;
                }
            }

        }

        return true;
    }


    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> initCrossers=new ArrayList<>();
        ICrosser farmer=new Farmer();
        ICrosser wolf=new Wolf();
        ICrosser goat=new Goat();
        ICrosser plant=new Plant();
        initCrossers.add(farmer);
        initCrossers.add(wolf);
        initCrossers.add(goat);
        initCrossers.add(plant);
        return initCrossers;
    }

    @Override
    public String[] getInstructions() {
String[] instructions={"Story one : \r\n A farmer wants to cross a river and takes with him a wolf,a goat and a cabbage.\r\n Rules: \r\n 1)" +
        " The farmer is the only one who can steer the raft.He can only take one passenger ( the wolf,the goat,or the cabbage" +
        "in addition to himself).\r\n 2) If the wolf and the goat are alone on the same riverbank ,the wolf will eat the goat. " +
        "\r\n 3) If the goat and the cabbage are alone on the same bank ,the goat will eat the cabbage.\r\n " +
        "How can the farmer get the wolf, the goat, and the cabbage across the river without any of them being eaten ?"};
        return instructions;
    }

}
