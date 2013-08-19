/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import logic.*;
import cli.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joel
 */ 
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/intro");
        Scanner in = new Scanner(System.in);
        Scanner out = new Scanner(file);
        while (out.hasNext())
        {
            System.out.println(out.nextLine());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String pName = in.nextLine();
        System.out.println("Oh yes of course " + pName + "!");
        file = new File("src/main/dragon");
        out = new Scanner(file);
        while (out.hasNext())
        {
            System.out.println(out.nextLine());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String dName = in.nextLine();
        Dragon dra = new Dragon(dName);
        System.out.println(dName + " is a good name for a dragon");
        file = new File("src/main/dragon2");
        out = new Scanner(file);
        while (out.hasNext())
        {
            System.out.println(out.nextLine());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Pack pac = new Pack(20);
        Item f = new Item("food", "used to feed dragon", 10);
        pac.addItem(f);
        Player pla = new Player(pName, pac, dra);
        Thread t = new Thread(pla);
        t.start();
        PlayerCLI pcli = new PlayerCLI(pla);
        
    }
    
}
