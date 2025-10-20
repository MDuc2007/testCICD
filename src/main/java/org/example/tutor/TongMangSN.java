package org.example.tutor;

import java.util.ArrayList;
import java.util.List;

public class TongMangSN {
    public int tongSoNguyen(int [] arr){
        if (arr == null) {
            throw new IllegalArgumentException("Mang khong duoc null");
        }
        for(int num : arr){
            if(num<0||num>1000){
                throw new IllegalArgumentException("PTu trong khoang 0-1000");
            }
        }
        int sum = 0;
        for(int num : arr){
            sum += num;

        }
        return sum;
    }
}
