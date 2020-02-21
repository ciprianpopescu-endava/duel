package me.guillaume.duel;

public class Swordsman {
    private int hitPoints;

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
            this.hitPoints = Math.max(hitPoints, 0);
    }



    public Swordsman(String vicious) {
    }

    public Swordsman() {
        this.setHitPoints(100);

    }

    public void engage(Viking viking) {
        do{
            viking.setHitPoints(viking.hitPoints()-5);
            this.setHitPoints(hitPoints-6);
        }while ((viking.hitPoints()>0)&&(hitPoints>0));

    }

    public void engage(Highlander highlander) {
    }

    public int hitPoints() {
        return hitPoints;
    }

    public Swordsman equip(String buckler) {
    return this;

    }
}
