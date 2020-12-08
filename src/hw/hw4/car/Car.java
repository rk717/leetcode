package car;
import car.utils.Color; 

/*
    Create a `Car` class, which contains the followings:
    * license plate ( `String` )
    * color ( `Color` )
    * maximal speed ( `int` )
*/

public class Car {
    String licensePlate = "";
    Color color; 
    int maximalSpeed = 0; 
    
    static int counter; //no need = 0, because static variable is zero  

    // Create a constructor which gets initial values for the fields specified above.
    // The class should contain a counter, which increases every time a new `Car` is created.
    public Car(String licensePlate, Color color,
                int maximalSpeed){
                    this.licensePlate = licensePlate; 
                    this.color = color; 
                    this.maximalSpeed = maximalSpeed; 
                    counter += 1; 
                }
    

    //Create a constructor without parameters, 
    //which creates a new object with values of `AAA-000` , `BLUE` and `120` .
    public Car(){
        licensePlate = "AAA-000";
        color = Color.BLUE;
        maximalSpeed = 120; 
        counter += 1; 
    }

    //Create a class method which can compare two cars, 
    //it returns true if the first one is faster than the second.
    public static boolean compareSpeed(Car first, Car second){
        if(first.maximalSpeed > second.maximalSpeed){
            return true; 
        }else{
            return false; 
        }
    }

    //Put the `Color` enum into the `car.utils` package 
    //and the `Car` class into the `car` package!

    //write getter to pick the field from outside
    public String getLicensePlate(){
        return licensePlate; 
    }
    public Color getColor(){
        return color; 
    }
    public int getMaximalSpeed(){
        return maximalSpeed; 
    }


}
