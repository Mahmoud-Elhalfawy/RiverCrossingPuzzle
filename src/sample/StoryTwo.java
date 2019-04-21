package sample;

import java.util.ArrayList;
import java.util.List;

public class StoryTwo implements ICrossingStrategy {
    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        double weight=0.0;
        int flag=0;
        int i;
        for(i=0;i<boatRiders.size();i++){
            if(boatRiders.get(i).getEatingRank()==4) {
                flag = 1;
            }
            weight+=boatRiders.get(i).getWeight();
        }
        if(boatRiders.size()==0 || boatRiders.size()>2  || weight>100 || flag==0)
            return false;
        else
        return true;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> initCrossers=new ArrayList<>();
        ICrosser farmer1=new Farmer(90);
        ICrosser farmer3=new Farmer(60);
        ICrosser sheep=new Sheep(20);
        ICrosser farmer2=new Farmer(80);
        ICrosser farmer4=new Farmer(40);
        initCrossers.add(farmer1);
        initCrossers.add(farmer2);
        initCrossers.add(farmer3);
        initCrossers.add(farmer4);
        initCrossers.add(sheep);
        return initCrossers;
    }

    @Override
    public String[] getInstructions() {
        String instructions[]={"Story two : \r\n Four farmers and their animal need to cross a river in a small raft.\r\n" +
                " First farmer weighs 90 kg, second weighs 80 kg,third weighs 60 kg,\r\nfourth weighs 40 kg,and their animal weighs 20 kg." +
                "\r\n Rules : \r\n The raft cannot bear a load heavier than 100 kg.\r\n" +
                "How can they all get to the other side with their animal ?"};
        return  instructions;
    }
}
