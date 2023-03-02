public class StackTest
{
  public static void main(String[] args) {
    AStack<Integer> S1 = new AStack<Integer>(5); /* A tiny stack */
                                                 /* Do not change the size */
    /* fill the stack */
    for (int i = 0; i < 5; i++)
       S1.push(i);
    System.out.println("S1: " + S1);

    /* stack overflow - should work after modifying the push() method */
    for (int i = 6; i < 30; i++)
       S1.push(i);
    System.out.println("S1: " + S1);

    /* reverse the order */
    S1.reverse();
    System.out.println("S1: " + S1);

    /* make a deep copy */
    AStack<Integer> S2 = S1.deepcopy();
    System.out.println("S1: " + S1);
    System.out.println("S2: " + S2);
  }
}
