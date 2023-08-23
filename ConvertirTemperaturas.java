import java.util.*;

public class Main {
    public static void main(String[] args) {
      
      int [] gradosCelsius = {0,100,25,-10};
      int [] gradosFahrenheit = {32,100,-40};
      
      for(int i=0; i <=3;i++){
        System.out.println("Celsius a Fahrenheit: "+(gradosCelsius[i]*1.8)+32);
      }
      
      for(int j=0; j <=2;j++){
        System.out.println("Fahrenheit a Celsius: "+(gradosFahrenheit[j]-32)/1.8);
      }
  }
}
