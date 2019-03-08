package cn.com.zut;

public class TestDemo {

    public static double average(int []array) {
        double sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }
    public static void main(String []args) {
        int []array = {1, 2, 3};
        System.out.println(average(array));

    }
}
