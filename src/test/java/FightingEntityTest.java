import org.example.Monster;
import org.example.Player;
import org.example.FightingEntity;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;


public class FightingEntityTest {
    private FightingEntity defaultPlayer = new Player(150, 6, 6);
    private FightingEntity defaultMonster = new Monster(150, 6, 6);
    private Player player = new Player(150, 6, 6);

    @Test
    public void testDoSomeRandom() {
        int result = FightingEntity.doSomeRandom(1, 10);
        assertThat(result, allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(10)));
    }

    @Test
    public void testIsSucceed_ReturnsTrue_WhenMinDamageHigherThan4() {
        FightingEntity player = new Player(150, 5, 5);
        boolean result = player.isSucceed(1);
        assertTrue(result);
    }

    @Test
    public void testIsSucceed_ReturnsFalse_WhenMinDamageEquals4() {
        FightingEntity player = new Player(150, 4, 4);
        boolean result = player.isSucceed(1);
        assertFalse(result);
    }

    @Test
    public void testIsSucceed_ReturnsFalse_WhenMinDamageLowerThan4() {
        FightingEntity player = new Player(150, 3, 3);
        boolean result = player.isSucceed(1);
        assertFalse(result);
    }

    @Test
    public void testIsSucceed_ReturnsFalse_WhenAttemptsLeftIs0() {
        FightingEntity fightingEntity = new Player(150, 10, 10);
        boolean result = fightingEntity.isSucceed(0);
        assertFalse(result);
    }

    @Test
    public void testGetAttackModifier() {
        assertTrue(defaultPlayer.getAttackModifier(defaultMonster) > 0);
    }

    @Test
    public void testGetAttackModifierNegativeResidual() {
        defaultPlayer.setAttack(15);
        defaultMonster.setDefence(20);
        assertEquals(1, (int) defaultPlayer.getAttackModifier(defaultMonster));
    }

    @Test
    public void testGetAttackModifierWhenResidualEqualsZero() {
        defaultPlayer.setAttack(20);
        defaultMonster.setDefence(20);
        assertEquals(1, (int) defaultPlayer.getAttackModifier(defaultMonster));
    }

    @Test
    public void testGetAttackModifierPositiveResidual() {
        defaultPlayer.setAttack(20);
        defaultMonster.setDefence(15);
        assertTrue(defaultPlayer.getAttackModifier(defaultMonster) > 1);
    }

    @Test
    public void testCouldBeHealedPositive() {
        defaultPlayer.setHp(29);
        assertEquals(true, defaultPlayer.couldBeHealed(defaultPlayer));
    }

    @Test
    public void testCouldBeHealedNegative() {
        defaultPlayer.setHp(30);
        assertEquals(false, defaultPlayer.couldBeHealed(defaultPlayer));
    }

    @Test
    public void testCouldBeHealed_NegativeIfAlreadyHealed4Times() {
        player.setHp(15);
        player.setCountOfHealing(4);
        assertEquals(false, defaultPlayer.couldBeHealed(defaultPlayer));
    }

    @Test
    public void testCouldBeHealed_PositiveIfHealedLessThan4Times() {
        player.setHp(15);
        player.setCountOfHealing(3);
        assertEquals(true, defaultPlayer.couldBeHealed(player));
    }

    @Test
    public void testCouldBeHealedReturnsFalseIfNotInstanceOfRegenerateAble() {
        defaultMonster.setHp(29);
        assertEquals(false, defaultPlayer.couldBeHealed(defaultMonster));
    }

    @Test
    public void testCouldBeHealedReturnsTrueIfInstanceOfRegenerateAble() {
        defaultPlayer.setHp(29);
        assertEquals(true, player.couldBeHealed(defaultPlayer));
    }

    @Test
    public void testDoAttackSetAttackSetDefenceWorksCorrect() {
        defaultPlayer.doAttack(defaultMonster);
        assertTrue(defaultPlayer.getAttack() > 0 && defaultPlayer.getAttack() < 30);
        assertTrue(defaultMonster.getDefence() > 0 && defaultMonster.getDefence() < 30);
    }

    @Test
    public void testDoAttackPlayerDiesWhenHPLessThan1() {
        defaultPlayer.setHp(0);
        defaultMonster.doAttack(defaultPlayer);
        assertFalse(defaultPlayer.isAlive());
    }

    @Test
    public void testDoAttackMonsterDiesWhenHPLessThan1() {
        defaultMonster.setHp(0);
        defaultPlayer.doAttack(defaultMonster);
        assertFalse(defaultMonster.isAlive());
    }

    @Test
    public void testHealThePlayer() {
        player.setHp(29);
        defaultMonster.doAttack(player);
        assertTrue(player.getCountOfHealing() > 0);
    }

    @Test
    public void testDoDeathFight() {
        defaultPlayer.setHp(500_000_000);
        FightingEntity.doDeathFight(defaultPlayer, defaultMonster);
        assertTrue(defaultPlayer.isAlive());
    }

}
