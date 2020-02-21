package me.guillaume.duel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Highlander implements Warrior {

    private int hitPoints;
    private List<String> equipment;

    public Highlander(String veteran) {
    }

    public Highlander() {
            this.setHitPoints(150);
            this.equipment=new ArrayList<>();
    }



    public int getHitPoints() {
        return hitPoints;
    }


    @Override
    public List<String> getEquipment() {
        return Collections.emptyList();
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = Math.max(hitPoints, 0);
    }


    public int hitPoints() {
        return hitPoints;
    }
}
