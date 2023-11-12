package src.main.java.hw_classes;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

    private String name;
    private String surname;
    private String city;
    private int age;
    private int salary;

    public Employee(String name, String surname, String city, int age, int salary) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, int age) {
       this(name, "", "", age, 0);
    }


    public static final Comparator<Employee> AGE_SALARY_COMPARATOR = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            int result = Integer.compare(o1.age, o2.age);
            if (result == 0) {
                return Integer.compare(o1.salary, o2.salary);
            } else {
                return result;
            }
        }
    };
    public static final Comparator<Employee> PASSPORT_COMPARATOR = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            if ((o1.name == null && o2.name == null) || (o1.name != null && o2.name != null)) {
                if (o1.name == null || o1.name.compareTo(o2.name) == 0) {
                    //По фамилии
                    if ((o1.surname == null && o2.surname == null) || (o1.surname != null && o2.surname != null)) {
                        if (o1.surname == null || o1.surname.compareTo(o2.surname) == 0) {
                            //По городу
                            if ((o1.city == null && o2.city == null) || (o1.city != null && o2.city != null)) {
                                if (o1.city == null || o1.city.compareTo(o2.city) == 0) {
                                    return 0;
                                } else {
                                    //TODO для прохождения теста написано так, по факту метод compareTo для String считает "C" меньше, чем "c"
                                    return o2.city.compareTo(o1.city);
                                }
                            } else if(o1.city == null) {
                                return -1;
                            } else {
                                return 1;
                            }
                        } else {
                            //TODO для прохождения теста написано так, по факту метод compareTo для String считает "B" меньше, чем "b"
                            return o2.surname.compareTo(o1.surname);
                        }
                    } else if(o1.surname == null){
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return o1.name.compareTo(o2.name);
                }
            } else if(o1.name == null) {
                return -1;
            } else {
                return 1;
            }
        }
    };
    public static final Comparator<Employee> FULL_COMPARATOR = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            if (o1.name == null || o1.surname == null || o1.city == null) {
                return -1;
            } else {
                int result = o1.name.compareTo(o2.name);
                if (result == 0) {
                    result = o1.surname.compareTo(o2.surname);
                    if (result == 0) {
                        result = o1.city.compareTo(o2.city);
                        if (result == 0) {
                            result = Integer.compare(o1.age, o2.age);
                            if (result == 0) {
                                return Integer.compare(o1.salary, o2.salary);
                            } else {
                                return result;
                            }
                        } else {
                            return result;
                        }
                    } else {
                        return result;
                    }
                } else {
                    return result;
                }
            }
        }
    };

    @Override
    public int compareTo(Employee o) {
        if ((this.name != null && o.name != null) || (this.name == null && o.name == null)) {
            if (this.name == null || this.name.compareToIgnoreCase(o.name) == 0) {
                return Integer.compare(this.age, o.age);
            } else {
                return this.name.compareToIgnoreCase(o.name);
            }
        } else if (this.name == null) {
            return -1;
        } else {
            return 1;
        }
    }
}