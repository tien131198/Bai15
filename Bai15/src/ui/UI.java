package ui;

import enity.KetQuaHocTap;
import enity.SinhVienChinhQuy;
import enity.SinhVienTaiChuc;
import exception.*;
import service.Khoa;
import service.KiemTraNgoaiLe;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Welcome to project
    @author: tienb
    Date: 11/7/2022
    Time: 10:54 AM
    
    ProjectName: SinhVienChinhQuy.java
*/public class UI {
    private Khoa qLSV = new Khoa();
    // insert email
    public String insertEmail(Scanner scanner){
        System.out.println("Nhap email theo dinh dang xxxx@xxx.xxx");
        String email;
        while (true){
            email = scanner.nextLine();
            try {
                KiemTraNgoaiLe.checkEmail(email);
                return email;
            } catch (EmailException e) {
                System.out.println("Nhap dung dinh dang: tien123@gmail.com");
            }
        }
    }
    // insert phone
    public String insertPhone(Scanner scanner){
        System.out.println("Nhap phone gom 10 chu so");
        String phone;
        while(true){
            phone =scanner.nextLine();
            try {
                KiemTraNgoaiLe.checkPhone(phone);
                return phone;
            } catch (PhoneException e) {
                System.out.println("Nhap dung dinh dang: 08xxxxxxx");;
            }
        }
    }
    // insert date
    public LocalDate insertDate(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Nhap thong tin ngay theo format: dd/MM/yyyy");
        LocalDate date;
        while (true) {
            try {
                date = LocalDate.parse(scanner.nextLine(), formatter);
                return date;
            } catch (DateTimeParseException ex) {
                System.out.println("Nhap dung dinh dang dd/MM/yyyy . 12/06/2099");
            }
        }
    }

    // insert ket qua hoc tap
    private List<KetQuaHocTap> insertKQHT(Scanner scanner) {
        System.out.println("Nhap ket qua hoc tap");
        int n = insertSoLuongHocKi(scanner);
        List<KetQuaHocTap> listKQHT = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            KetQuaHocTap kQHT = new KetQuaHocTap();
            kQHT.setHocKi(insertTenHocKi(scanner));
            kQHT.setDiemTrungBinh(insertDiemTrungBinh(scanner));
            listKQHT.add(kQHT);
        }
        return listKQHT;
    }

    // insert ten hoc ki
    private String insertTenHocKi(Scanner scanner) {
        System.out.println("Nhap ten hoc ki");
        return scanner.nextLine();
    }

    // insert Hoc ki can nhap
    private int insertSoLuongHocKi(Scanner scanner) {
        System.out.println("Nhap so luong hoc ki");
        while (true) {
            try {
                int soLuongHocKi = Integer.parseInt(scanner.nextLine());
                try {
                    KiemTraNgoaiLe.checkSoLuong(soLuongHocKi);
                    return soLuongHocKi;
                } catch (NumberException e) {
                    System.out.println("Vui long nhap lai: hoc ki > 0 ");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Nhap sai dinh dang so luong, nhap lai");
            }
        }
    }

    // insert diem trung binh
    private float insertDiemTrungBinh(Scanner scanner) {
        System.out.println("Nhap diem trung binh");
        while (true) {
            try {
                float diemTrungBinh = Float.parseFloat(scanner.nextLine());
                try {
                    KiemTraNgoaiLe.checkDiem(diemTrungBinh);
                    return diemTrungBinh;
                } catch (ScoreException e) {
                    System.out.println("Vui long nhap lai diem tu 0 ->10");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Nhap sai dinh dang, nhap lai");

            }
        }
    }

    // insert Sinh vien Chinh Quy
    private SinhVienChinhQuy insertSVCQ(Scanner scanner) {
        SinhVienChinhQuy sv = new SinhVienChinhQuy();
        sv.setMaSV(insertMSV(scanner));
        sv.setTen(insertNameSV(scanner));
        System.out.println("Nhap ngay sinh sinh vien ");
        sv.setNgaySinh(insertDate(scanner));
        sv.setNamVaoHoc(insertNamNhapHoc(scanner));
        sv.setDiemDauVao(insertDiemDauVao(scanner));
        sv.setEmail(insertEmail(scanner));
        sv.setPhone(insertPhone(scanner));
        sv.setKetQua(insertKQHT(scanner));
        return sv;
    }

    // insert ma sinh vien
    private String insertMSV(Scanner scanner) {
        System.out.println("Nhap ma sinh vien");
        String mSV;
        while (true) {
            mSV = scanner.nextLine();
            if (this.qLSV.tonTaiID(mSV) == false) {
                return mSV;
            } else {
                System.out.println("Ma sinh vien da ton tai. Vui long nhap MSV khac");
            }
        }
    }
    // nhap ID de tim kiem
    private String nhapID(Scanner scanner){
        String mSV;
        System.out.println("Nhap ma sv de tim kiem");
        return mSV = scanner.nextLine();
    }

    // insert ten sinh vien
    private String insertNameSV(Scanner scanner) {
        System.out.println("Nhap ten sinh vien");
        return scanner.nextLine();
    }

    // insert nam nhap hoc
    private int insertNamNhapHoc(Scanner scanner) {
        System.out.println("Nhap nam nhap hoc");
        while (true) {
            try {
                int namNhapHoc = Integer.parseInt(scanner.nextLine());
                try {
                    KiemTraNgoaiLe.checkYear(namNhapHoc);
                    return namNhapHoc;
                } catch (YearException e) {
                    System.out.println("Vui long nhap lai nam nhap hoc theo dinh dang xxxx: 2067");
                }

            } catch (NumberFormatException ex) {
                System.out.println("Nhap sai dinh dang nam nhap hoc, moi nhap lai");
            }
        }
    }

    // insert diem dau vao
    private float insertDiemDauVao(Scanner scanner) {
        System.out.println("Nhap diem dau vao");
        while (true) {
            try {
                float diemDauVao = Float.parseFloat(scanner.nextLine());
                try {
                    KiemTraNgoaiLe.checkDiem(diemDauVao);
                    return diemDauVao;
                } catch (ScoreException e) {
                    System.out.println("Vui long nhap lai diem trong khoang 0->10");
                    ;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Nhap sai dinh dang diem dau vao, moi nhap lai");
            }
        }
    }

    // insert Sinh vien Tai Chuc
    private SinhVienTaiChuc insertSVTC(Scanner scanner) {
        SinhVienChinhQuy sVCQ = insertSVCQ(scanner);
        String noiDaoTao = insertNoiDaoTao(scanner);
        SinhVienTaiChuc sVTC = new SinhVienTaiChuc(sVCQ.getMaSV(), sVCQ.getTen(), sVCQ.getNgaySinh(), sVCQ.getNamVaoHoc(), sVCQ.getDiemDauVao(), sVCQ.getEmail(),sVCQ.getPhone(),sVCQ.getKetQua(), noiDaoTao);
        return sVTC;
    }

    // insert noi dao tao (doi voi sinh vien tai chuc)
    private String insertNoiDaoTao(Scanner scanner) {
        System.out.println("Nhap noi dao tao");
        return scanner.nextLine();
    }

    // insert thong tin sinh vien
    public void themThongTinSinhVien(Scanner scanner) {
        System.out.println("Chon 1: Them thong tin sinh vien chinh quy:");
        System.out.println("Chon 2: Them thong tin sinh vien tai chuc");
        String luaChon = scanner.nextLine();
        switch (luaChon) {
            case "1": {
                SinhVienChinhQuy sv1 = insertSVCQ(scanner);
                this.qLSV.themSV(sv1);
                break;
            }
            case "2": {
                SinhVienTaiChuc sv2 = insertSVTC(scanner);
                this.qLSV.themSV(sv2);
                break;
            }
            default:
                break;
        }
    }

    // Xac dinh tong so sinh vien cua khoa
    public void soLuongSV() {
        System.out.println("Tong so sinh vien cua khoa:");
        System.out.println(this.qLSV.soLuongSV());
    }

    // Hien thi thong tin
    public void showAll() {
        System.out.println("Thong tin toan bo sinh vien trong khoa");
        this.qLSV.findAll().forEach(o -> System.out.println(o));
    }

    // Search theo ID
    public void searchByID(Scanner scanner) {
        System.out.println("Nhap thong tin id muon tim kiem");
        String id = nhapID(scanner);
        if (this.qLSV.tonTaiID(id)) {
            System.out.println(this.qLSV.timSV(id));
        }else{
            System.out.println("id khong ton tai");
        }
    }

    // Tong so sinh vien chinh quy
    public void tongSoSVCQ() {
        System.out.println(this.qLSV.soLuongSVCQ());
    }

    // Tim ra sinh vien co diem dau vao cao nhat
    public void sVDiemDauVaoCaoNhat() {
        System.out.println("Thong tin sinh vien co diem dau vao cao nhat: ");
        System.out.println(this.qLSV.sVDiemCaoNhat());
    }

    // Danh sach sinh vien tai chuc
    public void dSSVTaiChuc(Scanner scanner) {
        System.out.println("Nhap thong tin ten co so dao tao");
        String noiDaoTao = insertNoiDaoTao(scanner);
        System.out.println("Danh sach sinh vien tai chuc trong khoa: ");
        System.out.println(this.qLSV.locdanhSachSV(noiDaoTao));
    }

    // Danh sah sinh vien co diem hoc ki gan nhat >= 8.0
    public void dSSVDiemLonHon8() {
        System.out.println("Danh sach sinh vien co diem trung binh > 8: ");
        System.out.println(this.qLSV.danhSachSVDiem8());
    }

    // Tim ra sinh vien co diem trung binh cao nhat trong tat ca ki hoc
    public void timSVDiemCaoNhat() {
        System.out.println("Thong tin sinh vien co diem trung binh cao nhat trong tat ca cac ki:");
        System.out.println(this.qLSV.sVDiemCaoNhat());
    }

    // Sap xep danh sach sinh vien theo tieu chi
    public void sapXepDanhSachSV() {
        System.out.println("Dnah sach sinh vien duoc sap xep theo tieu chi loai va giam dan theo nam vao hoc");
        System.out.println(this.qLSV.sapXepDSSV());
    }

    // Thong ke so luong sinh vien theo nam vao hoc
    public void thongKeSoLuongSVTheoNam(Scanner scanner) {
        System.out.println("Nhap nam vao hoc:");
        int namVaoHoc = insertNamNhapHoc(scanner);
        System.out.println(this.qLSV.thongKe(namVaoHoc));
    }
}
