package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class HeroTests {
    private static final int Hero_XP_Gain_When_Target_Dead = 10;


    @Test
    public void testGainingXPWhenTargetDied(){
        Target fakeTarget = new Target() {
            @Override
            public int giveExperience() {
                return Hero_XP_Gain_When_Target_Dead;
            }

            @Override
            public boolean isDead() {
                return true;
            }

            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }
        };

        Weapon fakeWeapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return 0;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }

            @Override
            public void attack(Target target) {
            }
        };


    }
}
