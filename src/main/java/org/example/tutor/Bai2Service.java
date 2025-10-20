package org.example.tutor;

import java.util.ArrayList;
import java.util.List;

public class Bai2Service {
    private List<Bai2> bai2List = new ArrayList<>();
    public boolean addSV(Bai2 bai2) {
        if(bai2.getMaSV().isBlank()||bai2.getTen().isBlank()||bai2.getTuoi()==null||bai2.getDTB()==null||bai2.getKyHoc()==null||bai2.getChuyenNganh().isBlank()){
            throw new NullPointerException("Khong duoc de trong");
        }
        if (bai2.getDTB()<0||bai2.getDTB()>10){
            throw new IllegalArgumentException("Tuoi khong hop le (1-10)");
        }
        bai2List.add(bai2);
        return true;
    }
    public boolean suaSV(String maSV,Bai2 bai2Moi) {
        Bai2 bai2=null;
        for (Bai2 b : bai2List) {
            if(b.getMaSV().equals(maSV)){
                bai2=b;
                break;
            }
        }
        if(bai2Moi.getMaSV().isBlank()||bai2Moi.getTen().isBlank()||bai2Moi.getTuoi()==null||bai2Moi.getDTB()==null||bai2Moi.getKyHoc()==null||bai2Moi.getChuyenNganh().isBlank()){
            throw new NullPointerException("Khong duoc de trong");
        }
        if (bai2Moi.getDTB()<0||bai2Moi.getDTB()>10){
            throw new IllegalArgumentException("Tuoi khong hop le (1-10)");
        }
        bai2.setMaSV(bai2Moi.getMaSV());
        bai2.setTen(bai2Moi.getTen());
        bai2.setTuoi(bai2Moi.getTuoi());
        bai2.setDTB(bai2Moi.getDTB());
        bai2.setKyHoc(bai2Moi.getKyHoc());
        bai2.setChuyenNganh(bai2Moi.getChuyenNganh());
        return true;
    }
}
