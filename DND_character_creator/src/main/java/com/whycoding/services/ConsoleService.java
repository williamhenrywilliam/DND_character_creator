package com.whycoding.services;

import com.whycoding.model.DNDClass;
import com.whycoding.model.DNDResource;
import com.whycoding.model.PlayerCharacter;

import java.io.FileWriter;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;


public class ConsoleService {

    private final DNDClassService dndClassService = new DNDClassService();
    private final AbilityService abilityService = new AbilityService();
    private final Scanner scanner = new Scanner(System.in);
    private final String DIRECTORY_NAME = "C:\\Users\\William\\Coding_Projects\\DND_character_creator";

    PlayerCharacter userCharacter = new PlayerCharacter();

    public void printMainMenu(){
        System.out.println("---------Main Menu---------");
        System.out.println("1: Begin Character Creation");
        System.out.println("2: Learn More About the Process");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void handleCharacterCreationMenu(){
        int menuSelection = -1;

        while(menuSelection != 0){
            printCharacterCreationMenu();
            menuSelection = promptForMenuSelection();
            switch(menuSelection){
                case 0:
                    continue;
                case 1:
                    handleClassSelectionMenu();
                    break;
                case 2:
                    handleRaceSelectionMenu();
                    break;
                case 3:
                    //TODO
                    System.out.println("-------------------------");
                    System.out.println("Name Selection");
                    System.out.println("-------------------------");
                    System.out.println("Please enter your character's name:");
                    String characterName = scanner.nextLine();
                    System.out.println(characterName + "? Great choice!");
                    userCharacter.setCharacterName(characterName);
                    break;
                case 4:
                    handleAbilityScoreMenu();
                    break;
                case 5:
                    System.out.println("-------------------------");
                    System.out.println("DND Classes");
                    System.out.println("-------------------------");
                    printResource(dndClassService.getClassesResource());
                    break;
                case 6:
                    System.out.println("---------------");
                    System.out.println("DND Races");
                    System.out.println("---------------");
                    printResource(dndClassService.getRacesResource());
                    break;
                case 7:
                    if(userCharacter.getCharacterName() == null){
                        System.out.println("Make sure you give your character a name first!");
                    } else {
                        createCharacterSheet(userCharacter.getCharacterName());
                        System.out.println("Congrats! Your character is now complete. Please exit the program to view your character sheet file.");
                        System.out.println();
                        menuSelection = 0;
                    }
                    break;
                default:
                    System.out.println("Invalid selection");;
            }
        }
    }

    public void printCharacterCreationMenu(){
        System.out.println();
        System.out.println("---------Character Creation Menu---------");
        System.out.println("1: Choose Class");
        System.out.println("2: Chose Race");
        System.out.println("3: Choose Name");
        System.out.println("4: Roll for Ability Scores");
        System.out.println("5: See Classes");
        System.out.println("6: See Races");
        System.out.println("7: Finish Character");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void handleClassSelectionMenu(){
        int menuSelection = -1;
        DNDResource classesResource = dndClassService.getClassesResource();

        while(menuSelection != 0){
            printClassSelectionMenu();
            menuSelection = promptForMenuSelection();

            if(menuSelection == 0) {
                continue;
            } else if (menuSelection > classesResource.getCount()){
                System.out.println("Invalid selection, please choose again");
            } else {
                userCharacter.setDndClass(dndClassService.getClassByIndex(classesResource.getResults()[menuSelection-1].get("index")));
                System.out.println(userCharacter.getDndClass().toString());
                break;
            }
        }
    }

    public void handleRaceSelectionMenu(){
        int menuSelection = -1;
        DNDResource racesResource = dndClassService.getRacesResource();

        while(menuSelection != 0){
            printRaceSelectionMenu();
            menuSelection = promptForMenuSelection();

            if(menuSelection == 0) {
                continue;
            } else if (menuSelection > racesResource.getCount()){
                System.out.println("Invalid selection, please choose again");
            } else {
                userCharacter.setDndRace(dndClassService.getRaceByIndex(racesResource.getResults()[menuSelection-1].get("index")));
                System.out.println(userCharacter.getDndRace().toString());
                break;
            }
        }
    }

    public void handleAbilityScoreMenu(){
        int menuSelection = -1;

        while(menuSelection != 0){
            printAbilityScoresMenu();
            menuSelection = promptForMenuSelection();
            switch(menuSelection){
                case 0:
                    continue;
                case 1:
                    userCharacter.setStrengthScore(abilityService.rollForAbilityScore("Strength"));
                    break;
                case 2:
                    userCharacter.setDexterityScore(abilityService.rollForAbilityScore("Dexterity"));
                    break;
                case 3:
                    userCharacter.setConstitutionScore(abilityService.rollForAbilityScore("Constitution"));
                    break;
                case 4:
                    userCharacter.setIntelligenceScore(abilityService.rollForAbilityScore("Intelligence"));
                    break;
                case 5:
                    userCharacter.setWisdomScore(abilityService.rollForAbilityScore("Wisdom"));
                    break;
                case 6:
                    userCharacter.setCharismaScore(abilityService.rollForAbilityScore("Charisma"));
                    break;
                default:
                    System.out.println("Invalid Selection");
                    break;
            }
        }
    }

    public void printClassSelectionMenu(){
        System.out.println();
        System.out.println("---------Classes---------");
        printResource(dndClassService.getClassesResource());
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printRaceSelectionMenu(){
        System.out.println();
        System.out.println("---------Races---------");
        printResource(dndClassService.getRacesResource());
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printAbilityScoresMenu(){
        System.out.println();
        System.out.println("---------Abilities---------");
        System.out.println("1: Strength");
        System.out.println("2: Dexterity");
        System.out.println("3: Constitution");
        System.out.println("4: Intelligence");
        System.out.println("5: Wisdom");
        System.out.println("6: Charisma");
        System.out.println("0: Exit");
        System.out.println();
    }

    public int promptForMenuSelection() {
        int menuSelection;
        System.out.print("Please choose an option: ");
        try{
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e){
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void pause(){
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printLearnMoreInfo(){
        System.out.println("-------------------------");
        System.out.println("DND Classes");
        System.out.println("-------------------------");
        System.out.println("This program will guide you step by step in the character creation process for 5th edition character creation.");
        System.out.println("You will make exciting decisions about your character as you bring your idea to life.");
        System.out.println("What fantasy race will they belong to?");
        System.out.println("What class will they have?");
        System.out.println("Where does this character come from and what is their motivation to take up adventuring?!");
        System.out.println("All of this and more will be answered by you. By the end of the process, you will have a fully fleshed out PC ready to take to the table");
        System.out.println("There is no time to waste. Return to the main menu and get to it, adventurer! And remember, it's dangerous to go alone...");
        System.out.println();
    }

    public void printResource(DNDResource dndResource){
        Map<String, String>[] resource = dndResource.getResults();

        for(int i = 0; i < resource.length; i++){
            System.out.print(i + 1);
            System.out.print(": ");
            System.out.println(resource[i].get("name"));
        }
    }

    //TODO add file writer
    public void createCharacterSheet(String fileName){
        String filePath = "\\" + fileName +".txt";
        File characterSheet = new File(DIRECTORY_NAME, filePath);

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(characterSheet));
            writer.write("Character Name: " + userCharacter.getCharacterName());
            writer.write("\nClass: " + userCharacter.getDndClass().getName());
            writer.write("\nFantasy Race: " + userCharacter.getDndRace().getName());
            writer.write("\nStrength: " + userCharacter.getStrengthScore());
            writer.write("\nDexterity: " + userCharacter.getDexterityScore());
            writer.write("\nConstitution: " + userCharacter.getConstitutionScore());
            writer.write("\nIntelligence: " + userCharacter.getIntelligenceScore());
            writer.write("\nWisdom: " + userCharacter.getWisdomScore());
            writer.write("\nCharisma: " + userCharacter.getCharismaScore());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



//last brace of the class
}
