package sample;

import java.awt.image.BufferedImage;

public abstract class Carnivorous extends  Crosser implements ICrosser {
    public Carnivorous() {
        setEatingRank(2);
    }
}
