import java.util.Scanner;
abstract class Robber {
    abstract int RowHouses(int[] money);

    abstract int RoundHouses(int[] money);

    abstract int SquareHouse(int[] money);


    // Default method
    void MachineLearning() {
        System.out.println("I love MachineLearning.");
    }

    // Concrete method
    void RobbingClass() {
        System.out.println("MScAI&ML");
    }
}

class JAVAProfessionalRobber extends Robber {
    @Override
    int RowHouses(int[] money) {
        int n = money.length;
        if (n == 0) 
            return 0;

        int[] rob = new int[n];
        rob[0] = money[0];

        for (int i = 1; i < n; i++) 
        {
            rob[i] = Math.max(rob[i - 1], (i - 2 >= 0 ? rob[i - 2] : 0) + money[i]);
        }

        return rob[n - 1];
    }

    @Override
    int RoundHouses(int[] money) {
        int n = money.length;
        if (n == 0) 
            return 0;

        int[] rob = new int[n];

        // Rob the first house
        rob[0] = money[0];
        rob[1] = Math.max(money[0], money[1]);

        for (int i = 2; i < n; i++) {
            rob[i] = Math.max(rob[i - 1], rob[i - 2] + money[i]);
        }

        // Return the maximum of robbing the last house and not robbing the last house
        return Math.max(rob[n - 1], rob[n - 2]);
    }

    @Override
    int SquareHouse(int[] money) {
        int n = money.length;
        if (n == 0) 
            return 0;

        int[] rob = new int[n];
        //This logic only works in case of 4 houses
        int r1 = money[0]+money[2];
        int r2 = money[1]+money[3];
        if(r1>r2) 
            return r1;
        else
            return r2;

       /*// Rob the first house
        rob[0] = money[0];
        rob[1] = Math.max(money[0], money[1]);

        for (int i = 2; i < n; i++) {
            rob[i] = Math.max(rob[i - 1], rob[i - 2] + money[i]);
        }

        return rob[n - 1];*/
    }

    }

public class ProfRobber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JAVAProfessionalRobber robber = new JAVAProfessionalRobber();
        int n=4;
        int[] money = new int[n];
        System.out.println("Enter the wealth available in each house: ");
        for(int i=0; i<n; i++)
        {
            money[i] = sc.nextInt();
        }
        int choice;
        System.out.println("Choose the type of house arrangement:\n1.Row House\n2.Round House\n3.Square House\n");
        choice = sc.nextInt();
        switch(choice)
        {
            case 1: 
                    System.out.println("RowHouses: "+ robber.RowHouses(money));
                    break;
            case 2:
                    System.out.println("RoundHouses: "+ robber.RoundHouses(money));
                    break;
            case 3:
                    System.out.println("SquareHouses: "+ robber.SquareHouse(money));
                    break;
            default:
                    System.out.println("Invalid Choice!");
        }
        

    }
}
