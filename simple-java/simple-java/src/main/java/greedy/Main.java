package greedy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        final int data;
        data=1;

        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int value = 437;
        int minCoins = minCoins(coins, value);
        System.out.println("Minimum number of coins needed to change "+value+" into denominations "+ Arrays.toString(coins)+" is "+minCoins+".");

    }

    private static int minCoins2(int[] coins, int value) {
        Arrays.sort(coins);

        int countCoin=0;

        for (int i=coins.length-1;i>=0;i--){

            var v= value / coins[i];
            countCoin+=v;
            value=value % coins[i];

        }

        return countCoin;
    }
    public static int minCoins(int[] coins, int V) {
        int totalCoins = 0;
        Arrays.sort(coins);
        int n = coins.length;
        for(int i = n - 1; i >= 0; i--) {
            while(V >= coins[i]) {
                V -= coins[i];
                totalCoins++;
            }
        }
        return totalCoins;
    }
}
