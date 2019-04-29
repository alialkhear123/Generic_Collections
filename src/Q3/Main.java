/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Ali Abo Alkhear
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> hashMap = new HashMap();
        File file = new File("./src/Q3/text.txt");
        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String word = input.next();
            Integer i = hashMap.get(word);
            if (i == null) {
                hashMap.put(word, 1);
            } else {
                hashMap.put(word, i + 1);
            }

            for (int j = 0; j < word.length(); j++) {
                Character charr = word.charAt(j);
                Integer i2 = hashMap.get(charr.toString());
                if (i2 == null) {
                    hashMap.put(charr.toString(), 1);
                } else {
                    hashMap.put(charr.toString(), i2 + 1);
                }
            }

        }
//        System.out.println(hashMap);
//        System.out.println(hashMap.entrySet());
//        System.out.printf("The %-15s", hashMap);
        for (String name : hashMap.keySet()) {
//            System.out.println(name);
            String key = name.toString();
            String value = hashMap.get(name).toString();
            System.out.println(key + " => " + value);
        }
    }

}
