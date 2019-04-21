package sample;

import java.awt.image.BufferedImage;

public class Sheep extends Herbivorous implements ICrosser {
    public Sheep(double weight){
        setWeight(weight);
        setEatingRank(super.getEatingRank());
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
