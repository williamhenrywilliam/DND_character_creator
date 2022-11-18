package com.whycoding;

import com.whycoding.model.DNDClass;
import com.whycoding.services.ConsoleService;
import com.whycoding.services.DNDClassService;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private final DNDClassService dndClassService = new DNDClassService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run(){
        System.out.println("***********************************************");
        System.out.println("\tWelcome to the DND 5e Character Creator!");
        System.out.println("***********************************************");
        System.out.println();

        int menuSelection = -1;

        while(menuSelection != 0){
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            switch(menuSelection){
                case 0:
                    continue;
                case 1:
                    consoleService.handleCharacterCreationMenu();
                    break;
                case 2:
                    consoleService.printLearnMoreInfo();
                    break;
                default:
                    System.out.println("Invalid selection");;
            }
        }
    }



//last curly brace of the class
}