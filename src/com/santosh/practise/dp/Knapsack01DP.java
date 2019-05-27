package com.santosh.practise.dp;

import static java.lang.Math.max;

public class Knapsack01DP {
    public static void main(String[] args) {
        int[] profits = {0,1,2,5,6};
        int[] weights = {0,2,3,4,5};
        int knapsackCapacity = 8;
        int itemsCount = 4;

        int[][] knapsackGrid = getKnapsackGrid(profits, weights, knapsackCapacity, itemsCount);
        for(int i = 0; i<= itemsCount; i++) {
            for(int j = 0; j <= knapsackCapacity; j++) {
                System.out.print(knapsackGrid[i][j]);
            }
            System.out.println();
        }
        // get the last item of knapsack grid
        for(int i = itemsCount, j = knapsackCapacity; i>0 && j >=0;) {
            if(knapsackGrid[i][j] == knapsackGrid[i-1][j]) {
                System.out.println("Item " + i + " Not included");
                i = i-1;
            } else {
                System.out.println("Item " + i + " Included");
                j = j - weights[i];
                i = i-1;
            }
        }
    }

    private static int[][] getKnapsackGrid(int[] profits, int[] weights, int knapsackCapacity, int itemsCount) {
        int[][] valueGrid = new int[itemsCount+1][knapsackCapacity+1];
        for(int itemNumber = 0; itemNumber <= itemsCount; itemNumber++ ) {
            for(int currentBasketSize = 0; currentBasketSize <= knapsackCapacity; currentBasketSize++) {
                if(itemNumber == 0 || currentBasketSize == 0) {
                    valueGrid[itemNumber][currentBasketSize] = 0;
                } else {
                    int currentItemWeight = weights[itemNumber];
                    int currentItemProfit = profits[itemNumber];
                     if(currentBasketSize < currentItemWeight) {
                         // if the current basket size which is taken is less than the current item weight,
                         // it means that this item cannot be included, so the value will be
                         // the value that we have got when with same basket size and excluding this items
                         valueGrid[itemNumber][currentBasketSize] = valueGrid[itemNumber -1][currentBasketSize];
                     }
                     else {
                         // it means the current basket size is having more capacity than the new item that we have just included
                         // so we need check 2 things, 1. check the max value that we have got with same basket size without including the
                         // current item and 2. include the current item and if there is any capacity left in the basket
                         // after including the current item, get the max value of the remaining capacity that we can fit with the
                         // previous items that we have already computed.
                         // the max of those 2 values will be the max profit that we can fit into it.
                         int profitNotExcludingCurrentItem = valueGrid[itemNumber-1][currentBasketSize];
                         int remainingBasketSize = currentBasketSize - currentItemWeight;
                         int maxProfitForRemainingBasketSize = valueGrid[itemNumber-1][remainingBasketSize];
                         int maxProfitForCurrentBasketSize = max(profitNotExcludingCurrentItem, currentItemProfit + maxProfitForRemainingBasketSize);
                         valueGrid[itemNumber][currentBasketSize] = maxProfitForCurrentBasketSize;
                     }
                }
            }
        }
        return valueGrid;
    }
}
