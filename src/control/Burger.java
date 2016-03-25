/*
 * TCSS 342: Project 1 - Burger Baron
 * Burger Class
 */

package control;

/**
 * A Burger.
 * @author Austin Ingraham
 * @version 21 January 2016
 */
public final class Burger {
    
    /** A Veggie-type ingredient. */
    private static final String PICKLE = "Pickle";
    
    /** A Static String to represent a common ingredient. */
    private static final String BUN = "Bun";
    
    /** A Sauce-type ingredient. */
    private static final String MAYO = "Mayonnaise";
    
    /** A Sauce-type ingredient. */
    private static final String BARON_SAUCE = "Baron-Sauce";
    
    /** A Veggie-type ingredient. */
    private static final String LETTUCE = "Lettuce";
    
    /** A Veggie-type ingredient. */
    private static final String TOMATO = "Tomato";
    
    /** A Veggie-type ingredient. */
    private static final String ONIONS = "Onions";
    
    /** A type of cheese. */
    private static final String PEPPERJACK = "Pepperjack";
    
    /** A type of cheese. */
    private static final String MOZZARELLA = "Mozzarella";
    
    /** A type of cheese. */
    private static final String CHEDDAR = "Cheddar";
    
    /** A Veggie-type ingredient. */
    private static final String MUSHROOMS = "Mushrooms";
    
    /** A Sauce-type ingredient. */
    private static final String MUSTARD = "Mustard";
    
    /** A Sauce-type ingredient. */
    private static final String KETCHUP = "Ketchup";
    
    /** Holds the current patty type for use with toString method. Ex: Beef, Veggie... */
    private String myPattyType;
    
    /** Tracks the total number of patties. Defaults to 1, ranges between 1 and 3. */
    private int myPattyCount = 1;
    
    /** The top of the burger. */
    private final MyStack<String> myTopStack;
    
    /** The middle portion of the burger which holds the cheese. */
    private final MyStack<String> myCheeseStack;
    
    /** The bottom of the burger. */
    private final MyStack<String> myBottomStack;

    /**
     * A constructor that initializes a Burger.
     * Has only a bun and patty if theWorks is false and a Baron Burger if theWorks is true.
     * @param theWorks true if this burger is to be a Baron Burger.
     */
    Burger(final boolean theWorks) {
        myPattyType = "Beef"; //default patty type.
        myTopStack = new MyStack<>();
        myCheeseStack = new MyStack<>();
        myBottomStack = new MyStack<>();
        if (theWorks) {
            addTheWorks();
        } else {
            myTopStack.push(BUN);
            myBottomStack.push(BUN);
        }
    }
    
    /** Helper method which adds all the ingredients of a basic Baron Burger. */
    private void addTheWorks() {
        myTopStack.push(PICKLE);
        myTopStack.push(BUN);
        myTopStack.push(MAYO);
        myTopStack.push(BARON_SAUCE);
        myTopStack.push(LETTUCE);
        myTopStack.push(TOMATO);
        myTopStack.push(ONIONS);
        
        myCheeseStack.push(PEPPERJACK);
        myCheeseStack.push(MOZZARELLA);
        myCheeseStack.push(CHEDDAR);
                        
        myBottomStack.push(BUN);
        myBottomStack.push(KETCHUP);
        myBottomStack.push(MUSTARD);
        myBottomStack.push(MUSHROOMS);
    }
    
    /**
     * Changes all patties in the Burger to the pattyType.
     * @param thePattyType the new patty.
     */
    public void changePatties(final String thePattyType) {
        myPattyType = thePattyType;
    }
    
    /** Adds one patty to the Burger up to the maximum of 3. */
    public void addPatty() {
        if (myPattyCount < 3) {
            myPattyCount++;
        }
    }
    
    /** Removes one patty from the Burger down to the minimum of 1. */
    public void removePatty() {
        if (myPattyCount > 1) {
            myPattyCount--;
        }
    }
    
    /**
     * Adds all items of the given type to the Burger in the proper locations. 
     * @param theType an item to add.
     */
    public void addCategory(final String theType) {
        if ("Veggies".equals(theType)) {
            addVeggies();
        } else if ("Sauce".equals(theType)) {
            addSauce();
        } else if ("Cheese".equals(theType)) {
            myCheeseStack.clear();
            myCheeseStack.push(PEPPERJACK);
            myCheeseStack.push(MOZZARELLA);
            myCheeseStack.push(CHEDDAR);
        }
    }
    
    /** Adds all items of the veggie category to this burger. */
    private void addVeggies() {
        final MyStack<String> tempStack = new MyStack<>();
        while (!myTopStack.isEmpty()) {
            final String item = myTopStack.pop();
            if (!isVeggie(item)) {
                tempStack.push(item);
            }
        }
        myTopStack.push(PICKLE);
        while (!tempStack.isEmpty()) {
            myTopStack.push(tempStack.pop());
        }
        myTopStack.push(LETTUCE);
        myTopStack.push(TOMATO);
        myTopStack.push(ONIONS);
        
        if (!MUSHROOMS.equals(myBottomStack.peek())) {
            myBottomStack.push(MUSHROOMS);
        }
    }
    
    /** Adds all items of the sauce category to this burger. */
    private void addSauce() {
        final MyStack<String> tempStack = new MyStack<>();
        while (!BUN.equals(myTopStack.peek())) {
            final String item = myTopStack.pop();
            if (!isTopSauce(item)) {
                tempStack.push(item);
            }
        }
        myTopStack.push(MAYO);
        myTopStack.push(BARON_SAUCE);
        while (!tempStack.isEmpty()) {
            myTopStack.push(tempStack.pop());
        }

        while (!BUN.equals(myBottomStack.peek())) {
            final String item = myBottomStack.pop();
            if (!isBottomSauce(item)) {
                tempStack.push(item);
            }
        }
        myBottomStack.push(KETCHUP);
        myBottomStack.push(MUSTARD);
        while (!tempStack.isEmpty()) {
            myBottomStack.push(tempStack.pop());
        }
    }
    
    /**
     * Returns true if the given String is a type of veggie.
     * @param theString a String ingredient
     * @return true if the String is a veggie
     */
    private boolean isVeggie(final String theString) {
        return ONIONS.equals(theString) || TOMATO.equals(theString) 
                        || LETTUCE.equals(theString) || PICKLE.equals(theString)
                        || MUSHROOMS.equals(theString);
    }
    
    /**
     * Returns true if the given String is a type of cheese.
     * @param theString a String ingredient
     * @return true if the String is a kind of cheese
     */
    private boolean isCheese(final String theString) {
        return PEPPERJACK.equals(theString) || MOZZARELLA.equals(theString) 
                        || CHEDDAR.equals(theString);
    }
    
    /**
     * Returns true if the given String is a type of sauce which belongs on the top.
     * @param theString a String ingredient
     * @return true if the String is Baron Sauce or Mayonnaise
     */
    private boolean isTopSauce(final String theString) {
        return BARON_SAUCE.equals(theString) || MAYO.equals(theString);
    }
    
    /**
     * Returns true if the given String is a type of sauce which belongs on the bottom.
     * @param theString a String ingredient
     * @return true if the String is Ketchup or Mustard
     */
    private boolean isBottomSauce(final String theString) {
        return KETCHUP.equals(theString) || MUSTARD.equals(theString);
    }
    
    /**
     * Removes all items of the given type from the Burger.
     * @param theType an item to remove.
     */
    public void removeCategory(final String theType) {
        if ("Veggies".equals(theType)) {
            removeVeggies();
        } else if ("Sauce".equals(theType)) {
            removeSauce();
        } else if ("Cheese".equals(theType)) {
            myCheeseStack.clear();
        }
    }
    
    /** Removes all items of the veggie category from this burger. */
    private void removeVeggies() {
        final MyStack<String> tempStack = new MyStack<>();
        while (!myTopStack.isEmpty()) {
            final String item = myTopStack.pop();
            if (!isVeggie(item)) {
                tempStack.push(item);
            }
        }
        while (!tempStack.isEmpty()) {
            myTopStack.push(tempStack.pop());
        }
      
        if (MUSHROOMS.equals(myBottomStack.peek())) {
            myBottomStack.pop();
        }
    }
    
    /** Removes all items of the veggie category from this burger. */
    private void removeSauce() {
        final MyStack<String> tempStack = new MyStack<>();
        while (!myTopStack.isEmpty()) {
            final String item = myTopStack.pop();
            if (!isTopSauce(item)) {
                tempStack.push(item);
            }
        }
        while (!tempStack.isEmpty()) {
            myTopStack.push(tempStack.pop());
        }
      
        while (!myBottomStack.isEmpty()) {
            final String item = myBottomStack.pop();
            if (!isBottomSauce(item)) {
                tempStack.push(item);
            }
        }
        while (!tempStack.isEmpty()) {
            myBottomStack.push(tempStack.pop());
        }
    }
    
    /**
     * Adds the ingredient of given type to the Burger in the proper location.
     * @param theType an ingredient to add.
     */
    public void addIngredient(final String theType) {
        final MyStack<String> tempStack = new MyStack<>();
        if (PICKLE.equals(theType)) {
            addLowestElement(tempStack, myTopStack, PICKLE);
        } else if (MAYO.equals(theType)) {
            addAboveBun(myTopStack, tempStack, MAYO);
        } else if (BARON_SAUCE.equals(theType)) {
            addBaronSauce(tempStack);
        } else if (LETTUCE.equals(theType)) {
            addLettuce(tempStack);
        } else if (TOMATO.equals(theType)) {
            addAlmostHighestElement(myTopStack, TOMATO, ONIONS);
        } else if (ONIONS.equals(theType)) {
            addHighestElement(myTopStack, ONIONS);
        } else if (PEPPERJACK.equals(theType)) {
            addHighestElement(myTopStack, PEPPERJACK);
        } else if (MOZZARELLA.equals(theType)) {
            addAlmostHighestElement(myCheeseStack, MOZZARELLA, PEPPERJACK);
        } else if (CHEDDAR.equals(theType)) {
            addLowestElement(tempStack, myCheeseStack, CHEDDAR);
        } else if (MUSHROOMS.equals(theType)) {
            addHighestElement(myBottomStack, MUSHROOMS);
        } else if (MUSTARD.equals(theType)) {
            addAlmostHighestElement(myBottomStack, MUSTARD, MUSHROOMS);
        } else if (KETCHUP.equals(theType)) {
            addAboveBun(myBottomStack, tempStack, KETCHUP);
        } 
    }
    
    /** 
     * Given a stack and a String, adds that item to the bottom of the stack.
     * @param theMainStack the stack to add the String to
     * @param theTempStack a temporary stack used to preserve item order
     * @param theElement the item to add
     */
    private void addLowestElement(final MyStack<String> theMainStack,
                                  final MyStack<String> theTempStack,
                                  final String theElement) {
        while (!theMainStack.isEmpty()) {
            theTempStack.push(theMainStack.pop());
        }
        if (theTempStack.isEmpty()) {
            theMainStack.push(theElement);
        } else if (!theElement.equals(theTempStack.peek())) {
            theMainStack.push(theElement);
        }
        while (!theTempStack.isEmpty()) {
            theMainStack.push(theTempStack.pop());
        }
    }
    
    /**
     * Given a stack and an ingredient, adds that ingredient just above the bun.
     * @param theMainStack the stack to add the String to
     * @param theTempStack a temporary stack used to preserve item order
     * @param theElement the string ingredient
     */
    private void addAboveBun(final MyStack<String> theMainStack, 
                             final MyStack<String> theTempStack,
                             final String theElement) {
        while (!BUN.equals(theMainStack.peek())) {                
            theTempStack.push(theMainStack.pop());
        }
        if (theTempStack.isEmpty()) {
            theMainStack.push(theElement);
        } else if (!theElement.equals(theTempStack.peek())) {
            theMainStack.push(theElement);
        }
        while (!theTempStack.isEmpty()) {
            theMainStack.push(theTempStack.pop());
        }
    }
    
    /** 
     * Adds Baron-Sauce to the TopStack.
     * @param theTempStack a temporary stack used to preserve item order
     */
    private void addBaronSauce(final MyStack<String> theTempStack) {
        while (!BUN.equals(myTopStack.peek())) {                
            final String item = myTopStack.pop();
            if (BARON_SAUCE.equals(item)) {
                break;
            } else if (MAYO.equals(item)) {
                myTopStack.push(item);
                break;
            } else {
                theTempStack.push(item);
            }
        }
        myTopStack.push(BARON_SAUCE);
        while (!theTempStack.isEmpty()) {
            myTopStack.push(theTempStack.pop());
        }
    }
    
    /** 
     * Adds Lettuce to the TopStack.
     * @param theTempStack a temporary stack used to preserve item order
     */
    private void addLettuce(final MyStack<String> theTempStack) {
        while (!BUN.equals(myTopStack.peek())) {
            if (isTopSauce(myTopStack.peek())) {
                break;
            }
            theTempStack.push(myTopStack.pop());
        }
        myTopStack.push(LETTUCE);
        while (!theTempStack.isEmpty()) {
            myTopStack.push(theTempStack.pop());
        }
    }
    
    /** 
     * Given a stack and a String, adds that item after theBefore.
     * @param theMainStack the stack to add the String to
     * @param theElement the item to add
     * @param theBefore String coming before theElement in theMainStack
     */
    private void addAlmostHighestElement(final MyStack<String> theMainStack, 
                           final String theElement, final String theBefore) {
        if (!theMainStack.isEmpty()) {
            final String item = theMainStack.pop();
            if (theBefore.equals(item)) {
                if (!theElement.equals(theMainStack.peek())) {
                    theMainStack.push(theElement);
                }
                theMainStack.push(item);
            } else if (!theElement.equals(item)) {
                theMainStack.push(item);
                theMainStack.push(theElement);
            }
        } else {
            theMainStack.push(theElement);
        }
    }
    
    /** 
     * Given a stack and a String, adds that item to the top of the stack.
     * @param theMainStack the stack to add the String to
     * @param theElement the item to add
     */
    private void addHighestElement(final MyStack<String> theMainStack,
                                   final String theElement) {
        if (!theElement.equals(theMainStack.peek())) {
            theMainStack.push(theElement);
        }
    }
    
    /**
     * Removes the ingredient of given type from the Burger.
     * @param theType an ingredient to remove.
     */
    public void removeIngredient(final String theType) {
        final MyStack<String> tempStack = new MyStack<>();
        if (isCheese(theType)) {
            while (!myCheeseStack.isEmpty()) {
                final String item = myCheeseStack.pop();
                if (!theType.equals(item)) {
                    tempStack.push(item);
                }
            }
            while (!tempStack.isEmpty()) {
                myCheeseStack.push(tempStack.pop());
            }
        } else {
            while (!myTopStack.isEmpty()) {
                final String item = myTopStack.pop();
                if (!theType.equals(item)) {
                    tempStack.push(item);
                }
            }
            while (!tempStack.isEmpty()) {
                myTopStack.push(tempStack.pop());
            }
            while (!myBottomStack.isEmpty()) {
                final String item = myBottomStack.pop();
                if (!theType.equals(item)) {
                    tempStack.push(item);
                }
            }
            while (!tempStack.isEmpty()) {
                myBottomStack.push(tempStack.pop());
            }
        }
    }
    
    
    /**
     * Converts the Burger to a String for display. 
     * @return String representation of the Burger.
     */
    public String toString() {
        myBottomStack.push(myPattyType);
        while (!myCheeseStack.isEmpty()) {
            myBottomStack.push(myCheeseStack.pop());
        }
        if (myPattyCount == 2) {
            myBottomStack.push(myPattyType);
        } else if (myPattyCount == 3) {
            myBottomStack.push(myPattyType);
            myBottomStack.push(myPattyType);
        }
        while (!myTopStack.isEmpty()) {
            myBottomStack.push(myTopStack.pop());
        }
        return myBottomStack.toString(); 
    }
}
