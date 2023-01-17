package LA2Q1;

import javax.imageio.stream.FileImageInputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class DasolTestingSortingMethods {

    public static void main (String args[]){
        //calling the static myHeader method
        myHeader(2, 1);

        //preset array size reference variables
        int sz = 5;
        Integer size = 5;
        long activateTime, executeTime, totalTime;

        //creating a Integer type array with size 5
        Integer[] firstArray = new Integer[sz];

        //copying the first array to secondArray
        Integer[] secondArray =  new Integer[sz];

        //populating array with Math.random, range 13-93
        for(int i = 0; i < sz; i++){
            firstArray[i] = (int)(13+(Math.random()*(94-13)));
        }

        System.arraycopy(firstArray,0,secondArray,0,firstArray.length);

        //creating a List with above Integer Array
        List<Integer> intArrayList = Arrays.asList(firstArray);

        //sorting firstArray using Collection sort method
        activateTime = System.nanoTime();                                   //active time
        Collections.sort(intArrayList);
        executeTime = System.nanoTime();                                    //execute time
        totalTime = executeTime - activateTime;                             //total time for main iterative method
        Collections.sort(intArrayList);
//        System.out.printf("Testing execution time of different sorting methods for sorting 5 random numbers: \n");
//        System.out.println("The unsorted list: " + Arrays.asList(secondArray));
        System.out.printf("Collection's Sorting Time: %.2f milliseconds\n",totalTime/1000000.00);
//        System.out.println("The sorted list using Collections' sort methods: " + intArrayList.toString());

        //copying the backup array, second array, to the first array
        System.arraycopy(secondArray,0,firstArray,0,secondArray.length);
//        System.out.println("\nThe unsorted list: " + Arrays.asList(firstArray));
        System.out.printf("Selection-Sort Time: %.2f milliseconds\n",selectionSort(firstArray)/1000000.00);
//        System.out.println("The sorted list with selection-sort: " + intArrayList.toString());

        //copying the backup array, second array, to the first array
        System.arraycopy(secondArray,0,firstArray,0,secondArray.length);
//        System.out.println("\nThe unsorted list: " + Arrays.asList(firstArray));
        System.out.printf("Bubble-Sort Time: %.2f milliseconds\n",bubbleSort(firstArray)/1000000.00);
//        System.out.println("The sorted list with Bubble-sort: " + intArrayList.toString());

        //copying the backup array, second array, to the first array
        System.arraycopy(secondArray,0,firstArray,0,secondArray.length);
//        System.out.println("\nThe unsorted list: " + Arrays.asList(firstArray));
        System.out.printf("Insertion-Sort Time: %.2f milliseconds\n",insertionSort(firstArray)/1000000.00);
//        System.out.println("The sorted list with Insertion-sort: " + intArrayList.toString());

        //copying the backup array, second array, to the first array
        System.arraycopy(secondArray,0,firstArray,0,secondArray.length);
//        System.out.println("\nThe unsorted list: " + Arrays.asList(firstArray));
        System.out.printf("Merge-Sort Time: %.2f milliseconds\n",mergeSort(firstArray)/1000000.00);
//        System.out.println("The sorted list with Merge-sort: " + intArrayList.toString());

        //copying the backup array, second array, to the first array
        System.arraycopy(secondArray,0,firstArray,0,secondArray.length);
//        System.out.println("\nThe unsorted list: " + Arrays.asList(firstArray));
        System.out.printf("Quick-Sort Time: %.2f milliseconds\n",quickSort(firstArray, 0, firstArray.length-1)/1000000.00);
//        System.out.println("The sorted list with Quick-sort: " + intArrayList.toString());

        //copying the backup array, second array, to the first array
        System.arraycopy(secondArray,0,firstArray,0,secondArray.length);
//        System.out.println("\nThe unsorted list: " + Arrays.asList(firstArray));
        System.out.printf("Bucket-Sort Time: %.2f milliseconds\n",(bucketSort(firstArray, 0, firstArray.length-1, 2))/10000000.00);
//        System.out.println("The sorted list with Bucket-sort: " + intArrayList.toString());

        //calling the static myFooter method
        myFooter(2, 1);
    }
    //This is myHeader method containing my name and student number
    public static void myHeader(int assignnmentNum, int questionNum){
        System.out.println("=====================================================");
        System.out.printf("Lab Assignment %d-Q%d \n", assignnmentNum, questionNum);
        System.out.println("Prepared By: Dasol Lim");
        System.out.println("Student Number: 251224110");
        System.out.println("Goal of this Exercise: Use the insertion sorting method and compareTo method");
        System.out.println("");
        System.out.println("=====================================================");
    }
    //This is myFooter containing a good-bye message
    public static void myFooter(int assignnmentNum, int questionNum) {
        System.out.println("=====================================================");
        System.out.printf("Completion of Lab Assignment %d-Q%d is successful! \n", assignnmentNum, questionNum);
        System.out.println("Signing off - Dasol Lim");
        System.out.println("=====================================================");
    }

    public static <T extends Comparable<? super T>> long selectionSort(T[] a) {
        long activateTime = System.nanoTime();                                   //active time
        //iterative comparison
        //loop until the condition is satified
        for(int i =0; i<a.length;i++){
            //selects the smallest data item
            int nextSmallest = i;
            //locating the smallest index
            for(int j =i+1; j<a.length;j++){
                if(a[j].compareTo(a[nextSmallest])<0){
                    nextSmallest = j;
                    /*
                    (5,3,1,6)
                    5,3 swap 3,5 since 3 is the smallest
                    swap if the next number is smaller than before
                    3,5,1 swap 1 with 5 so 3,1,5
                    continue...
                     */
                }
            }
            //sorts list on the left end of the list and repeats until whole list is sorted
            //swapping the nextSmallest index by assigning it with outer index, i
            T temp = a[i];
            a[i]= a[nextSmallest];
            a[nextSmallest] = temp;
        }
        long executeTime = System.nanoTime();                                    //execute time
        long totalTime = executeTime - activateTime;                             //total time for main iterative method
        return totalTime;
    }
    public static <T extends Comparable<? super T>> long bubbleSort(T[] a) {
        long activateTime = System.nanoTime();                                   //active time
        //iterative comparison, comparing data-set from one end to other
        //first traversal step, find the largest array and becomes the last element
        //second, find the second large array and becomes the second last element
        for(int i = 1; i<a.length; i++){
            for(int j =0; j<a.length-i;j++){
                //compares adjacent pairs of elements
                //loops until one traversal step is done and does it until array length
                if(a[j].compareTo(a[j+1])>0){
                    /*
                    (6,5,3,1)
                    process of swapping 5 and 6 using bubble method
                    temp = 6
                    replace a[j] with 5
                    5 becomes the new temp
                    Next: compare 6 and 3
                     */
                    T temp= a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        long executeTime = System.nanoTime();                                    //execute time
        long totalTime = executeTime - activateTime;                             //total time for main iterative method
        return totalTime;
    }
    public static <T extends Comparable<? super T>> long insertionSort(T[] a) {
        long activateTime = System.nanoTime();                                   //active time
        //iterative sorting method, repeated until no input elements remain (conclude that its in correct order)
        //Insertion sort removes one element from the list and finds the best location and inserts it there
        int j = 0;
        for(int i = 1; i<a.length; i++){
            T key = a[i];
            //for generic implementation, we need to compare the objects using compareTo() method
            for(j = i-1; j>=0 && a[j].compareTo(key)>0; j--){
                a[j+1] = a[j];
                /*
                (6,5,3,1)
                iterate through and compare with the numbers before the comparing number
                finding the smallest and comparing
                6,5 swap 5 and 6
                5,6,3 swap 3 with 5 and 6
                3,5,6,1 swap 1 with 3,5, and 6
                 */
            }
            a[j+1] = key;
        }
        long executeTime = System.nanoTime();                                    //execute time
        long totalTime = executeTime - activateTime;                             //total time for main iterative method
        return totalTime;
    }
    public static <T extends Comparable<? super T>> long mergeSort(T[] S) {
        long activateTime = System.nanoTime();                                   //active time
        //Note: allowed to tweak the recursive merge-sort code given in Unit 4
        int n = S.length;
        //array is trivially sorted
        //if array has less than 2 elements, its sorted
        if (n<2) return 0;
        int mid = n/2;
        //dividing array into 2 to perform divide and conquer
        //copy of first half
        T[] a1 = Arrays.copyOfRange(S, 0, mid);
        //copy of second half
        T[] a2 = Arrays.copyOfRange(S, mid, n);
        //conquer with recursion
        //sort copy of first half, recursive sort
        mergeSort(a1);
        //sort copy of second half, recursive sort
        mergeSort(a2);
        //merge sorted halves back into original, conquer back the elements by concatenating
        int i =0, j=0;
        while (i+j<S.length){
            if(j==a2.length || (i<a1.length && a1[i].compareTo(a2[j])<0))
                //increment i
               S[i+j] = a1[i++];
            else
                //increment j
                S[i+j] = a2[j++];
        }
        long executeTime = System.nanoTime();                                    //execute time
        long totalTime = executeTime - activateTime;                             //total time for main iterative method
        return totalTime;
    }
    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a , int b) {
        long activateTime = System.nanoTime();                                   //active time
        //Note: can implement the in-place quick-sort give in Unit 4
        if (a >= b) return 0;
        //left pointer that will scan rightward
        int left = a;
        //right pointer that will scan leftward
        int right = b -1;
        //choosing a pivot, to partition the array about the pivot
        T pivot = s[b];
        //temp object used for swapping
        T temp;
        while(left <= right){
            //scan until reaching value equal or larger than pivot (right marker)
            while(left <= right && s[left].compareTo(pivot)<0)
                left++;
            //scan until reaching value equal or smaller than pivot (left marker)
            while(left <= right && s[right].compareTo(pivot)>0)
                right--;
            if(left <= right){
                //swapping values and shrinking range
                temp = s[left];
                s[left]= s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }
        //put pivot into its final place (currently marked by left index)
        temp = s[left];
        s[left] = s[b];
        s[b] = temp;
        //make recursive calls
        quickSort(s, a, left-1);
        quickSort(s, left+1, b);
        long executeTime = System.nanoTime();                                    //execute time
        long totalTime = executeTime - activateTime;                             //total time for main iterative method
        return totalTime;
    }
    public static long bucketSort(Integer[] a, int first,int last, int maxDigits){
        long activateTime = System.nanoTime();                                   //active time
        //this method is not generic because it is restricted for specific data
        //avoids comparison by creating and distributing elements into buckets
        //treats elements as if they were strings of the same length
        //group elements by a specific digit or character oof a string
        //placed into buckets based on the matching key

        //since the radix is 5, creating 5 buckets using Vector. Assumption: positive numbers only
        Vector<Integer>[] bucket = new Vector [10];
        //instantiate each bucket
        for(int i = 0;i<10;i++)
            bucket[i] = new Vector<>();
        for (int i = 0; i <maxDigits; i++){
            for(int j =0; j < 10; j++){
                bucket[j].removeAllElements();
            }
            //placing a[index] at end of bucket [digit]
            for(int index = first; index<=last; index++){
                Integer digit = findDigit(a[index],i);
                bucket[digit].add(a[index]);
            }
            //placing all the buckets back into the array
            int index = 0;
            for (int m=0; m<10; m++){
                for(int n =0; n<bucket[m].size(); n++){
                    a[index++] = bucket[m].get(n);
                }
            }
        }
        long executeTime = System.nanoTime();                                    //execute time
        long totalTime = executeTime - activateTime;                             //total time for main iterative method
        return totalTime;
    }
    public static Integer findDigit (int number, int i){
        int target =0;
        for(int k=0; k<=i;k++){
            //since its 2 digit number
            //to find the digit, we need mod 10 and divide by 10
            target = number % 10;
            number  = number /10;
        }
        return target;
    }
}
