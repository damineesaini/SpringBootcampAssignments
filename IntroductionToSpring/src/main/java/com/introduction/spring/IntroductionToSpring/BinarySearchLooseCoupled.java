package com.introduction.spring.IntroductionToSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchLooseCoupled  {


    private SortAlgorithm sortAlgorithm;

    @Autowired
    public BinarySearchLooseCoupled(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public boolean getSearchElement(int[] array, int searchElement){

        int first = 0 ,last = array.length - 1;
        int middle = (first + last)/2;

        while( first <= last )
        {
            if ( array[middle] < searchElement )
                first = middle + 1;
            else if ( array[middle] == searchElement )
            {
                break;
            }
            else
            {
                last = middle - 1;
            }
            middle = (first + last)/2;
        }
        if ( first > last )
        {
            System.out.println(searchElement + " is not found.\n");
            return false;
        }


        return true;
    }
}
