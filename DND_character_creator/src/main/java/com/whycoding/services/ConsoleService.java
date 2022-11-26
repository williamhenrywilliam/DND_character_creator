package com.whycoding.services;

import com.whycoding.model.DNDClass;
import com.whycoding.model.DNDResource;
import com.whycoding.model.PlayerCharacter;

import java.util.Map;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class ConsoleService {

    private final DNDClassService dndClassService = new DNDClassService();
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
                    //TODO
                    break;
                case 3:
                    //TODO

                    break;
                case 4:
                    //TODO
                    System.out.println("-------------------------");
                    System.out.println("Name Selection");
                    System.out.println("-------------------------");
                    System.out.println("Please enter your character's name:");
                    String characterName = scanner.nextLine();
                    System.out.println(characterName + "? Great choice!");

                    userCharacter.setCharacterName(characterName);
                    createCharacterSheet(userCharacter.getCharacterName());
                    break;
                case 5:
                    //TODO
                    break;
                case 6:
                    System.out.println("-------------------------");
                    System.out.println("DND Classes");
                    System.out.println("-------------------------");
                    printResource(dndClassService.getClassesResource());
                    break;
                case 7:
                    System.out.println("---------------");
                    System.out.println("DND Races");
                    System.out.println("---------------");
                    printResource(dndClassService.getRacesResource());
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
        System.out.println("3: Choose Background");
        System.out.println("4: Choose Name");
        System.out.println("5: Roll for Ability Scores");
        System.out.println("6: See Classes");
        System.out.println("7: See Races");

        System.out.println("0: Exit");
        System.out.println();
    }

    public void handleClassSelectionMenu(){
        int menuSelection = -1;
        while(menuSelection != 0){
            printClassSelectionMenu();
            menuSelection = promptForMenuSelection();
            switch(menuSelection){
                case 0:
                    continue;
                case 1:
                    printClass(dndClassService.getClassByIndex("barbarian"));
                    break;
                case 2:
                    printClass(dndClassService.getClassByIndex("bard"));
                    break;
                case 3:
                    printClass(dndClassService.getClassByIndex("cleric"));
                    break;
                case 4:
                    printClass(dndClassService.getClassByIndex("druid"));
                    break;
                case 5:
                    printClass(dndClassService.getClassByIndex("fighter"));
                    break;
                case 6:
                    printClass(dndClassService.getClassByIndex("monk"));
                    break;
                case 7:
                    printClass(dndClassService.getClassByIndex("paladin"));
                    break;
                case 8:
                    printClass(dndClassService.getClassByIndex("ranger"));
                    break;
                case 9:
                    printClass(dndClassService.getClassByIndex("rogue"));
                    break;
                case 10:
                    printClass(dndClassService.getClassByIndex("sorcerer"));
                    break;
                case 11:
                    printClass(dndClassService.getClassByIndex("warlock"));
                    break;
                case 12:
                    printClass(dndClassService.getClassByIndex("wizard"));
                    break;
                default:
                    System.out.println("Invalid selection");;
            }
        }
    }

    public void printClassSelectionMenu(){
        System.out.println();
        System.out.println("---------Classes---------");
        System.out.println("1: Barbarian");
        System.out.println("2: Bard");
        System.out.println("3: Cleric");
        System.out.println("4: Druid");
        System.out.println("5: Fighter");
        System.out.println("6: Monk");
        System.out.println("7: Paladin");
        System.out.println("8: Ranger");
        System.out.println("9: Rogue");
        System.out.println("10: Sorcerer");
        System.out.println("11: Warlock");
        System.out.println("12: Wizard");
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
        System.out.println("This program will guide you step by step in the character creation process for 5th edition character creation.");
        System.out.println("You will make exciting decisions about your character as you bring your idea to life.");
        System.out.println("What fantasy race will they belong to?");
        System.out.println("What class will they have?");
        System.out.println("Where does this character come from and what is their motivation to take up adventuring?!");
        System.out.println("All of this and more will be answered by you. By the end of the process, you will have a fully fleshed out PC ready to take to the table");
        System.out.println("There is no time to waste. Return to the main menu and get to it, adventurer! And remember, it's dangerous to go alone...");
        System.out.println();
    }

    public void printClass(DNDClass dndClass) {
        System.out.println(dndClass.toString());
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
            characterSheet.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



//last brace of the class
}
