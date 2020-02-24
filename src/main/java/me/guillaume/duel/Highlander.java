package me.guillaume.duel;

public class Highlander extends Warrior<Highlander> {

    public boolean isBerserk() {
        return isBerserk;
    }

    private boolean isBerserk;

    public int getInitialHP() {
        return initialHP;
    }

    private int initialHP = 150;

    public Highlander(String veteran) {
        this();
        if (veteran.equals("Veteran")) {
            this.isBerserk = true;
        }
    }

    public Highlander() {
        this.equip(Equipment.GREATSWORD.getName());
        this.setHitPoints(initialHP);
        this.setDamage(Equipment.GREATSWORD.getValue());
    }


}
