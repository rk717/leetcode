import car.Car; 
import car.utils.Color; 

import java.io.File; 
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

// Create a `Main` class outside of the packages, 
// which will contain the tests.
// The `main()` method should read a file and store the cars in an array. 
// Use ArrayList which is a dynamic array. 

public class Main {
    public static void main(String[] args) {
        Scanner myReader = null; 
        try{
            File myCar = new File("input.txt");
            myReader = new Scanner(myCar);
        }catch(FileNotFoundException e){
            System.out.println("no file");
            return; 
        }
        

        ArrayList<Car> newList = new ArrayList<Car>();

        while(myReader.hasNextLine()){
            String line = myReader.nextLine();  //first read the first line 

            String[] splited = line.split(", "); 
            //{"ABC-123", "RED", "100"}

            String licensePlate = splited[0]; 
            Color color = Color.valueOf(splited[1]); 
            int maxSpeed = Integer.parseInt(splited[2]);

            newList.add(new Car(licensePlate, color, maxSpeed));
            
        }

        for(Car carPrint : newList){
            System.out.println(carPrint.getLicensePlate() + ':'
                                + carPrint.getColor() + ':'
                                + carPrint.getMaximalSpeed()); 
            //ABC-123:RED:100
        }

        // for(int i = 0; i < newList.size(); i++){
        //     System.out.println(newList[i].licensePlate + ':'
        //                         + newList[i].color + ':'
        //                         + newList[i].maximalSpeed); 
        // }

    }
}

// The below statement creates  l, 
// an  ArrayList of Auto  type 
// ArrayList<Auto> l = new ArrayList<Auto>();

// or 

// List<Auto> l = new ArrayList<>();

// Then print each object inside the array. 
// You should understand what you need to print the object. 
// The output object should be like  ABC-123:RED:100.