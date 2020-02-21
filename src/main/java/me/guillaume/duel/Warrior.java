package me.guillaume.duel;

import java.util.List;

public interface Warrior {
    List<String> getEquipment();
    void setHitPoints(int hitPoints);
    int hitPoints();
}
