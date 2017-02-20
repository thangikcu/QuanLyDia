/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author Thanggun99
 */
public class Util {

    public static int menu(String menu){
        System.out.print(menu);
        Scanner scanner = new Scanner(System.in);
            try {
                return scanner.nextInt();
            } catch (Exception e) {
               return menu(menu);
            }
    }
}
