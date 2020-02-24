package me.guillaume.duel;

public class Swordsman extends Warrior<Swordsman> {
    int hitPoints = 100;

    private boolean isVicious = false;

    public boolean isVicious() {
        return isVicious;
    }


    public Swordsman(String vicious) {
        this();
        this.getEquipment().remove(Equipment.HANDSWORD.getName());
        if (vicious.equals("Vicious")) {
            this.isVicious = true;
        }
    }

    public Swordsman() {
        equip(Equipment.HANDSWORD.getName());
        setHitPoints(hitPoints);
        setDamage(Equipment.HANDSWORD.getValue());
    }

}
