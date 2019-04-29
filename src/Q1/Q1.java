/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Ali Abo Alkhear
 */
public class Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> number = new LinkedList();
        Random randomGenerator = new Random();

        for (int i = 0; i < 25; i++) {
            int randomInt = randomGenerator.nextInt(100);
            number.add(randomInt);
        }

        System.out.println(number);
        int sum = 0;

        for (int i = 0; i < number.size(); i++) {
            sum += number.get(i);
        }

        double avg = sum / 25;
        System.out.println(number.size());
        System.out.println(sum);
        System.out.println(avg);

    }
}
