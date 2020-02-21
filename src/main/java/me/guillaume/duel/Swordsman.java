package me.guillaume.duel;

import java.util.Optional;

public class Swordsman {
    private int hitPoints;
    private String equipment;

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
        int axeStrike=0;
        int strikeNo=1;
        do{
            if(axeStrike==3)
                this.equip(null);

            //swordsman attacks viking
            swordsmanVsViking(viking, strikeNo);

            //viking attacks swordsman
            axeStrike = vikingVsSwordsman(axeStrike, strikeNo);
            strikeNo++;
        }while ((viking.hitPoints()>0)&&(hitPoints>0));

    }

    private int vikingVsSwordsman(int axeStrike, int strikeNo) {
        if(Optional.ofNullable(getEquipment()).isPresent()){
            if(strikeNo%2==0){
                this.setHitPoints(hitPoints-6);
            }
            else
            {
                axeStrike++;
            }
        }
        else
            this.setHitPoints(hitPoints-6);
        return axeStrike;
    }

    private void swordsmanVsViking(Viking viking, int strikeNo) {
        if(Optional.ofNullable(viking.getEquipment()).isPresent()){
            if(strikeNo%2==0){
               viking.setHitPoints(viking.hitPoints()-5);
            }
        }
        else
            viking.setHitPoints(viking.hitPoints()-5);
    }

    public void engage(Highlander highlander) {
    }

    public int hitPoints() {
        return hitPoints;
    }

    public Swordsman equip(String buckler) {
        this.equipment=buckler;
        return  this;
    }

    public String getEquipment() {
        return equipment;
    }

}
