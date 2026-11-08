QUESTION 1:

package s;

public class ExpandableStack {

    private char[] elements;
    private int count;

    public ExpandableStack() {
        elements = new char[2];
        count = 0;
    }

    // Creates a bigger array and copies the elements
    private void expand() {

        System.out.println("Stack is full; its current size is " + count);

        int newSize = elements.length * 4;

        System.out.println("Will be expanding the size to " + newSize);

        char[] biggerArray = new char[newSize];

        for (int i = 0; i < elements.length; i++) {
            biggerArray[i] = elements[i];
        }

        elements = biggerArray;
    }

    // Adds a character to the stack
    public void push(char value) {

        if (count >= elements.length) {
            expand();
        }

        elements[count] = value;
        count++;
    }

    // Removes and returns the top character
    public char pop() {

        if (isEmpty()) {
            System.out.println("Stack is empty");
            return ' ';
        }

        int lastPosition = count - 1;
        char removed = elements[lastPosition];

        count--;

        return removed;
    }

    // Returns the top character without removing it
    public char top() {

        if (isEmpty()) {
            System.out.println("Stack is empty");
            return ' ';
        }

        int lastPosition = count - 1;

        return elements[lastPosition];
    }

    // Returns the current number of elements
    public int size() {
        return count;
    }

    // Checks whether the stack is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Checks whether the stack is full
    public boolean isFull() {
        return count >= elements.length;
    }
}

