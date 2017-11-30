
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Uhuuy31
 */
public class tes {
     Random rand = new Random();

     public static void main(String[] args) {
         tes a = new tes();
        double random = Math.random() * (10);
         System.out.println(random);
         double random1 = a.rand.nextInt(5);
         System.out.println(random1);
    }
}


