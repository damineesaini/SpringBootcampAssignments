package com.introduction.spring.IntroductionToSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchLooseCoupled  {

    private String alterName;
    private String timeComplexity;
    private SortAlgorithm sortAlgorithm;

    @Autowired
    public BinarySearchLooseCoupled(SortAlgorithm sortAlgorithm) {
        System.out.println("Constructor called of BinarySearchLooseCoupled");
        this.sortAlgorithm = sortAlgorithm;
        this.alterName = "half-interval search";
        this.timeComplexity = "O(logn)";
    }

    public String getAlterName() {
        return alterName;
    }

    public String getTimeComplexity(){
        return timeComplexity;
    }

    public boolean getSearchElement(int[] array, int searchElement){
        sortAlgorithm.sort(array);
        System.out.println("Performing binary search");
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
