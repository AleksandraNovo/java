package src.Task5;

public class WrongLoginException extends Exception {

  WrongLoginException() {

  }

  WrongLoginException(String message) {
    super(message);
  }
}
