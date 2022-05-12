package Array;

public class ArrayMinMax{

    static class Pairs{
        int max;
        int min;
    }

    static Pairs getMinMax(int arr[], int n){
        Pairs minmax = new Pairs();

        int i;

        //size of array is even
        if(n % 2 == 0){
            if(arr[0] > arr[1]){
                minmax.max = arr[0];
                minmax.min = arr[1];
            }
            else{
                minmax.max = arr[1];
                minmax.min = arr[0];
            }
            i = 2;
        }
        //array is of odd size
        else{
            minmax.max = arr[0];
            minmax.min = arr[0];

            i = 1;
        }

        while( i < n - 1){
            if(arr[i] > arr[i+1]){
                if(arr[i] > minmax.max){
                    minmax.max = arr[i];
                }
                if( arr[i+1] < minmax.min){
                    minmax.min = arr[i +1];
                }
            }
            else{
                if(arr[i+ 1] > minmax.max){
                    minmax.max = arr[i+1];
                }
                if(arr[i] < minmax.min){
                    minmax.min = arr[i];
                }
            }

            i += 2;
        }

        return minmax;
    }
    public static void main(String args[]){
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        Pairs minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
    }
}