package src.Task5;

public class WrongPasswordException extends Exception{

  WrongPasswordException() {

  }

  WrongPasswordException(String message) {
    super(message);
  }
}
