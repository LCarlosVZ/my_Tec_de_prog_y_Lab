import java.util.*;

public class Main {
    public static void main(String[] args) {
      
      int [] numeros = {40,50,60,24,66,12,98};
      int suma=0;
      
      for(int i=0;i<=6;i++){
        suma += numeros[i];
      }
      
      int promedio=suma/7;
      System.out.println("El promedio es igual a: "+promedio);
      
      for(int numero:numeros){
          if(numero<promedio){
            System.out.println("El numero "+numero+" es menor que el promedio.");
          }
          else if(numero>promedio){
            System.out.println("El numero "+numero+" es mayor que el promedio.");
          }
          else{
            System.out.println("El numero "+numero+" es igual al promedio.");
          }
      }
      

  }
}
