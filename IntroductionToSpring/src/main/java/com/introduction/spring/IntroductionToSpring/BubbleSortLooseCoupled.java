package com.introduction.spring.IntroductionToSpring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BubbleSortLooseCoupled implements SortAlgorithm{

    public int[] sort(int[] numbers)
    {
        System.out.println("Using bubble sort for sorting array");
        int n = numbers.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (numbers[j] > numbers[j+1])
                {
                    // swap numbers[j+1] and numbers[j] 
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
        return numbers;
    }
}
