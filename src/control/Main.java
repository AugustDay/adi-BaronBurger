/*
 * TCSS 342: Project 1 - Burger Baron
 * Main TEST
 */

package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Stack;

/**
 * Launches the program.
 * @author Austin Ingraham
 * @version 20 January 2016
 */
public final class Main {

    /** Private constructor to prevent construction of instances. */
    private Main() {
        //do nothing
    }
    
    /**
     * Runs the program.
     * @param theArgs command line arguments.
     */
    public static void main(final String[] theArgs) {
        FileReader inputStream = null;
        
        try {
            inputStream = new FileReader("customer.txt");
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
        }
        
        testMyStack();
        testBurger();
    }
    
    /** Running time tests for the burger functions. */
    public static void testMyStack() {
        System.out.println("BEGIN STACK TEST:");
        
        final String test = "the quick brown Fox jumps over the lazy dog";
        final String[] testParse = test.split(" ");

        System.out.println("Initializing a stack:");
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            final MyStack<String> testStack = new MyStack<>();
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
        
        System.out.println("\nPush method:");
        final MyStack<String> testStack = new MyStack<>();
        for (int timing = 0; timing < testParse.length; ++timing) {
            final long startTime = System.nanoTime();

            testStack.push(testParse[timing]);
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
        System.out.println("testStack after pushing nine strings:\n" + testStack);
        
        System.out.println("\nSize:");
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            testStack.size();
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
        
        System.out.println("\nIsEmpty:");
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            testStack.isEmpty();
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
        
        System.out.println("\nToString of a stack with nine elements:");
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            testStack.toString();
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
        
        System.out.println("\nPop method:");
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            testStack.pop();
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
        
        System.out.println("\nToString of a stack with four elements:");
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            testStack.toString();
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
    }
    
    /** Running time tests for the burger functions. */ 
    public static void testBurger() {
        System.out.println("\nBEGIN BURGER TEST:");
                
        System.out.println("Order: Triple Chicken Burger with Onions Cheese but Cheddar");

        System.out.println("Initializing a Burger (without theWorks):");
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            final Burger testBurger = new Burger(false);
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
        
        System.out.println("\nInitializing a Burger (with theWorks):");
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            final Burger testBurger = new Burger(true);
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
        
        System.out.println("\nAdd Patty:");
        final Burger testBurger = new Burger(true);
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            testBurger.addPatty();
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
        
        System.out.println("\nRemove Patty:");
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            testBurger.removePatty();
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
        
        System.out.println("\nChange Patties:");
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            testBurger.changePatties("Veggie");
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
        
        System.out.println("\nAdd Category (Sauce):");
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            testBurger.addCategory("Sauce");
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
        
        System.out.println("\nRemove Category (Sauce):");
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            testBurger.removeCategory("Sauce");
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
        
        System.out.println("\nAdd Ingredient (Baron-Sauce):");
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            testBurger.addIngredient("Baron-Sauce");
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
        
        System.out.println("\nRemove Ingredient (Baron-Sauce):");
        for (int timing = 0; timing < 5; ++timing) {
            final long startTime = System.nanoTime();

            testBurger.removeIngredient("Baron-Sauce");
          
            final long endTime = System.nanoTime();
            final long elapsedTime = endTime - startTime;

            System.out.println(elapsedTime + " nanoseconds or " 
                            + elapsedTime/(1000000000.0) + " seconds elapsed");
        }
    }

    /** These are sample input lines which I used to test that my burgers were being-
     * constructed properly and outputting in the correct order. */
    public static void burgerAccuracyTests() {
      /*  System.out.println("Burger:"); //order
        parseLine("Burger"); 
        System.out.println("[Bun, Beef, Bun]"); //expected output
        
        System.out.println("\nBaron Burger:");
        parseLine("Baron Burger");
        System.out.println("[Pickle, Bun, Mayonnaise, Baron-Sauce, Lettuce, Tomato, Onions, Pepperjack, Mozzarella, Cheddar, Beef, Mushrooms, Mustard, Ketchup, Bun]");

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
        */  
    }
    
    /**
     * Parses through the given line of text and creates a burger with the ingredients.
     * @param theLine a line of text
     */
    public static void parseLine(final String theLine) {
        final String[] wordList = theLine.split(" ");
        final boolean baronBurger = wordList[0].equals("Baron") 
                        || wordList[Math.min(1, wordList.length - 1)].equals("Baron") 
                        || wordList[Math.min(2, wordList.length - 1)].equals("Baron");
        
        final Burger burger = new Burger(baronBurger);

        if (wordList[0].equals("Double")) {
            burger.addPatty();
        }
        if (wordList[0].equals("Triple")) {
            burger.addPatty();
            burger.addPatty();
        }
        
        final boolean chicken = wordList[0].equals("Chicken") 
                        || wordList[Math.min(1, wordList.length - 1)].equals("Chicken");
        final boolean veggie = wordList[0].equals("Veggie") 
                        || wordList[Math.min(1, wordList.length - 1)].equals("Veggie");
        if (chicken) {
            burger.changePatties("Chicken");
        }
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
            for (int i = but; i < wordList.length; i++) {
                if (baronBurger) {
                    burger.addIngredient(wordList[i]);
                } else {
                    burger.removeIngredient(wordList[i]);
                }
            }
        }

        System.out.println(burger.toString()); 
    }
    
    /**
     * Checks if the given String matches one of the three categories.
     * @param theString a given String
     * @return true if theString matches either Cheese, Veggies, or Sauce
     */
    public static boolean isCategory(final String theString) {
        return "Cheese".equals(theString) || "Veggies".equals(theString) 
                        || "Sauce".equals(theString);
    }
}
