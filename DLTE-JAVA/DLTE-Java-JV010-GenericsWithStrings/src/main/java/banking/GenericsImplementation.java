package banking;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class GenericsImplementation {
    public static void main(String[] args) {
        Generics<> objectarr=new Generics<>();
        objectarr.Addobjects();

    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class Generics<T>{
  private T[] array;
    Scanner scanner=new Scanner(System.in);
    public void Addobjects(){
        System.out.println("Enter the object to be added");
      T addedele=(T) scanner.toString();
      for(Integer index=0;index<array.length;index++){
            array[index]=(T) scanner.toString();
        }
      System.out.println(array);
    }

    public void FindandReplace(){
        System.out.println("Enter the element to be found");
        T value=(T)scanner.toString();
        for(Integer index=0;index<array.length;index++){
            array[index]=(T) scanner.toString();

        if(value.equals(array[index])){
            System.out.println("The entered element is at"+index);
            System.out.println("Enter the element to be placed");
            T newvalue=(T) scanner.toString();
            String updated= Arrays.toString(array);
            updated=newvalue.replace(value,newvalue);
//            value=(T)value.replace(newvalue);
        }
        else
            System.out.println("Entered element not found");
    }
}