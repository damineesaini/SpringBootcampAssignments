package com.introduction.spring.IntroductionToSpring;

public class BinarySearchTightCoupled {

    public boolean search(int[] array, int searchElement){

        InsertionSortTightCoupled insertionSort = new InsertionSortTightCoupled();
        insertionSort.sort(array);
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
