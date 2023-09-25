package src;

public class Homework2 {
    public static void main(String[] args) {
        /*
        IntHolder IntHolderFirst = IntHolder.valueOf(4175);
        IntHolder IntHolderSecond = IntHolder.valueOf(5);
        System.out.println(IntHolderFirst.addition(IntHolderSecond));
        System.out.println(IntHolderFirst.subtraction(IntHolderSecond));
        System.out.println(IntHolderFirst.multiplication(IntHolderSecond));
        //System.out.println(i1.division(i2));
        System.out.println(IntHolderFirst.percent(IntHolderSecond));
        IntHolderFirst.swap(IntHolderSecond);
        System.out.println(IntHolderFirst);
        System.out.println(IntHolderSecond);
        System.out.println(IntHolderFirst.equals(IntHolderSecond));
        System.out.println(IntHolderFirst.hashCode());
        System.out.println(IntHolderSecond.hashCode());*/

        /*
        Point p = new Point(3, 4);
        System.out.println(p);
        System.out.println(p.giveX());
        System.out.println(p.giveY());
        System.out.println(p.moving(1, 1));
        System.out.println(p.changes(2));*/

        Contact contact1 = new Contact("Alice", "alice@gmail.com");
        contact1.sayHello();
        Contact contact2 = new Contact("Bob");
        contact2.sayHello();
        System.out.println(contact1.EmailIsValid());


    }
    static boolean equals(String s, String t) {
        // проверить, что строки совпадают без учета регистра
        String sToDown = s.toLowerCase();
        String tToDown = t.toLowerCase();
        if (sToDown.equals(tToDown)) {
            return true;
        } else {
            return false;
        }
    }
    static String replace(String str, String oldStr, String newStr) {
        // в строке str все вхождения oldStr заменить на newStr
        return (str.replace(oldStr, newStr));
    }

    static String format(String surname, int mark, String subject) {
        // вернуть строку, используя форматирование: Студент [Фамилия] получил [оценка] по [предмету]
        return ("Студент " + surname + " получил " + mark + " по " + subject);
    }

    static boolean isPalindrome(String str) {
        // проверить, является ли строка палиндромом
        char[] mass = str.toCharArray();
        char[] mass2 = new char[mass.length];
        for (int i = mass.length - 1; i >= 0; i--) {
            mass2[i] = mass[mass.length - i - 1];
        }
        String massToStr = String.valueOf(mass);
        String mass2ToStr = String.valueOf(mass2);
        return (massToStr.equals(mass2ToStr));
    }
}

