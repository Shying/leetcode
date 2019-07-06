package com.syy.leetcode;

public class BestTimeBuyAndSellStock {
    /**
     * 有什么小于n^2的方法呢。。感觉很像木桶装水，但是不行啊
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int get = 0;
        int i = 0;
        int minBuy = Integer.MAX_VALUE;
        while (i < len - 1) {
            while (i < len - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }

            int j = i + 1;
            while (j < len - 1 && prices[j + 1] > prices[j]){
                j++;
            }
            if (i < len - 1 && j < len) {
                if (prices[i] < minBuy) {
                    minBuy = prices[i];
                }
                if (prices[j] - minBuy > get) {
                    get = prices[j] - minBuy;
                }
            }
            i = j + 1;
        }
        return get;
    }



    public int maxProfitNaive(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int i = 0;
        int sum = 0;
        while (i < len - 1) {
            while (i < len - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }

            int j = i + 1;
            while (j < len - 1 && prices[j + 1] > prices[j]){
                j++;
            }
            if (i < len - 1 && j < len) {
                sum += prices[j] - prices[i];
            }
            i = j + 1;
        }
        return sum;
    }


    public static void main(String[] args) {
        BestTimeBuyAndSellStock obj = new BestTimeBuyAndSellStock();
//        [3,2,6,5,0,3]
//        [2,1,2,1,0,0,1]
//        [7,1,5,3,6,4]
        int ret = obj.maxProfit2(new int[] {7,6,4,3,2,1});
        System.out.print(ret);
    }
}
