package me.guillaume.duel;

public class Viking {
    private int hitPoints;
    private String equipment;


    public void setHitPoints(int hitPoints) {
            this.hitPoints =Math.max(hitPoints, 0);
    }

    public Viking () {
        this.setHitPoints(120);
    }

    public int hitPoints() {
        return hitPoints;
    }

    public Viking equip(String buckler) {
        this.equipment=buckler;
        return  this;
    }

    public String getEquipment() {
        return equipment;
    }

}
