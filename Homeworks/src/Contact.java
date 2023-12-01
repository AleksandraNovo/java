public record Contact(String name, String email) {
    public Contact(String name, String email) {
        if (name == null || name.isEmpty()) {
            System.out.println("Ошибка в имени пользователя и адресе почты!");
            throw new IllegalArgumentException("Invalid arguments for Contact");
        } else if (email == null || !isValidEmail(email)) {
            System.out.println("Ошибка адреса электронной почты!");
            throw new IllegalArgumentException("Invalid arguments for Contact");
        }    
        this.name = name;
        this.email = email;
    }
    }    

    private static boolean EmailIsValid(String email) {
        if (!email.contains("@gmail.com")) {
            //throw new IllegalArgumentException("Error");
            return false;
        }
        return true;
    }
    public void sayHello() {
        System.out.println("Hello, " + name + "!");
    }
}
