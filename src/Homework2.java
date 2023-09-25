package src;

public class Homework2 {
    // Пример использования
    /*public static void main(String[] args) {
        IntHolder i1 = IntHolder.valueOf(4177481);
        IntHolder i2 = IntHolder.valueOf(5);

        System.out.println(i1.add(i2)); // 15
        System.out.println(i1.subtract(i2)); // 5
        System.out.println(i1.multiply(i2)); // 50
        System.out.println(i1.divide(i2)); // 2
        System.out.println(i1.remainder(i2)); // 0

        i1.swap(i2);
        System.out.println(i1); // 5
        System.out.println(i2); // 10
        System.out.println(i1.equals(i2));
        System.out.println(i2.hashCode());
    }*/
    public static void main(String[] args) {
        Point p = new Point(3, 4);
        System.out.println(p); // Point(3.0, 4.0)

        p = p.translate(1, 1);
        System.out.println(p); // Point(4.0, 5.0)

        p = p.scale(2);
        System.out.println(p); // Point(8.0, 10.0)
    }
}
    /*static boolean equals(String s, String t) {
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
    }*/

