package rpg_lab;

import java.util.List;
import java.util.Random;

public interface Target {
    int giveExperience();

    boolean isDead();

    int getHealth();

    void takeAttack(int attackPoints);

    Weapon dropWeapon(Random random);
}
