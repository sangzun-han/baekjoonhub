import java.util.*;

class Solution {
    static int[] discounts = {10,20,30,40};
    static int maxServiceUsers = 0;
    static int maxTotalPrice = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discountComb = new int[emoticons.length];
        int[] answer = new int[2];
        comb(0, emoticons, discountComb, users);
        answer[0] = maxServiceUsers;
        answer[1] = maxTotalPrice;
        
        return answer;
    }
    
    public void comb(int index, int[] emoticons, int[] discountComb, int[][] users) {
        if(index==emoticons.length) {
            calculateEmoticon(discountComb, users, emoticons);
            return;
        }
        
        for(int discount: discounts) {
            discountComb[index] = discount;
            comb(index + 1, emoticons, discountComb, users);
        }
    }
    
    public void calculateEmoticon(int[] discountComb, int[][] users, int[] emoticons) {
        int serviceUsers = 0;
        int totalPrice = 0;
        
        for(int[] user: users) {
            int userLimitDiscount = user[0];
            int userLimitPrice = user[1];
            int userUsePrice = 0;
            
            for(int i=0; i<emoticons.length; i++) {
                if(discountComb[i] >= userLimitDiscount) {
                    int discountPrice = emoticons[i] * (100-discountComb[i])/100;
                    userUsePrice += discountPrice;
                }
            }
            if(userUsePrice >= userLimitPrice) {
                serviceUsers++;
            } else {
                totalPrice += userUsePrice;
            }
            
            if(serviceUsers > maxServiceUsers) {
                maxServiceUsers = serviceUsers;
                maxTotalPrice = totalPrice;
            } else if (serviceUsers == maxServiceUsers && totalPrice > maxTotalPrice) {
                maxServiceUsers = serviceUsers;
                maxTotalPrice = totalPrice;
            } 
        }
    }
}