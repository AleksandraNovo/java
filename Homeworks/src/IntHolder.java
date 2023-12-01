import java.util.Objects;

public class IntHolder {
    private int value;
    public String toString() {
        return String.valueOf(value);
    }

    public IntHolder(int valueIntHolder) {
        this.value = valueIntHolder;
    }

    public static IntHolder valueOf(int valueIntHolder) {
        return new IntHolder(valueIntHolder);
    }


    public void IntHolder add(IntHolder other) {
        this.value += other.value;
    }

    public void IntHolder subtraction(IntHolder other) {
        this.value -= other.value;
    }
    public IntHolder division(IntHolder other) {
        if (other.value == 0) {
          throw new IllegalArgumentException("Делить на ноль нельзя!");
        }
        this.value = this.value / other.value;
    }
    public void IntHolder multiplication(IntHolder other) {
        this.value = this.value * other.value;
    }

    public void IntHolder percent(IntHolder other) {
        this.value = this.value % other.value);
    }

    public void swap(IntHolder i) {
        int swap1 = this.value;
        this.value = i.value;

        i.value = swap1;
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
