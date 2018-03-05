package practise1;
import java.io.*;
import classes_practise.Dog;

public class helloworld {
    public static void main(String[] args)
    {
        Dog puppy1 = new Dog("Akita");
        Dog puppy2 = new Dog("Border Collie",2);
        puppy1.Set_age(3);
        String breed2 = puppy2.Get_Breed();

        System.out.print("1 号小狗的年龄为 ");
        System.out.print(puppy1.Get_age());
        System.out.println();
        System.out.println("breed type of puppy 2 is "+breed2);
    }
}
