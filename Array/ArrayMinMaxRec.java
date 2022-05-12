package Array;
public class ArrayMinMaxRec{

    static class Pairs{
        int min;
        int max;
    }

    static Pairs getMinMax(int arr[], int low , int high){
        Pairs minmax = new Pairs();
        Pairs mmLeft = new Pairs();
        Pairs mmRight = new Pairs();

        int mid = (low+high) /2;

        //array size is 1
        if(low == high){
            minmax.max = arr[high];
            minmax.min = arr[low];

            return minmax;
        }

        //array is of length 2
        if( high == low + 1){
            if( arr[high] > arr[low]){
                minmax.max = arr[high];
                minmax.min = arr[low];
            }
            else{
                minmax.max = arr[low];
                minmax.min = arr[high];
            }
            
            return minmax;
        }

        //array with size more than 2
        mmLeft = getMinMax(arr, low, mid);
        mmRight =getMinMax(arr, mid + 1, high);

        if(mmLeft.min  < mmRight.min){
            minmax.min = mmLeft.min;
        }
        else{
            minmax.min = mmRight.min;
        }

        if(mmLeft.max > mmRight.max){
            minmax.max = mmLeft.max;
        }
        else{
            minmax.max = mmRight.max;
        }

        return minmax;
    }

    public static void main(String args[]){
        int arr[] = {1000, 11, 445, 111, 3300, 3000};
        int arr_size = 6;
        Pairs minmax = getMinMax(arr, 0, arr_size - 1);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
 

    }
}