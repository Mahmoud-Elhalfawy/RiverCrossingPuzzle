package sample;

import java.awt.image.BufferedImage;

public class Farmer extends Crosser implements ICrosser {
    public Farmer(double weight){
        setWeight(weight);
        setEatingRank(4);

    }
    public Farmer() {
        setEatingRank(4);
    }

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public BufferedImage[] getImages() {
        return new BufferedImage[0];
    }

    @Override
    public ICrosser makeCopy() {
        return null;
    }

    @Override
    public void setLabelToBeShown(String label) {

    }

    @Override
    public String getLabelToBeShown() {
        return null;
    }


}
