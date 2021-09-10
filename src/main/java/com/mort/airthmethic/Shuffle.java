package com.mort.airthmethic;

import java.util.Random;

/**
 * @author mort
 * @Description   随机公平洗牌
 * @date 2021/3/3
 **/
public class Shuffle {


    public static void main(String[] args) {
        int[] card = initCard();
        printArray(card);
        Random random = new Random();
        for (int i = 0; i < 52; i++) {
            //random two cards
            int j = i + random.nextInt(52 - i);
            // exchange
            int tmp = card[i];
            card[i] = card[j];
            card[j] = tmp;
        }
        System.out.println("shuffled card");
        printArray(card);
    }

    private static int[] initCard() {
        int[] card = new int[52];
        for (int i = 0; i < 52; i++) {
            card[i] = i;
        }
        return card;
    }

    private static void printArray(int [] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
        }
    }
}
