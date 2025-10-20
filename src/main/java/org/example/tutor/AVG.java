package org.example.tutor;

public class AVG {
    public Double avg(double diem1, double diem2, double diem3) {
        if (diem1 < 0 || diem1 > 10 || diem2 < 0 || diem2 > 10 || diem3 < 0 || diem3 > 10) {
            throw new IllegalArgumentException("Diem is out of range");
        }
        return  (diem1 + diem2 + diem3) / 3.0;
    }
}
