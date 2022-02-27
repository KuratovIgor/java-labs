package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.in;

public class Main {

    static int[] arr;

    public static void main(String[] args) {
        arr = new int[] {5, 6, 7, 8, 9, 11};

       // for (int i = 0; i < arr.length; i++){
         //   arr[i] = 524287;
        //}

        //StartConsistentSolution();
       // StartThreadSolution();
        StartParallelStreamSolution();
    }

    private static void StartConsistentSolution(){
        ConsistentSolution.Start(new int[] {1, 3, 5, 7, 9});
    }

    //for thread
    private static void StartThreadSolution(){
        List<int[]> arrays = DivideArray(arr, 3);

        for (var item: arrays) {
            Thread thread = new Thread(new ThreadSolution(item));
            thread.start();
        }
    }
    ///////////

    //for ParallelStream
    private static void StartParallelStreamSolution() {
        List<int[]> arrays = DivideArray(arr, 3);

        for (var item: arrays){
            Arrays.parallelSetAll(arr, k -> {
                for (int i = k; i < arr.length; i++){
                    for (int j = 2; j < arr[i]; j++){
                        if (arr[i] % j == 0){
                            arr[i] = 0;
                            return arr[i];
                        }
                    }
                }

                return arr[0];
            });
         }
    }
    //////

    private static List<int[]> DivideArray(int[] arr, int countStream){
        List<int[]> arrays = new LinkedList<int[]>();

        if (countStream <= arr.length){
            int lengthNewArray = (int)Math.ceil((double)arr.length / (double)countStream);

            int i = 0;

            for(int a = 0; a < countStream; a++){
                int[] newArr = new int[lengthNewArray];

                for(int j = 0; j < newArr.length; j++){
                    try{
                        newArr[j] = arr[i];
                        i++;
                    }
                    catch (Exception e) {
                        newArr[j] = 3;
                    }
                }

                arrays.add(newArr);
            }

            return arrays;
        }

        return null;
    }
}
