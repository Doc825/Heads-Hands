package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FightManager {
    public void startTheFight() {
        FightingEntity player = new Player(0, 0, 0);
        FightingEntity monster = new Monster(0, 0, 0);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            FightingEntity.doDeathFight(createEntity(reader, player), createEntity(reader, monster));
        } catch (Exception ex) {
            System.out.println("There is exception occurred by ");
            ex.printStackTrace();
        }

    }

    public static FightingEntity createEntity(BufferedReader reader, FightingEntity entity) {
        int value;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter hp for character:");
                value = Integer.parseInt(reader.readLine());
                entity.setHp(value);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            } catch (IOException e) {
                System.out.println("An error occurred while reading input.");
                e.printStackTrace();
            }
        }
        validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter min damage for character: ");
                value = Integer.parseInt(reader.readLine());
                entity.setMinDamage(value);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Min damage for character could be number only and must be bigger than 0");
            } catch (IOException e) {
                System.out.println("An error occurred while reading input. ");
                e.printStackTrace();
            }
        }
        validInput = false;

        while (!validInput) {
            try {
                System.out.println("enter max damage for character");
                value = Integer.parseInt(reader.readLine());
                if (entity.getMinDamage() > value) {
                    throw new NumberFormatException();
                }
                entity.setMaxDamage(value);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("max damage for character could be number only and must be bigger than min damage");
            } catch (IOException e) {
                System.out.println("An error occurred while reading input.");
                e.printStackTrace();
            }
        }
        System.out.println("Entity created: " + entity);
        return entity;
    }
}

