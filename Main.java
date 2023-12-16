import java.util.Arrays;

abstract class Robber {
    abstract int RowHouses(int[] moneyInEachHouse);
    abstract int RoundHouses(int[] moneyInEachHouse);
    abstract int SquareHouse(int[] moneyInEachHouse);
    abstract int MultiHouseBuilding(int[] moneyInEachType);

    void RobbingClass() {
        System.out.println("MScAI&ML");
    }

    void MachineLearning() {
        System.out.println("I love MachineLearning.");
    }
}

class JAVAProfessionalRobber extends Robber {
    @Override
    int RowHouses(int[] moneyInEachHouse) {
        if (moneyInEachHouse == null || moneyInEachHouse.length == 0) {
            return 0;
        }

        int n = moneyInEachHouse.length;
        int[] dp = new int[n];

        dp[0] = moneyInEachHouse[0];
        if (n > 1) {
            dp[1] = Math.max(moneyInEachHouse[0], moneyInEachHouse[1]);
        }

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + moneyInEachHouse[i]);
        }

        return dp[n - 1];
    }

    @Override
    int RoundHouses(int[] moneyInEachHouse) {
        if (moneyInEachHouse == null || moneyInEachHouse.length == 0) {
            return 0;
        }

        int n = moneyInEachHouse.length;
        int[] dp = new int[n];

        dp[0] = moneyInEachHouse[0];
        dp[1] = Math.max(moneyInEachHouse[0], moneyInEachHouse[1]);

        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + moneyInEachHouse[i]);
        }

        int maxAmountWithoutLastHouse = dp[n - 2];

        Arrays.fill(dp, 0);

        dp[1] = moneyInEachHouse[1];
        dp[2] = Math.max(moneyInEachHouse[1], moneyInEachHouse[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + moneyInEachHouse[i]);
        }

        int maxAmountWithoutFirstHouse = dp[n - 1];

        return Math.max(maxAmountWithoutLastHouse, maxAmountWithoutFirstHouse);
    }

    @Override
    int SquareHouse(int[] moneyInEachHouse) {
        if (moneyInEachHouse == null || moneyInEachHouse.length == 0) {
            return 0;
        }

        int n = moneyInEachHouse.length;
        int[] dp = new int[n];

        dp[0] = moneyInEachHouse[0];
        if (n > 1) {
            dp[1] = Math.max(moneyInEachHouse[0], moneyInEachHouse[1]);
        }

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + moneyInEachHouse[i]);
        }

        return dp[n - 1];
    }

    @Override
    int MultiHouseBuilding(int[] moneyInEachType) {
        if (moneyInEachType == null || moneyInEachType.length == 0) {
            return 0;
        }

        int n = moneyInEachType.length;
        int[] dp = new int[n];

        dp[0] = moneyInEachType[0];
        if (n > 1) {
            dp[1] = Math.max(moneyInEachType[0], moneyInEachType[1]);
        }

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + moneyInEachType[i]);
        }

        return dp[n - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        JAVAProfessionalRobber javaRobber = new JAVAProfessionalRobber();
        javaRobber.RobbingClass();
        javaRobber.MachineLearning();

        int[] rowHousesMoney = {10, 20, 15, 25};
        int maxAmountRowHouses = javaRobber.RowHouses(rowHousesMoney);
        System.out.println("Maximum amount robbed from RowHouses: " + maxAmountRowHouses);

        int[] roundHousesMoney = {5, 10, 15, 20};
        int maxAmountRoundHouses = javaRobber.RoundHouses(roundHousesMoney);
        System.out.println("Maximum amount robbed from RoundHouses: " + maxAmountRoundHouses);

        int[] squareHousesMoney = {8, 12, 10, 5};
        int maxAmountSquareHouses = javaRobber.SquareHouse(squareHousesMoney);
        System.out.println("Maximum amount robbed from SquareHouses: " + maxAmountSquareHouses);

        int[] multiHouseBuildingMoney = {10, 15, 20, 25};
        int maxAmountMultiHouse = javaRobber.MultiHouseBuilding(multiHouseBuildingMoney);
        System.out.println("Maximum amount robbed from MultiHouseBuilding: " + maxAmountMultiHouse);
    }
}


