package org.example;

public abstract class FightingEntity {

    private final int minValue = 1;
    private final int maxValue = 30;

    public static Integer doSomeRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public Boolean isSucceed(Integer attemptsLeft) {
        for (int i = 0; i < attemptsLeft; i++) {
            if (doSomeRandom(getMinDamage(), getMaxDamage()) > 4) {
                return true;
            }
        }
        return false;
    }

    public Integer getAttackModifier(FightingEntity entity) {
        int attackModifier = (getAttack() - entity.getDefence()) + 1;
        if (attackModifier < 1) {
            attackModifier = 1;
        }
        return attackModifier;
    }

    public Boolean couldBeHealed(FightingEntity entity) {
        return entity.getHp() > 0
                && entity.getHp() < 30
                && entity instanceof RegenerateAble
                && ((RegenerateAble) entity).getCountOfHealing() < 4;
    }

    public void doAttack(FightingEntity entity) {
        setAttack(doSomeRandom(minValue, maxValue));
        entity.setDefence(doSomeRandom(minValue, maxValue));
        if (isSucceed(getAttackModifier(entity))) {
            entity.setHp(entity.getHp() - doSomeRandom(getMinDamage(), getMaxDamage()));
            System.out.println(this + "has just attacked the " + entity + ", " + entity.getHp() + " hp left");
            if (couldBeHealed(entity)) {
                ((RegenerateAble) entity).healThePlayer((Player) entity);
            }
        }
        if (entity.getHp() < 0) {
            entity.setAlive();
            System.out.println(entity + " killed in action. " + '\n' + this + " wins the battle ");
        }
    }

    public static void doDeathFight(FightingEntity left, FightingEntity right) {
        while (left.isAlive() && right.isAlive()) {
            if (doSomeRandom(1, 100) > 50) {
                left.doAttack(right);
            } else {
                right.doAttack(left);
            }
        }
    }

    public abstract Integer getAttack();

    public abstract void setAttack(Integer attack);

    public abstract Integer getDefence();

    public abstract void setDefence(Integer defence);

    public abstract Integer getHp();

    public abstract void setHp(Integer hp);

    public abstract Integer getMinDamage();

    public abstract void setMinDamage(Integer minDamage);

    public abstract Integer getMaxDamage();

    public abstract void setMaxDamage(Integer maxDamage);

    public abstract boolean isAlive();

    public abstract void setAlive();


}
