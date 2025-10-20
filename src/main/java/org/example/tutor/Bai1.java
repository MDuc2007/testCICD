package org.example.tutor;

public class Bai1 {
    public int TinhTongMang(int[] arr) {
        for (int num : arr) {
            if (num < 0 || num > 1000) {
                throw new IllegalArgumentException("DM QUYET GAY");
            }
            return num;
        }
        int sum = 0;

        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
