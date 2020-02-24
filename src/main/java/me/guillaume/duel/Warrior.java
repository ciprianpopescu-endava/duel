package me.guillaume.duel;

import java.util.HashMap;
import java.util.Map;

import static me.guillaume.duel.Equipment.*;

public class Warrior<T extends Warrior<T>> {

    private int hitPoints;
    Map<String, Integer> equipment = new HashMap<>();
    private int damage;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public T equip(String equip) {
        for (Equipment value : Equipment.values()) {
            if (value.getName().equals(equip)) {
                getEquipment().put(equip, value.getValue());
            }
        }
        return (T) this;
    }

    public Map<String, Integer> getEquipment() {
        return equipment;
    }

    public int hitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = Math.max(hitPoints, 0);
    }

    public void engage(Warrior warrior) {
        int strikeNo = 0;
        checkArmour(this, warrior);
        checkArmour(warrior, this);
        do {
            attack(this, warrior, strikeNo);
            attack(warrior, this, strikeNo);
            strikeNo++;
        } while ((warrior.hitPoints() > 0) && (this.hitPoints() > 0));
    }

    private void checkArmour(Warrior<T> first, Warrior<T> second) {
        if (first.getEquipment().containsKey(ARMOR.getName())) {
            second.setDamage(second.getDamage() - 3);
            first.setDamage(first.getDamage() - 1);
        }
    }

    protected void attack(Warrior<T> first, Warrior<T> second, int strikeNo) {
        if (first instanceof Swordsman) {
            checkSwordsmanIsVicious(first, second, strikeNo);
        }
        if (first instanceof Highlander) {
            checkVeteranHighlander(first, second, strikeNo);
        }
        if (first.getEquipment().containsKey(GREATSWORD.getName())) {
            if (strikeNo % 3 != 0) {
                checkBuckler(first, second, strikeNo);
            }
        } else {
            checkBuckler(first, second, strikeNo);
        }


    }

    private void checkVeteranHighlander(Warrior first, Warrior<T> second, int strikeNo) {
        Highlander highlander = (Highlander) first;
        int initialHP = highlander.getInitialHP();
        if (highlander.isBerserk()) {
            highlanderBersek(second, strikeNo, highlander, initialHP);
        }
    }

    private void highlanderBersek(Warrior<T> second, int strikeNo, Highlander highlander, int initialHP) {
        if (highlander.hitPoints() < initialHP * 0.3) {
            if (second.getEquipment().containsKey(ARMOR)) {
                second.setDamage(second.getDamage() - 3);
                highlander.setDamage(Equipment.GREATSWORD.getValue() * 2 - 1);
            } else {
                highlander.setDamage(Equipment.GREATSWORD.getValue() * 2);
            }
            checkBuckler((Warrior<T>) highlander, second, strikeNo);
        }
    }

    private void checkSwordsmanIsVicious(Warrior<T> first, Warrior<T> second, int strikeNo) {
        Swordsman swordsman = (Swordsman) first;
        if (swordsman.isVicious() && (strikeNo == 0 || strikeNo == 1)) {
            second.setHitPoints(second.hitPoints() - first.getDamage() - 20);
        }
    }

    private void checkBuckler(Warrior<T> first, Warrior<T> second, int strikeNo) {
        if (second.getEquipment().containsKey(BUCKLER.getName())) {
            attackWithBuckler(first, second, strikeNo);
        } else
            second.setHitPoints(second.hitPoints() - first.getDamage());
    }

    private void attackWithBuckler(Warrior<T> first, Warrior<T> second, int strikeNo) {
        if (strikeNo % 2 == 0) {
            second.setHitPoints(second.hitPoints() - first.getDamage());
            if (first.getEquipment().containsKey(AXE.getName())) {
                second.getEquipment().put(BUCKLER.getName(), second.getEquipment().get(BUCKLER.getName()) - 1);
                if (second.getEquipment().get(BUCKLER.getName()) == 0) {
                    second.getEquipment().remove(BUCKLER.getName());
                }
            }
        }
    }

}
