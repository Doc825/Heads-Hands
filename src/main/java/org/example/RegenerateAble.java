package org.example;

public interface RegenerateAble {
    default void healThePlayer(Player player) {
        player.setHp((int) (player.getHp() + player.getExtraHealth()));
        player.setCountOfHealing(player.getCountOfHealing() + 1);
        System.out.println("2");
        System.out.println("Player: " + player + "just called regenerate() method. The player's hp now = " + player.getHp());
    }

    Integer getCountOfHealing();
}
