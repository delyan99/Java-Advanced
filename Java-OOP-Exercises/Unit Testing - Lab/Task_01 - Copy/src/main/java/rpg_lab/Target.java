package rpg_lab;

public interface Target {
    int giveExperience();

    boolean isDead();

    int getHealth();

    void takeAttack(int attackPoints);
}
