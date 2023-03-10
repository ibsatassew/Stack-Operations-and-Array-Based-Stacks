/** 
    Modified from source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

/** Array-based stack implementation */
class AStack<E> implements Stack<E> {

  private static final int defaultSize = 10;

  private int maxSize;            // Maximum size of stack
  private int top;                // Index for top Object
  private E [] listArray;         // Array holding stack

  /** Constructors */
  AStack() { this(defaultSize); }
  @SuppressWarnings("unchecked") // Generic array allocation
  AStack(int size) {
    maxSize = size;
    top = 0; 
    listArray = (E[])new Object[size];   // Create listArray
  }

  /** Reinitialize stack */
  public void clear() { top = 0; }

  /** Push "it" onto stack */
  public void push(E it) {
    if(top == maxSize){
    	maxSize = maxSize*2;
    	E[] newListArray = (E[])new Object[maxSize];
    	for(int i = 0; i<top; i++){
    		newListArray[i] = listArray[i];
    	}
    	listArray = newListArray;
    }
    listArray[top++] = it;
    
  }

  /** Remove and top element */
  public E pop() {
    assert top != 0 : "Stack is empty";
    return listArray[--top];
  }

  /** @return Top element */
  public E topValue() {
    assert top != 0 : "Stack is empty";
    return listArray[top-1];
  }

  /** @return Stack size */
  public int length() { return top; }

  /** reverses the order of items on stack */
  public void reverse() {
  AStack auxStack = new AStack(top);
	for(int i = 0; i<top; i++){
		auxStack.push(listArray[i]);
	}
	
  for(int i = 0; i<top; i++){
     		E item = (E)auxStack.pop();
     		listArray[i] = item;
     	}
  }
  

  /** @return a deep copy of this stack */
  public AStack<E> deepcopy() {
	AStack auxStack = new AStack(top);
	for(int i = 0; i<top; i++){
		auxStack.push(listArray[i]);
	}
	
     return auxStack; // should return a deep copy
  }

  /**
   * Generate a human-readable representation of this stack's contents
   * that looks something like this: < 1 2 3 >.
   * This method uses toString() on the individual elements.
   * @return The string representation of this stack
   */
  public String toString()
  {
    StringBuffer out = new StringBuffer((length() + 1) * 4);
    out.append("top < ");
    for (int i = top-1; i >= 0; i--) {
      out.append(listArray[i]);
      out.append(" ");
    }
    out.append(">");
    return out.toString();
  }
}
