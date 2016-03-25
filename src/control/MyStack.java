/*
 * TCSS 342: Project 1 - Burger Baron
 * MyStack Class
 */

package control;

import java.util.EmptyStackException;

/**
 * Implementation of a Stack for the BurgerBaron project. Stacks are FILO (First-in-Last-out).
 * @param <E> the object to hold in this collection.
 * @author Austin Ingraham
 * @version 20 January 2016
 */
public final class MyStack<E> {

    /** The top of the Stack. */
    private StackElement<E> myTop;
    
    /** Tracks the total number of items are in this Stack. */
    private int myCounter;
    
    /** Constructs an empty stack. */
    public MyStack() {
        myCounter = 0;
    }
    
    /**
     * Places a new element onto the top of the Stack.
     * @param theElement - the item to add.
     */
    public void push(final E theElement) {
        if (myCounter == 0) {
            myTop = new StackElement<E>(theElement);
        } else {
            final StackElement<E> newTop = new StackElement<>(theElement, myTop);
            myTop = newTop;
        }
        myCounter++;
    }
    
    /**
     * Returns if this collection is empty.
     * @return boolean true if empty.
     */
    public boolean isEmpty() {
        return myCounter == 0;
    }
    
    /**
     * Returns the current size of this collection.
     * @return int number of elements.
     */
    public int size() {
        return myCounter;
    }
    
    /**
     * Removes the element at the top of this Stack and returns it.
     * @return the topmost element, AKA the most recently added item.
     * @throws EmptyStackException if this Stack is empty.
     */
    public E pop() {
        if (myCounter == 0) {
            throw new EmptyStackException();
        }
        
        final E result = myTop.getItem();
        final StackElement<E> newTop = myTop.getNext();
        myTop = newTop;
        
        myCounter--;
        return result;
    }
    
    /**
     * Looks at and returns the top element of this Stack without altering the Stack.
     * @return the top element of the Stack.
     * @throws EmptyStackException if this Stack is empty.
     */
    public E peek() {
        if (myCounter == 0) {
            throw new EmptyStackException();
        } 
        return myTop.getItem();
    }
    
    /** Empties this stack. */
    public void clear() {
        while (myCounter != 0) {
            pop();
        }
    }
    
    /**
     * Returns a string representation of this Stack.
     * @return String a string representation of this collection.
     */ 
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(40);
        sb.append('[');
        if (myCounter > 0) {
            toStringHelper(sb, myTop);
        }
        sb.append(']');
        return sb.toString(); 
    }
    
    /**
     * Private helper method to iterate through the Stack elements and build a string.
     * @param theB a StringBuilder to append elements to.
     * @param theE the StackElement to iterate on.
     */
    private void toStringHelper(final StringBuilder theB, final StackElement<E> theE) {
        theB.append(theE.getItem());
        if (!theE.isLast()) {
            theB.append(", ");
            toStringHelper(theB, theE.getNext());
        }
    }
    
    
    /**
     * One item block of the stack.
     * @param <T> the object held in this collection.
     * @author Austin Ingraham
     * @version 20 January 2016
     */
    private final class StackElement<T> {
        
        /** The item held by this StackElement. */
        private final T myItem;
        
        /** The next StackElement. */
        private StackElement<T> myNext;
        
        /** A boolean indicator that this is the last element of a Stack. */
        private final boolean myLast;
        
        /** 
         * Creates a StackElement which will be the bottom of the Stack. 
         * @param theElement the item to add.
         */
        StackElement(final T theElement) {
            myItem = theElement;
            myLast = true;
        }
        
        /** 
         * Creates a StackElement which points to another StackElement. 
         * @param theElement the item to add.
         * @param theNext the next StackElement in the chain. 
         */
        StackElement(final T theElement, final StackElement<T> theNext) {
            myItem = theElement;
            myNext = theNext;
            myLast = false;
        }
        
        /** 
         * Returns true if this is the last StackElement in this chain.
         * @return boolean true if this is the last.
         */
        public boolean isLast() {
            return myLast;
        }
        
        /**
         * Returns the next StackElement in this chain.
         * @return the next StackElement.
         */
        public StackElement<T> getNext() {
            return myNext;
        }
        
        /** 
         * Returns the item which is being held in this StackElement.
         * @return the item being held.
         */
        public T getItem() {
            return myItem;
        }
    }
}
