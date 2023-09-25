package src;

public record Contact(String name, String email) {
    //private string email = email;
    public Contact {
        if (name == null || email == null || name.isEmpty()) {
            throw new IllegalArgumentException("Error");
        }
    }
    //public static int giveEmail() {
    //    return email;
    //}
    public Contact(String name) {
        this(name, "non@gmail.com");
    }

    private static boolean EmailIsValid(String email) {
        if (!email.contains("@gmail.com")) {
            //throw new IllegalArgumentException("Error");
            return false;
        }
        return true;
    }
        //String domain = email.substring(email.indexOf("@"));
        //return "@gmail.com".equals(domain);


    public void sayHello() {
        System.out.println("Hello, " + name + "!");
    }


}
