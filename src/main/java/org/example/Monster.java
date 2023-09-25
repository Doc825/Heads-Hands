package org.example;

public class Monster extends FightingEntity {

    private Integer attack = 0;
    private Integer defence = 0;
    private Integer hp;
    private Integer maxDamage;
    private Integer minDamage;
    private boolean isAlive = true;

    public Monster(Integer hp, Integer minDamage, Integer maxDamage) {
        this.hp = hp;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        System.out.println("Monster created, hp = " + this.getHp());
    }

    @Override
    public Integer getAttack() {
        return attack;
    }

    @Override
    public void setAttack(Integer attack) {
        this.attack = attack;
    }


    @Override
    public Integer getDefence() {
        return defence;
    }

    @Override
    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    @Override
    public Integer getHp() {
        return hp;
    }

    @Override
    public void setHp(Integer hp) {
        this.hp = hp;
    }

    @Override
    public Integer getMinDamage() {
        return minDamage;
    }

    @Override
    public void setMinDamage(Integer minDamage) {
        this.minDamage = minDamage;
    }

    @Override
    public Integer getMaxDamage() {
        return maxDamage;
    }

    @Override
    public void setMaxDamage(Integer maxDamage) {
        this.maxDamage = maxDamage;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void setAlive() {
        isAlive = false;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "attack=" + attack +
                ", defence=" + defence +
                ", hp=" + hp +
                ", minDamage=" + minDamage +
                ", maxDamage=" + maxDamage +
                '}';
    }
}
