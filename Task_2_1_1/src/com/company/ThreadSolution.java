package com.company;

public class ThreadSolution implements Runnable {
    private int [] _arrayOfNumbers;

    public void run(){
        System.out.println(IsNotPrimeNumberExists());
    }

    public ThreadSolution(int[] mas){
        FillArray(mas);
    }

    public void FillArray(int[] mas){
        _arrayOfNumbers = new int[mas.length];

        for (int i = 0; i < mas.length; i++){
            _arrayOfNumbers[i] = mas[i];
        }
    }

    private boolean IsNotPrimeNumberExists(){
        for (int i = 0; i < _arrayOfNumbers.length; i++){
            for (int j = 2; j < _arrayOfNumbers[i]; j++){
                if (_arrayOfNumbers[i] % j == 0)
                    return true;
            }
        }

        return false;
    }
}
