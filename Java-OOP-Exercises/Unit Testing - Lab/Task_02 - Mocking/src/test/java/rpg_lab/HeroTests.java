package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

public class HeroTests {
    private static final int Hero_XP_Gain_When_Target_Dead = 10;
    private static final int Weapon_Attack_Points = 10;

//    @Test
//    public void testGainingXPWhenTargetDied() {
//        Target fakeTarget = Mockito.mock(Target.class);
//        Weapon fakeWeapon = Mockito.mock(Weapon.class);
//
//        Mockito.when(fakeTarget.isDead()).thenReturn(true);
//        Mockito.when(fakeTarget.giveExperience()).thenReturn(Hero_XP_Gain_When_Target_Dead);
//
//        Hero hero = new Hero("Hero_Name", fakeWeapon);
//        hero.attack(fakeTarget);
//        assertEquals(Hero_XP_Gain_When_Target_Dead, hero.getExperience());
//    }

    @Test
    public void testGivingCorrectRandomWeaponWhenTargetDeed(){
        Weapon weapon = Mockito.mock(Weapon.class);
        Hero hero = new Hero("Hero_Name", weapon);
        Target target = Mockito.mock(Target.class);
        Mockito.when(target.isDead()).thenReturn(true);
        Random random = Mockito.mock(Random.class);
        Weapon weapon1 = Mockito.mock(Weapon.class);
        Mockito.when(weapon1.getAttackPoints()).thenReturn(Weapon_Attack_Points);
        Mockito.when(target.dropWeapon(any())).thenReturn(weapon1);
        Weapon w = hero.attack(target, random);
        Assert.assertEquals(Weapon_Attack_Points, w.getAttackPoints());
    }


}
