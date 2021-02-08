package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.Assert.*;

public class AxeTests {
    private static final int Axe_Attack = 10;
    private static final int Axe_Durability = 10;
    private static final int Dummy_Health = 10;
    private static final int Dummy_Experience = 10;
    private static final int Dummy_Attack_Points = 1;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp(){
        this.axe = new Axe(Axe_Attack, Axe_Durability);
        this.dummy = new Dummy(Dummy_Health, Dummy_Experience);
    }

    @Test
    public void weaponAttackLosesDurability(){
        axe.attack(dummy);
        assertEquals(Axe_Durability - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void attackWithBrokenWeapon(){
        Axe axe = new Axe(Axe_Attack, 0);
        axe.attack(dummy);
    }

    @Test
    public void dummyLosesHealthWhenAttacked(){
        dummy.takeAttack(Dummy_Attack_Points);
        assertEquals(Dummy_Health - Dummy_Attack_Points, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionWhenAttacked(){
        Dummy dummy = new Dummy(0, Dummy_Experience);
        dummy.takeAttack(Dummy_Attack_Points);
    }

    @Test
    public void deadDummyCanGiveXP(){
        Dummy dummy = new Dummy(0, Dummy_Experience);
        assertEquals(Dummy_Experience, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyCantGiveXP(){
        dummy.giveExperience();
    }
}
