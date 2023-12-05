package src.Task1;

public interface IntSequence {

  boolean hasNext();

  int next();

  public static IntSequence of(int ...v){
    return new IntSequence() {
      int index = 0;
      @Override
      public boolean hasNext(){

        if (index >= v.length){
          return false;
        } else {
          return  true;
        }
      }

      @Override
      public int next(){
        if (index < v.length){
          return v[index++];
        } else {
          System.out.println("Ошибка: выход за границы массива.");
          return 0;
        }
      }
    };
  }

  public static IntSequence constant(int constanta) {
    return new IntSequence() {

      public boolean hasNext() {
        return true;
      }

      @Override
      public int next() {
        return constanta;
      }
    };
  }

}
