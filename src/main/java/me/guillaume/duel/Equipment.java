package me.guillaume.duel;

public enum Equipment {
    AXE("axe", 6),
    HANDSWORD("handsword", 5),
    BUCKLER("buckler", 3),
    GREATSWORD("greatsword", 12),
    ARMOR("armor", 0);

    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    Equipment(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
