package org.example.tutor;

public class Bai2 {
    private String maSV;
    private String ten;
    private Integer tuoi;
    private Float DTB;
    private Integer kyHoc;
    private String chuyenNganh;

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public Float getDTB() {
        return DTB;
    }

    public void setDTB(Float DTB) {
        this.DTB = DTB;
    }

    public Integer getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(Integer kyHoc) {
        this.kyHoc = kyHoc;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public Bai2(String maSV, String ten, Integer tuoi, Float DTB, Integer kyHoc, String chuyenNganh) {
        this.maSV = maSV;
        this.ten = ten;
        this.tuoi = tuoi;
        this.DTB = DTB;
        this.kyHoc = kyHoc;
        this.chuyenNganh = chuyenNganh;
    }

    public Bai2() {
    }
}
