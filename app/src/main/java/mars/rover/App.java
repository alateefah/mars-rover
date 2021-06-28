package mars.rover;

import java.util.Scanner;

import mars.rover.pojo.Input;
import mars.rover.pojo.Rover;
import mars.rover.util.InputFileProcessor;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        /**
         * read file
         * -- determine input is valid
         * -- throw exception otherwise
         * -- store in input class
         */        

        if (0 < args.length) {
            String filename = args[0];
            File file = new File(filename);
            List<String> fileContent = new ArrayList<String>();
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    fileContent.add(data); 
                }
                scanner.close();
                InputFileProcessor fileProcessor = new InputFileProcessor(fileContent);
                Input inputData = fileProcessor.getCleanInput();
                Rover[] rovers = inputData.getRovers();
                /**
                 * for every rover in input class
                */
                
                for (int i = 0; i < rovers.length; i++) {   
                    Rover rover =  rovers[i];         
                    rover = rover.runInstruction();
                    System.out.println(rover.getRoverName()+":"+rover.getPosition().getX()+" "+rover.getPosition().getY()+" "+rover.getPosition().getCoord());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
                e.printStackTrace();
            }
            
        } else {
            System.out.println("Please specify file name.");
        }        
    }
}