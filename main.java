package file_handling.project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String args []) {

        fileMethods fm = new fileMethods();
        Scanner keyboardInput = new Scanner(System.in);
        String performMoreActions = "";
        int choice = 0;

        fm.welcomeScreen();

        do {

            try {
                choice = fm.requirementsOfProject();
            } catch (Exception e) {
                e.getMessage();
            }

            switch (choice) {

                case 1:
                    fm.creatingFile();
                    break;

                case 2:

                    fm.writingInFile();
                    break;

                case 3:

                    fm.readingFile();
                    break;

                case 4:

                    fm.deletingFile();
                    break;

                case 5:

                    fm.listOfFiles();
                    break;

                case 6:

                    fm.searchingFile();
                    break;

                case 7:

                    fm.exit();
                    break;


                default:

                    System.out.println("INVALID Input!!Please try again.");
                    System.out.println();
                    break;
            }

            boolean validInput = false;

            do {
                try {
                    System.out.println("Do you want to perform some more actions? (Y/N)");
                    performMoreActions = keyboardInput.next();
                    if (performMoreActions.equalsIgnoreCase("y") || performMoreActions.equalsIgnoreCase("n")) {
                        validInput = true;   // i.e when user gave correct input(Y or N) hence value got stored in performMoreActions without throwing an error
                    } else {
                        System.out.println("Please give valid input.Y or N");
                    }
                } catch (InputMismatchException e) {
                    System.out.println();
                    System.out.println("Invalid input.Please enter Y or N.");
                    keyboardInput.next();  // to clean the scanner buffer for invalid input
                    System.out.println();
                }
            }while (validInput == false);


        }while((performMoreActions.equalsIgnoreCase("y")));
    }
}
