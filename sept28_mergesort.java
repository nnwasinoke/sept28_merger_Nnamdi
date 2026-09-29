import java.util.Scanner;

public class sept28_mergesort //Nnamdi Nwasinoke Jr
{
    public static void main(String[] args) {

        // merge sorting
        // ask the user how many elements to be sorted

        Scanner inputScanner = new Scanner(System.in);

        System.out.print("How many elements do you want to sort? ");
        int input_size = inputScanner.nextInt();

        // declare the array
        int[] input = new int[input_size];

        // take input from the user
        for (int i = 0; i < input.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            input[i] = inputScanner.nextInt();
        }

        int low = 0;
        int high = input.length - 1;

        // merge sort
        Mergesort(input, low, high);

        // print sorted array
        System.out.println("Sorted array:");

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

        inputScanner.close();
    }


    public static void Mergesort(int[] A, int low, int high) {

        if (low < high) {

            // divide
            int mid = low + (high - low) / 2;

            Mergesort(A, low, mid);

            Mergesort(A, mid + 1, high);

            Merge(A, low, mid, high);
        }
    }


    public static void Merge(int[] A, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        // compare the two sides
        while (i <= mid && j <= high) {

            if (A[i] <= A[j]) {
                temp[k] = A[i];
                i++;
            }
            else {
                temp[k] = A[j];
                j++;
            }

            k++;
        }

        // copy remaining elements from left side
        while (i <= mid) {
            temp[k] = A[i];
            i++;
            k++;
        }

        // copy remaining elements from right side
        while (j <= high) {
            temp[k] = A[j];
            j++;
            k++;
        }

        // copy temp back into original array
        for (i = 0; i < temp.length; i++) {
            A[low + i] = temp[i];
        }
    }
}