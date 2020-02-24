package me.guillaume.duel;

public class Viking extends Warrior<Viking> {
    private int hitPoints = 120;

    public Viking() {
        equip(Equipment.AXE.getName());
        setDamage(Equipment.AXE.getValue());
        setHitPoints(hitPoints);
    }
}
