package src;

import java.util.Objects;

public class IntHolder {
    private int value;

    public IntHolder(int valueIntHolder) {
        this.value = valueIntHolder;
    }

    public static IntHolder valueOf(int valueIntHolder) {
        return new IntHolder(valueIntHolder);
    }

    // Методы для арифметических операций
    public IntHolder addition(IntHolder other) {
        return new IntHolder(this.value + other.value);
    }

    public IntHolder subtraction(IntHolder other) {
        return new IntHolder(this.value - other.value);
    }
    /*public IntHolder division(IntHolder other) {
        if (other.value != 0) {
            return new IntHolder(this.value / other.value);
        }
        return ("Error");
    }*/
    public IntHolder multiplication(IntHolder other) {
        return new IntHolder(this.value * other.value);
    }

    public IntHolder remainder(IntHolder other) {
        return new IntHolder(this.value % other.value);
    }

    public void swap(IntHolder i) {
        int swap1 = this.value;
        this.value = i.value;

        i.value = swap1;
    }


    public String toString1() {
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