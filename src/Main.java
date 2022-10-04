

import jdk.jshell.execution.StreamingExecutionControl;

import java.util.*;


public class Main {

    @FunctionalInterface
    interface IfMethod{
        boolean check(int value);
    }

    @FunctionalInterface
    interface ChangeFunction{
       int change(int value);
    }
    public  static void main(String[] args) {

        int[] nums = new int[] { 4, 55, 23, 64, 131, 643, 52, 6};
        IfMethod ifMethod = (value) -> value > 0;

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(35);
        list.add(24);


        int[] testResult = Arrays.stream(nums)
                .map(v -> v * -1)
                .sorted()
                .map(v -> v * -1)
                .toArray();

        List<Integer> resultList = list.stream()
                .filter((v) -> v > 0)
                .toList();

        list.forEach(System.out::println);
        OptionalInt result = Arrays.stream(nums)
                .filter(value -> value == 55)
                .findFirst();

        if (result.isPresent())
            result.getAsInt();

        int[] resultArray = Arrays.stream(nums)
                .filter(v -> v > 0).limit(10)
                .toArray();

        int [] result1 = Arrays.stream(nums)
                .filter(((value) -> value > 100))
                .toArray();

        int [] result2 = Arrays.stream(nums)
                .map((v) -> v * 3)
                .filter((value) -> value % 2 == 0)
                .toArray();

        int[] filteredArray = filter(nums, (value -> value > 0));
        int[] filteredArray2 = filter(nums, Main::even);

        int[] resultTest = change(nums, (value -> value*3));
    }

    public static int[] change(int [] array, ChangeFunction function){
        int[] result = new int [array.length];
        for (int i= 0; i < array.length; i++)
            result[i] = function.change(array[i]);
        return result;
    }


    public static int[] filter(int[] array, IfMethod ifMethod){

        int[] result = new int [array.length];
        for (int i= 0; i < array.length; i++){
            if (ifMethod.check(i))
                result[i] = array[i];
        }
        return result;
    }


    public static void writer(int[] array){
        for (int i: array);
            System.out.println();
    }


    public static boolean chechPositive(int value){
        return value > 0;
    }

    public static boolean even(int value){
        return value % 2 == 0;
    }
}
