package me.guillaume.duel;

import java.util.ArrayList;
import java.util.List;

public class Swordsman implements Warrior {
    public static final int SWORDSMEN_DAMAGE = 5;
    public static final int VIKING_DAMAGE = 6;
    public static final String BUCKLER = "buckler";
    private static final String ARMOR = "armor";
    public static final int HIGHLANDER_DAMAGE = 12;
    private int hitPoints;
    private List<String> equipment;

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
        this.equipment = new ArrayList<>();

    }

    public void engage(Viking viking) {
        int axeStrike = 0;
        int strikeNo = 0;
        do {
            if (axeStrike == 3)
                this.equipment.remove(BUCKLER);

            //swordsman attacks viking
            swordsmanWithBucklerVsWarrior(viking, strikeNo, SWORDSMEN_DAMAGE);

            //viking attacks swordsman
            axeStrike = vikingVsSwordsman(axeStrike, strikeNo);
            strikeNo++;
        } while ((viking.hitPoints() > 0) && (hitPoints > 0));

    }

    private int vikingVsSwordsman(int axeStrike, int strikeNo) {
        if (this.getEquipment().contains(BUCKLER)) {
            if (strikeNo % 2 == 0) {
                this.setHitPoints(hitPoints - VIKING_DAMAGE);
            } else {
                axeStrike++;
            }
        } else
            this.setHitPoints(hitPoints - VIKING_DAMAGE);
        return axeStrike;
    }

    private void swordsmanWithBucklerVsWarrior(Warrior warrior, int strikeNo, int damage) {
        if (warrior.getEquipment().contains(BUCKLER)) {
            if (strikeNo % 2 == 0) {
                warrior.setHitPoints(warrior.hitPoints() - damage);
            }
        } else
            warrior.setHitPoints(warrior.hitPoints() - damage);
    }

    public int hitPoints() {
        return hitPoints;
    }

    public Swordsman equip(String equipment) {
        this.getEquipment().add(equipment);
        return this;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public void engage(Highlander highlander) {
        int strikeNo = 0;
        boolean greatSwordDamage = false;
        do {
            if ((strikeNo + 1) % 3 != 0) {
                greatSwordDamage = true;
            }
            if (getEquipment().contains(BUCKLER)) {
                if (strikeNo % 2 == 0) {
                    if (greatSwordDamage) {
                        if (getEquipment().contains(ARMOR)) {
                            highlander.setHitPoints(highlander.getHitPoints() - SWORDSMEN_DAMAGE + 1);
                            setHitPoints(hitPoints - HIGHLANDER_DAMAGE + 3);
                        } else {
                            highlander.setHitPoints(highlander.getHitPoints() - SWORDSMEN_DAMAGE);
                            setHitPoints(hitPoints - HIGHLANDER_DAMAGE);
                        }
                    } else {
                        highlander.setHitPoints(highlander.getHitPoints() - SWORDSMEN_DAMAGE);
                    }
                } else {
                    setHitPoints(hitPoints - HIGHLANDER_DAMAGE);
                }
            }
            strikeNo++;
        }
        while ((highlander.hitPoints() > 0) && (hitPoints > 0));
    }
}
