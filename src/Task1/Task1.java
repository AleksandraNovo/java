package src.Task1;

public class Task1 {

  public static void main(String[] args){
    IntSequence firstIntSequence = IntSequence.of(1, 2, 3);
    while (firstIntSequence.hasNext()){
      System.out.println(firstIntSequence.next());
    }
    IntSequence secondIntSequence = IntSequence.constant(1);
    while (secondIntSequence.hasNext()) {
      System.out.println(secondIntSequence.next());
    }
  }
}