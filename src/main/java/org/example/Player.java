package org.example;

public class Player extends FightingEntity implements RegenerateAble {

    private Integer attack = 0;
    private Integer defence = 0;
    private Integer hp;
    private Integer minDamage;
    private Integer maxDamage;
    private boolean isAlive = true;
    private Integer countOfHealing = 0;
    private final Double extraHealth;

    public Player(Integer hp, Integer minDamage, Integer maxDamage) {
        this.hp = hp;
        this.extraHealth = (hp / 100.0) * 30;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        System.out.println("Player created, hp =  " + this.getHp());
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
    public Integer getCountOfHealing() {
        return countOfHealing;
    }

    public void setCountOfHealing(Integer countOfHealing) {
        this.countOfHealing = countOfHealing;
    }


    public Double getExtraHealth() {
        return extraHealth;
    }

    @Override
    public String toString() {
        return "Player{" +
                "attack=" + attack +
                ", defence=" + defence +
                ", hp=" + hp +
                ", minDamage=" + minDamage +
                ", maxDamage=" + maxDamage +
                '}';
    }
}
