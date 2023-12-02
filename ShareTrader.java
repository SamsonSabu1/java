 public class ShareTrader {
    private static int maxProfit;
    public static void main(String[] args) {
        int[] prices1 = {10, 22, 5, 75, 65, 80};
        findMaxProfit(prices1);

        int[] prices2 = {2, 30, 15, 10, 8, 25, 80};
        findMaxProfit(prices2);
    }

    public static void findMaxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            maxProfit = 0;
            System.out.println("Maximum Profit: " + maxProfit);
            return;
        }

        int[] leftProfit = new int[n];
        int[] rightProfit = new int[n];

        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        }

        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }

        System.out.println("Maximum Profit: " + maxProfit);
    }
}


