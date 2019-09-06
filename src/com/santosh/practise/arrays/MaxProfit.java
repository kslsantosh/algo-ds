package com.santosh.practise.arrays;
/*
Input: [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Not 7-1 = 6, as selling price needs to be larger than buying price.*/

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxProfit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size");
        int length = s.nextInt();
        int[] stockPrices = new int[length];
        for(int i = 0; i < length; i++) {
            stockPrices[i] = s.nextInt();
        }
        findMaxProfit(stockPrices);
    }

    private static void findMaxProfit(int[] stockPrices) {
        int totalProfit = 0;
        int buyDate = 0;
        int sellDate = 0;

        for(int i = 1; i < stockPrices.length; i++) {
            if(stockPrices[i] != 0 && stockPrices[i] <=  stockPrices[buyDate]) {
                // price dip so sell it on the day where you have got the max profit till now
                if(buyDate != sellDate) {
                    System.out.println("Buy On:" + buyDate);
                    System.out.println("Sell On:" + sellDate);
                }
                totalProfit = totalProfit + stockPrices[sellDate] - stockPrices[buyDate];
                //System.out.println("Profit: " + (stockPrices[sellDate] - stockPrices[buyDate]));
                buyDate = i; // because there is a price dip, buy it now here.
                sellDate = i; // default with selling on today
                //maxProfitTillNow = 0;
            }
            else if (stockPrices[i] > stockPrices[buyDate]) {
                //prices have increased, check the profit that you get by selling on this date
                int profit = stockPrices[i] - stockPrices[buyDate];
                totalProfit = totalProfit + profit;
                    if(buyDate != sellDate) {
                    System.out.println("Buy On:" + buyDate);
                    System.out.println("Sell On:" + i + " Profit: " + profit);
                }
                sellDate = i;
                buyDate = i;
            }
        }

        System.out.println("Buy On:" + buyDate);
        System.out.println("Sell On:" + sellDate);
        System.out.println("Total Profit:" + totalProfit);
    }
}
