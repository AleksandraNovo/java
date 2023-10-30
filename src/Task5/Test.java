package src.Task5;

public class Test {

  public static boolean checkPassword(String login, String password, String confirmPassword) {

    try {
      if (!login.matches("[A-Za-z0-9_]+")) {
        throw new WrongLoginException("Логин содержит недопустимые символы");
      }
      if (login.length() >= 20) {
        throw new WrongLoginException("Длина логина превышает ограничение");
      }

      if (!password.matches("[A-Za-z0-9_]+")) {
        throw new WrongPasswordException("Пароль содержит недопустимые символы");
      }
      if (password.length() >= 20) {
        throw new WrongPasswordException("Длина пароля превышает ограничение");
      }
      if (!password.equals(confirmPassword)) {
        throw new WrongPasswordException("Пароль не совпадает с подтверждением");
      }
    } catch (NullPointerException e) {
      System.out.println(e.getMessage());
      return false;
    } catch (WrongLoginException e) {
      System.out.println(e.getMessage());
      return false;
    } catch (WrongPasswordException e) {
      System.out.println(e.getMessage());
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(checkPassword("jhijsdfsgdjf", "password1", "password1"));
  }
}
