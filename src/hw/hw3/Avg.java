package hw3;

import java.io.File; //inport the File class
import java.io.FileNotFoundException; //Import this class to handle errors
import java.util.Scanner; //scanner

public class Avg {
    public static void main(String[] args) {
        Scanner scanf = null; 
        String students = args[0]; // Peter 

        File GradeBook = new File(args[1]); //grade.txt
        try{
            scanf = new Scanner(GradeBook);
        }catch(FileNotFoundException e){
            System.out.println("Sorry, we don't find the file, "+
            "please try again later. ");
            return; //out of this function, and this function here is main 
        }

        while(scanf.hasNextLine()){
            String line = scanf.nextLine();
            String[] splited = line.split(":|\\s");

            if (splited[0].equals(students)){

                float sum = 0; 

                for(int i = 1; i < splited.length; i++){
                    sum += Integer.parseInt(splited[i]);
                }
                System.out.println(sum/(splited.length-1));
                break; 
            }
        }
    }
}


// while(scan.hasNextLine())
//         {
//             String str = scan.nextLine();
//             String s[]  = str.split(":|\\s");

//             if(args[0].equals(s[0]))
//             {
//                 float sum=0;
//                 for(int i=1;i<s.length;i++)
//                 {
//                     sum+=Float.parseFloat(s[i]);
//                 }
//                 System.out.println(sum/(s.length-1));
//                 break;
//             }
//         }
        
//         //scan is the scanner object