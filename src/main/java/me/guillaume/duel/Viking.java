package me.guillaume.duel;

import java.util.ArrayList;
import java.util.List;

public class Viking implements Warrior {
    private int hitPoints;
    private List<String> equipment;


    public void setHitPoints(int hitPoints) {
            this.hitPoints =Math.max(hitPoints, 0);
    }

    public Viking () {
        this.setHitPoints(120);
        this.equipment=new ArrayList<>();

    }

    public int hitPoints() {
        return hitPoints;
    }

    public Viking equip(String equipment) {
        this.getEquipment().add(equipment);
        return  this;
    }

    public List<String> getEquipment() {
        return equipment;
    }

}
