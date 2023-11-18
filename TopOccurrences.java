//import java.util.HashMap;
import java.util.Scanner;

public class TopOccurrences {

    public static int[] arr;
    public static void sort(int[] array)
 
{
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner obj1 = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = obj1.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ": ");
            arr[i] = obj1.nextInt();
        }

        System.out.println("Enter value of K: ");
        int k = obj1.nextInt();
        System.out.println("value of K:"+ k);

        sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }}
