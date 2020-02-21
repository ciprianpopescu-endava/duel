package me.guillaume.duel;

public class Viking {
    private int hitPoints;


    public void setHitPoints(int hitPoints) {
            this.hitPoints =Math.max(hitPoints, 0);
    }

    public Viking equip(String buckler) {
        return this;
    }


    public Viking () {
        this.setHitPoints(120);
    }

    public int hitPoints() {
        return hitPoints;
    }
}
