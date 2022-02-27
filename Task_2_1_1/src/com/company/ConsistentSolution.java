package com.company;

public class ConsistentSolution {
    private static int [] _arrayOfNumbers;

    public static void Start(int[] mas){
        FillArray(mas);
        System.out.println(IsNotPrimeNumberExists());
    }

    private static void FillArray(int[] mas){
        _arrayOfNumbers = new int[mas.length];

        for (int i = 0; i < mas.length; i++){
            _arrayOfNumbers[i] = mas[i];
        }
    }

    private static boolean IsNotPrimeNumberExists(){
        for (int i = 0; i < _arrayOfNumbers.length; i++){
            for (int j = 2; j < _arrayOfNumbers[i]; j++){
                if (_arrayOfNumbers[i] % j == 0)
                    return true;
            }
        }

        return false;
    }
}
