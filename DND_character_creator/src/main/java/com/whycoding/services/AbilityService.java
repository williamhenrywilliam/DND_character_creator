package com.whycoding.services;

import java.util.Arrays;

public class AbilityService {

    public int rollForAbilityScore(String ability){
        int abilityScore = 0;
        int[] rolls = new int[4];

        rolls[0] = (int)(Math.random() * 6) + 1;
        rolls[1] = (int)(Math.random() * 6) + 1;
        rolls[2] = (int)(Math.random() * 6) + 1;
        rolls[3] = (int)(Math.random() * 6) + 1;

        System.out.println("Dice roll 1: " + rolls[0]);
        System.out.println("Dice roll 2: " + rolls[1]);
        System.out.println("Dice roll 3: " + rolls[2]);
        System.out.println("Dice roll 4: " + rolls[3]);

        //find the lowest roll
        int lowestRoll = rolls[0];
        for(int i = 1; i < rolls.length; i++){
            if (rolls[i] < lowestRoll){
                lowestRoll = rolls[i];
            }
        }

        //sum all the rolls and substract the lowest roll
        for(int j = 0; j < rolls.length; j++){
            abilityScore += rolls[j];
        }
        abilityScore -= lowestRoll;

        System.out.println("Get rid of the lowest roll: " + lowestRoll);
        System.out.println("Sum the remaining rolls..." );
        System.out.println(ability + ": " + abilityScore);

        return abilityScore;
    }


} //end class
