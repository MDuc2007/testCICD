package org.example.tutor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SachService {
    private List<Sach> saches=new ArrayList<>();

    public boolean themSach(Sach sach){
        if(sach==null){
            throw new NullPointerException("Sach khong duoc null");
        }
        if(sach.getSoTrang()<1||sach.getSoTrang()>50){
            throw new IllegalArgumentException("So trang khong hop le (1-50)");
        }
        if (!Pattern.matches("^[a-zA-Z0-9\\s]+$",sach.getTen())){
            throw new IllegalArgumentException("Ten khong chua ky tu dac biet");
        }
        saches.add(sach);
        return true;
    }
    public List<Sach> timKiem(String tenTacGia) {
        List<Sach> danhsach=new ArrayList<>();
        for (Sach sach : saches) {
            if (sach.getTenTacGia().equals(tenTacGia)) {
                danhsach.add(sach);
            }
        }
        return danhsach;
    }
    public boolean suaSach(String id,Sach sachMoi) {
        Sach sach=null;
        for (Sach s : saches) {
            if (s.getId().equals(id)) {
                sach=s;
                break;
            }
        }
        if (sach==null){
            throw new IllegalArgumentException("Khong tim thay sach");
        }
        if (sachMoi.getSoTrang()<1||sachMoi.getSoTrang()>50){
            throw new IllegalArgumentException("Sotrang khong hop le (1-50)");
        }
        if (!Pattern.matches("^[a-zA-Z\\s]+$",sachMoi.getTen())) {
            throw new IllegalArgumentException("Ten khong chua ky tu dac biet");
        }
        sach.setTen(sachMoi.getTen());
        sach.setSoTrang(sachMoi.getSoTrang());
        sach.setTenTacGia(sachMoi.getTenTacGia());
        sach.setLanTaiBan(sachMoi.getLanTaiBan());
        return true;
    }
}
