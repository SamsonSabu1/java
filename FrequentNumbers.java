import java.util.Scanner;

public class FrequentNumbers {

    private static int[] A;

    private static void bubbleSort(int[][] array) 
    {
        int n = array.length;
        int i,j;
        int[] temp;

        for (i = 0; i < n - 1; i++) 
        {
            for (j = 0; j < n - i - 1; j++) 
            {
                if (array[j][1] < array[j + 1][1]) 
                {

                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } 
                
                else if (array[j][1] == array[j + 1][1] && array[j][0] < array[j + 1][0]) //two elements have the same frequency, then sort it with the help of element value
                {

                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void calcfreq(int K) 
    {
        int n = A.length;
        int[][] freqArr = new int[n][2];

        int count, index = 0;
        int i,j,k;
        boolean flag;
        
        for (i = 0; i < n; i++) {
            count = 1;
            for (j = i + 1; j < n; j++) {
                if (A[i] == A[j]) {
                    count++;
                }
            }

            flag = false;
            for (k = 0; k < index; k++) {
                if (freqArr[k][0] == A[i]) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                freqArr[index][0] = A[i];
                freqArr[index][1] = count;
                index++;
            }
        }

        bubbleSort(freqArr);


        for (i = 0; i < K && i < index; i++) 
        {
            System.out.print(freqArr[i][0] + " ");
        }
        
        System.out.println();
        
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int size, i, K;


        System.out.println("Enter the size of the array: ");
        size = scanner.nextInt();

        A = new int[size];
        System.out.print("Enter the elements of the array: ");
        for (i = 0; i < size; i++) {
            A[i] = scanner.nextInt();
        }

        System.out.println("Enter the value of K: ");
        K = scanner.nextInt();

        calcfreq(K);

        scanner.close();
    }
}