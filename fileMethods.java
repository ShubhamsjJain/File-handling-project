package file_handling.project;

import java.io.*;
import java.util.Scanner;

public class fileMethods {
    Scanner keyboardInput = new Scanner(System.in);

    public int requirementsOfProject(){
        System.out.println("Type 1: If you want to create a new file");
        System.out.println("Type 2: If you want to write something in file");
        System.out.println("Type 3: If you want to read file");
        System.out.println("Type 4: If you want to delete file");
        System.out.println("Type 5: To view list of files");
        System.out.println("Type 6: If you want to exit ");
        System.out.println();

        System.out.println("Please type any option:\n");
        int choice = keyboardInput.nextInt();
        return choice;


    }

    public void creatingFile(){

        String YESorNO = "";
        do {
            keyboardInput.nextLine();
            System.out.println("Type name of file: ");
            String fileName = keyboardInput.next();

            File newFile = new File("C:\\Users\\kamna jain\\Desktop\\programming\\udemy_exercises\\src\\file_handling\\project\\pathFiles\\" + fileName);

            if (newFile.exists()) {

                keyboardInput.nextLine();
                System.out.println("File " + newFile.getName() + " already exists!.Do you want to give another name? (y/n)");
                YESorNO = keyboardInput.next();

            } else {
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
        System.out.println("Type name of file in which you want to write:");
        String toWriteInFile = keyboardInput.next();
        FileWriter writing = null;
        try {
            writing = new FileWriter("C:\\Users\\kamna jain\\Desktop\\programming\\udemy_exercises\\src\\file_handling\\project\\pathFiles\\" + toWriteInFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        keyboardInput.nextLine();
        System.out.println("Write below");
        String toWrite = keyboardInput.nextLine();
        try {
            writing.write(toWrite);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writing.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readingFile(){

        keyboardInput.nextLine();
        System.out.println("Type name of file which you want to read:");
        String toReadFile = keyboardInput.next();

        FileReader reading = null;
        try {
            reading = new FileReader("C:\\Users\\kamna jain\\Desktop\\programming\\udemy_exercises\\src\\file_handling\\project\\pathFiles\\"+ toReadFile );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner scanning = new Scanner(reading);
        while(scanning.hasNextLine()){
            String line = scanning.nextLine();
            System.out.println(line);
        }
        try {
            reading.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletingFile(){

        keyboardInput.nextLine();
        System.out.println("Type name of file which you want to delete:");
        String toDeleteFile = keyboardInput.next();
        File folder = new File("C:\\Users\\kamna jain\\Desktop\\programming\\udemy_exercises\\src\\file_handling\\project\\pathFiles\\" + toDeleteFile);

        if(folder.delete()){
           System.out.println("File "+ folder.getName() + " has been deleted successfully");
     }else{
            System.out.println("Error in deleting file");
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
