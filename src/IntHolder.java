package src;

import java.util.Objects;

public class IntHolder {
    private int value;

    // Конструктор
    public IntHolder(int value1) {
        this.value = value1;
    }

    // Статический метод инициализации
    public static IntHolder valueOf(int value) {
        return new IntHolder(value);
    }

    // Методы для арифметических операций
    public IntHolder add(IntHolder other) {
        return new IntHolder(this.value + other.value);
    }

    public IntHolder subtract(IntHolder other) {
        return new IntHolder(this.value - other.value);
    }

    public IntHolder multiply(IntHolder other) {
        return new IntHolder(this.value * other.value);
    }

    public IntHolder divide(IntHolder other) {
        if (other.value == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return new IntHolder(this.value / other.value);
    }

    public IntHolder remainder(IntHolder other) {
        return new IntHolder(this.value % other.value);
    }

    // Метод для обмена значениями двух объектов
    public void swap(IntHolder j) {
        int temp = this.value;
        this.value = j.value;
        j.value = temp;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public boolean equals(IntHolder other) {
        if (this.value == other.value) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}