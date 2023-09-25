package src;

import java.math.BigInteger;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Red", 500, "Toyota", 50);
        car.info();

        car.move();
        car.info();

        car.stopEngine();
        car.refuel(200);
        car.info();

        car.startEngine();
        car.move();
        car.info();
    }
    public static void convert(int arg) {
        //if (arg >= 0) {
        String a = Integer.toString(arg, 2);
        String b = Integer.toString(arg, 8);
        String c = Integer.toString(arg, 16);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        /*}else{
            int n = -arg;
            String a = Integer.toString(arg, 2);
            String b = Integer.toString(arg, 8);
            String c = Integer.toString(arg, 16);
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }*/
    }
    static int normalize(int angle) {
        int n = angle % 360;
        if (n < 0){
            n = 360 + n;
        }
        return n;
    }
    static int max(int x, int y, int z) {
        int n = Math.max(x, y);
        n = Math.max(n, z);
        System.out.println(n);
        return 0;
    }
    static int fact(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
    static BigInteger fact(BigInteger n) {
        if (n.equals(BigInteger.ONE)) { //equals о же самое что и =, если н равно один - вернуть н
            return n;
        }
        return n.multiply(fact(n.subtract(BigInteger.ONE))); // multiply = *
    }
    static void multiplTable() {
        for (int i = 0; i <= 10; i++){
            for (int j = 0; j <= 10; j++){
                int p = i * j;
                System.out.println(i+"*"+j+"="+p);

            }
        }
    }
    static int average(int... nums) {
        int sum = 0;
        for (int i: nums){
            sum += i;
        }
        return (sum/nums.length);
    }
    static int[] reverse(int[] arr) {
        int[] reverse_arr = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            reverse_arr[i] = arr[arr.length - i - 1];
        }
        return reverse_arr;
    }
    static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i]>arr[j]){
                    int a = arr[i];
                    arr[i]=arr[j];
                    arr[j]=a;
                }
            }
        }
        return arr;
    }
    static int[] removeExtra(int[] arr, int n) {
        return Arrays.stream(arr).filter(i -> i != n).toArray();
    }
    static boolean isMagicSquare(int[][] square) {
        int len = square[0].length;
        int d1 = 0, d2 = 0;
        boolean flag = true;
        for (int i = 0; i < len; i++){
            d1 += square[i][i];
            d2 += square[i][len- i - 1];
        }
        if (d1 != d2){
            return false;
        }
        for (int i = 0; i < len; i++){
            int str = 0, stl = 0;
            for (int j = 0; j < len; j++){
                str += square[i][j];
                stl += square[j][i];
            }
            if (str != d1 || stl != d2){
                return false;
            }
        }
        return true;
    }
    static int binary(int[] n, int value, int l, int r){
        if (l==r){
            return -1;
        }
        int mid = (l + r) / 2;
        if (value == n[mid]){
            return mid;
        }
        if (value < n[mid]){
            return binary(n, value, l, mid - 1);
        }else{
            return binary(n, value, mid, r);
        }
    }

}
