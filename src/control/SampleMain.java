/*
 * TCSS 342: Project 1 - Burger Baron
 * Main
 */

package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Launches the program.
 * @author Austin Ingraham
 * @version 20 January 2016
 */
public final class SampleMain {

    /** Private constructor to prevent construction of instances. */
    private SampleMain() {
        //do nothing
    }
    
    /**
     * Runs the program.
     * @param theArgs command line arguments.
     */
    public static void main(final String[] theArgs) {
     /*   FileReader inputStream = null;
        
        try {
            inputStream = new FileReader("control/customer.txt");
            final BufferedReader bufferedStream = new BufferedReader(inputStream);
            String line;
            int count = 0;
            while ((line = bufferedStream.readLine()) != null) {
                System.out.print("Processing Order " + count++ + ": ");
                System.out.println(line); // useful for debugging
                parseLine(line);
                System.out.println();
            }
            bufferedStream.close();
        } catch (final FileNotFoundException e) {
            System.out.println("FileNotFound!");
            e.printStackTrace();
        } catch (final IOException e) {
            System.out.println("IOException!");
            e.printStackTrace();
        } */
        System.out.println("TEST CASES:");
        testParse();        
    }
    
    /** Runs some test cases for different Baron Burger orders. */
    public static void testParse() {
        System.out.println("Burger:");
        parseLine("Burger");
        System.out.println("[Bun, Beef, Bun]");
        
        System.out.println("\nBaron Burger:");
        parseLine("Baron Burger");
        System.out.println("[Pickle, Bun, Mayonnaise, Baron-Sauce, Lettuce, Tomato, Onions, Pepperjack, Mozzarella, Cheddar, Beef, Mushrooms, Mustard, Ketchup, Bun]");
        
        System.out.println("\nDouble Chicken Burger with Cheese Ketchup:");
        parseLine("Double Chicken Burger with Cheese Ketchup");
        System.out.println("???"); 
        
        System.out.println("\nTriple Veggie Baron Burger with no Veggies Mustard but Onions:");
        parseLine("Triple Veggie Baron Burger with no Veggies Mustard but Onions");
        System.out.println("???"); 

        System.out.println("\nDouble Baron Burger:");
        parseLine("Double Baron Burger");
        System.out.println("[Pickle, Bun, Mayonnaise, Baron-Sauce, Lettuce, Tomato, Onions, Beef, Pepperjack, Mozzarella, Cheddar, Beef, Mushrooms, Mustard, Ketchup, Bun]");
   
        System.out.println("\nTriple Chicken Burger with Onions Cheese but Cheddar:");
        parseLine("Triple Chicken Burger with Onions Cheese but Cheddar");
        System.out.println("[Bun, Onions, Chicken, Chicken, Pepperjack, Mozzarella, Chicken, Bun]");

        System.out.println("\nBaron Burger with no Veggies Sauce but Baron-Sauce:");
        parseLine("Baron Burger with no Veggies Sauce but Baron-Sauce");
        System.out.println("[Bun, Baron-Sauce, Pepperjack, Mozzarella, Cheddar, Beef, Bun]");
  
        System.out.println("\nSingle Veggie Baron Burger:");
        parseLine("Single Veggie Baron Burger");
        System.out.println("[Pickle, Bun, Mayonnaise, Baron-Sauce, Lettuce, Tomato, Onions, Pepperjack, Mozzarella, Cheddar, Veggie, Mushrooms, Mustard, Ketchup, Bun]");
        
        System.out.println("\nDouble Baron Burger with no Cheese but Mozzarella:");
        parseLine("Double Baron Burger with no Cheese but Mozzarella");
        System.out.println("[Pickle, Bun, Mayonnaise, Baron-Sauce, Lettuce, Tomato, Onions, Beef, Mozzarella, Beef, Mushrooms, Mustard, Ketchup, Bun]");
        
        System.out.println("\nSingle Burger with Veggies but no Lettuce:");
        parseLine("Single Burger with Veggies but no Lettuce");
        System.out.println("[Pickle, Bun, Tomato, Onions, Beef, Mushrooms, Bun]");
        
        System.out.println("\nDouble Chicken Burger with Ketchup Cheddar Onions and Mushrooms:");
        parseLine("Double Chicken Burger with Ketchup Cheddar Onions and Mushrooms");
        System.out.println("[Bun, Onions, Chicken, Cheddar, Chicken, Mushrooms, Ketchup, Bun]");
        
        System.out.println("\nTriple Baron Burger:");
        parseLine("Triple Baron Burger");
        System.out.println("[Pickle, Bun, Mayonnaise, Baron-Sauce, Lettuce, Tomato, Onions, Beef, Beef, Pepperjack, Mozzarella, Cheddar, Beef, Mushrooms, Mustard, Ketchup, Bun]");       
    }
    
    public static void parseLine(String theLine) {
        final String[] wordList = theLine.split(" ");
        Burger burger;
        
//      for(int i = 0; i < words.length; i++) {
//          System.out.println("|"+ words[i]+"|");
//      }
        
        final boolean baronBurger = wordList[0].equals("Baron") 
                        || wordList[Math.min(1, wordList.length - 1)].equals("Baron") 
                        || wordList[Math.min(2, wordList.length - 1)].equals("Baron");
        burger = new Burger(baronBurger);
//      System.out.println(baronBurger);
        if (wordList[0].equals("Double")) {
            burger.addPatty();
        }
        if (wordList[0].equals("Triple")) {
            burger.addPatty();
            burger.addPatty();
        }
        
        final boolean chicken = wordList[0].equals("Chicken") 
                        | wordList[Math.min(1, wordList.length - 1)].equals("Chicken");
        if (chicken) {
            burger.changePatties("Chicken");
        }
        final boolean veggie = wordList[0].equals("Veggie") 
                        || wordList[Math.min(1, wordList.length - 1)].equals("Veggie");
        if (veggie) {
            burger.changePatties("Veggie");
        }
        
        int with = 0;
        int but = 0;
        for (int i = 0; i < wordList.length; i++) {
            if (wordList[i].equals("with")) {
                with = i;
            }
            if (wordList[i].equals("but")) {
                but = i;
            }
        }
        
        if (with > 0) {
            int end = wordList.length;
            if (but > 0) {
                end = but;
            }
            for (int i = with; i < end; i++) {
//              System.out.println(words[i]);
                final boolean cat = isCategory(wordList[i]);
                if (cat) {
                    if (baronBurger) {
                        burger.removeCategory(wordList[i]);
                    } else {
                        burger.addCategory(wordList[i]);
                    }
                } else {
                    if (baronBurger) {
                        burger.removeIngredient(wordList[i]);
                    } else {
                        burger.addIngredient(wordList[i]);
                    }
                }
            }
        }
        if (but > 0) {
            int end = wordList.length;
            for (int i = but; i < end; i++) {
//              System.out.println(words[i]);
                if (baronBurger) {
                    burger.addIngredient(wordList[i]);
                } else {
                    burger.removeIngredient(wordList[i]);
                }
            }
        }

        System.out.println(burger.toString()); 
    }
    
    public static boolean isCategory(String str) {
        return "Cheese".equals(str) || "Veggies".equals(str) || "Sauce".equals(str);
    }
}