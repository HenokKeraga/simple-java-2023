package dynamic;

public class Main {
    public static void main(String[] args) {

        //   System.out.println(longestCommonSubsequence("abcde","ace"));
        // System.out.println(lis(new int[]{3,10,2,1,20}));
        //   System.out.println(lisIteration(new int[]{3,10,2,1,20}));
        // System.out.println(msIs(new int[]{3,10,2,1,20}));
     //   System.out.println(lbs(new int[]{3, 10, 2, 1, 20}));

      //  System.out.println(shortestCommonSupersequence("abc","acd"));
        int[] w=new int[]{5,4,6,3};
        int[] v=new int[]{10,40,50,10};
        int capacity=10;

        System.out.println(knapsack(w,v,capacity));

    }

    private static int knapsack(int[] w, int[] v, int c) {
        int n=w.length;
        int[][]dp = new int[n+1][c+1];

        for (int i = 0; i < n; i++) {
          dp[i][0]=0;
        }
        for (int i = 0; i < c; i++) {
            dp[0][c]=0;
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= c; j++) {

                if(w[i-1]>j){
                    dp[i][j]=0;

                }else {
                    dp[i][j]=Math.max(dp[i-1][j],v[i-1]+dp[i-1][j-w[i-1]]);
                }
            }

        }



        return dp[n][c];
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        // base cases
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        // recurrence relation
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // build the shortest common supersequence
        StringBuilder sb = new StringBuilder();
        int i = len1, j = len2;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }
        return sb.reverse().toString();
    }



        private static int lbs ( int[] input){
            int[] dp1 = new int[input.length];

            for (int i = 0; i < input.length; i++) {
                dp1[i] = 1;

            }

            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (input[i] > input[j]) {
                        dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                    }
                }
            }


            int[] dp2 = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                dp2[i] = 1;
            }
            for (int i = input.length - 1; i >= 0; i--) {
                for (int j = input.length - 1; j >= i; j--) {
                    if (input[i] > input[j]) {
                        dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                    }
                }
            }

            for (int i = 0; i < input.length; i++) {
                dp1[i] = dp1[i] + dp2[i] - 1;
            }

            int max = 1;

            for (int i = 0; i < input.length; i++) {
                max = Math.max(max, dp1[i]);
            }


            return max;

        }

        private static int msIs ( int[] input){

            int[] dp = new int[input.length];

            for (int m = 0; m < input.length; m++) {
                dp[m] = input[m];
            }

            for (int i = 0; i < input.length; i++) {

                for (int j = 0; j < i; j++) {

                    if (input[i] > input[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + input[i]);
                    }
                }
            }

            int max = dp[0];
            for (int j = 0; j < dp.length; j++) {
                max = Math.max(max, dp[j]);

            }


            return max;

        }

        private static int lisIteration ( int[] input){
            int[] dp = new int[input.length];
            for (int k = 0; k < input.length; k++) {
                dp[k] = 1;
            }

            for (int i = 0; i < input.length; i++) {

                for (int j = 0; j < i; j++) {

                    if (input[i] > input[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }

                }

            }
            int max = 1;
            for (int j = 0; j < dp.length; j++) {
                max = Math.max(max, dp[j]);

            }


            return max;
        }

        public static int longestCommonSubsequence (String text1, String text2){

            int n = text1.length();
            int m = text2.length();

            int[][] dp = new int[n + 1][m + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }

                }

            }

            return dp[n - 1][m - 1];
        }

        public static int lis ( int[] input){
            var n = input.length - 1;

            return lisHelper(input, n);
        }

        private static int lisHelper ( int[] input, int n){

            if (n < 0) {
                return 0;
            }

            // if(input[n]>input[])
            return 0;
        }
    }
