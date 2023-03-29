package file_handling.project;

import java.util.Scanner;

public class main {

    public static void main(String args []) {

        fileMethods fm = new fileMethods();
        Scanner keyboardInput = new Scanner(System.in);
        String performMoreActions = "";

        fm.welcomeScreen();

        do {


            int choice = 0;

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
                    break;
            }

            do {
                keyboardInput.nextLine();
                System.out.println("Do you want to perform some more actions? (Y/N)");
                performMoreActions = keyboardInput.next();
                if ((performMoreActions.equals("y")) || (performMoreActions.equals("Y")) || (performMoreActions.equals("n")) || (performMoreActions.equals("N"))) {
                    break;
                } else {
                    System.out.println("Invalid Input.Please try again.");
                }
            }while(!((performMoreActions.equals("y")) || (performMoreActions.equals("Y"))));

        }while((performMoreActions.equals("y")) ||(performMoreActions.equals("Y")));
    }
}
