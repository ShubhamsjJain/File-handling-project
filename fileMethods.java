package file_handling.project;

import java.io.*;
import java.util.Scanner;

public class fileMethods {
    Scanner keyboardInput = new Scanner(System.in);
    File newFile;

    public int requirementsOfProject(){
        System.out.println("Type 1: If you want to create a new file");
        System.out.println("Type 2: If you want to write something in file");
        System.out.println("Type 3: If you want to read file");
        System.out.println("Type 4: If you want to delete file");
        System.out.println("Type 5: To view list of files");
        System.out.println("Type 6: If you want to exit ");
        System.out.println();

        System.out.print("Please type any option: ");
        int choice = keyboardInput.nextInt();
        return choice;


    }

    public void creatingFile(){

        String YESorNO = "";
        do {
            keyboardInput.nextLine();
            System.out.print("Type name of file (with extension) or press 0 if you want to return to main context: ");
            String fileName = keyboardInput.next();

            this.newFile = new File("C:\\Users\\kamna jain\\Desktop\\programming\\udemy_exercises\\src\\file_handling\\project\\pathFiles\\" + fileName);

            if (newFile.exists()) {

                keyboardInput.nextLine();
                System.out.print("File " + newFile.getName() + " already exists!.Do you want to give another name? (y/n)");
                YESorNO = keyboardInput.next();

            } else if(fileName.equals("0")){


                break;
               // requirementsOfProject();
                //break;


            }else {
                try {
                    newFile.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("File " + newFile.getName() + " has been created successfully.");
                break;
            }
        }while(YESorNO.equals("y") ||  YESorNO.equals("Y"));
    }

    public void writingInFile(){

        keyboardInput.nextLine();
        System.out.print("Type name of file (with extension) in which you want to write or press 0 if you want to return to main context: ");
        String toWriteInFile = keyboardInput.next();

        this.newFile = new File("C:\\Users\\kamna jain\\Desktop\\programming\\udemy_exercises\\src\\file_handling\\project\\pathFiles\\" + toWriteInFile);

        if(newFile.exists()) {
            FileWriter writing;
            try {
                writing = new FileWriter("C:\\Users\\kamna jain\\Desktop\\programming\\udemy_exercises\\src\\file_handling\\project\\pathFiles\\" + toWriteInFile, true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

                keyboardInput.nextLine();
                System.out.println("Write below");
                String toWrite = keyboardInput.nextLine();
                try {
                    writing.write("\n" + toWrite);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            try {
                writing.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                writing.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else if (toWriteInFile.equals("0")) {
            requirementsOfProject();
        }else{
            System.out.println("\nFile doesn't exist.Please give valid input.\n");
            writingInFile();

        }
    }

    public void readingFile(){

        keyboardInput.nextLine();
        System.out.print("Type name of file (with extension) which you want to read or press 0 if you want to return to main context: ");
        String toReadFile = keyboardInput.next();

        this.newFile = new File("C:\\Users\\kamna jain\\Desktop\\programming\\udemy_exercises\\src\\file_handling\\project\\pathFiles\\" + toReadFile);

        if(newFile.exists()) {
            FileReader reading = null;


            try {
                reading = new FileReader("C:\\Users\\kamna jain\\Desktop\\programming\\udemy_exercises\\src\\file_handling\\project\\pathFiles\\" + toReadFile);
            } catch (FileNotFoundException e) {
                System.out.println("File " + toReadFile + " doesn't exist.Please give valid Input.");

            }
                Scanner scanning = new Scanner(reading);
                while (scanning.hasNextLine()) {
                    String line = scanning.nextLine();
                    System.out.println(line);
                }

            try {
                reading.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else if (toReadFile.equals("0")) {
            requirementsOfProject();
        }else{

            System.out.println("\nFile doesn't exist.Please give valid input.\n");
            readingFile();
        }
    }

    public void deletingFile(){

        keyboardInput.nextLine();
        System.out.print("Type name of file (with extension) which you want to delete or press 0 if you want to return to main context: : ");
        String toDeleteFile = keyboardInput.next();
        this.newFile = new File("C:\\Users\\kamna jain\\Desktop\\programming\\udemy_exercises\\src\\file_handling\\project\\pathFiles\\" + toDeleteFile);

        if(newFile.exists()){

            newFile.delete();
           System.out.println("File "+ newFile.getName() + " has been deleted successfully");
        }else if (toDeleteFile.equals("0")) {
            requirementsOfProject();
        }else{
            System.out.println("\nCan't delete!!.File " + newFile.getName() + " doesn't exist.\n");
            deletingFile();
        }
    }

    public void listOfFiles(){

        File folder = new File("C:\\Users\\kamna jain\\Desktop\\programming\\udemy_exercises\\src\\file_handling\\project\\pathFiles\\");
        File [] allFiles = folder.listFiles();
        for (int i = 0; i < allFiles.length ; i++) {
            if(allFiles[i].isFile()){
                System.out.println(allFiles[i].getName());
            }


        }
    }

    public void exit(){

    }


}
