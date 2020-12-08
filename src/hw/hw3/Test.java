package hw3;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String name = args[0]; 

        File gb = new File(args[1]);
        Scanner sc = null;
        try {
            sc = new Scanner(gb);
        } catch (FileNotFoundException e) {
            System.out.println("no file");
            e.printStackTrace();
        }
        
        while(sc.hasNextLine()){
            String line = sc.nextLine(); 
            String[] splited = line.split(":|\\s");
            if(splited[0].equals(name)){
                float sum = 0; 
                for(int i = 1; i < splited.length; i++){
                    sum += Integer.parseInt(splited[i]);
                }
                System.out.println(sum/(splited.length-1));
                break; 
            }
        }

        //System.out.println(args[0]);
    }
}
