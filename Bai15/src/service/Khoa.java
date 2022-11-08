package service;

import enity.KetQuaHocTap;
import enity.SinhVienChinhQuy;
import enity.SinhVienFile;
import enity.SinhVienTaiChuc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 8:17 PM
    
    ProjectName: Bai15
*/public class Khoa implements Serializable{
    public static int soLuongSinhVien = 0;
    private String tenKhoa;
    private List<SinhVienChinhQuy> danhSachSV;
    private SinhVienFile sinhVienFile;

    public Khoa() {
        sinhVienFile = new SinhVienFile();
        danhSachSV = sinhVienFile.read();
    }

    public Khoa(String tenKhoa, List<SinhVienChinhQuy> danhSachSV) {
        this.tenKhoa = tenKhoa;
        this.danhSachSV = danhSachSV;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public List<SinhVienChinhQuy> getDanhSachSV() {
        return danhSachSV;
    }

    public void setDanhSachSV(List<SinhVienChinhQuy> danhSachSV) {
        this.danhSachSV = danhSachSV;
    }

    // Thêm sinh viên
    public void themSV(SinhVienChinhQuy sv) {
        this.danhSachSV.add(sv);
        this.sinhVienFile.write(danhSachSV);
        soLuongSinhVien ++;
    }
    //  kiem tra su ton tai cua id
    public boolean tonTaiID(String id){
       if(timSV(id) == null){
           return false;
       }else {
           return true;
       }
    }
    // Tìm sinh viên dựa vào id
    public SinhVienChinhQuy timSV(String id) {
        return this.danhSachSV.stream().filter(o -> o.getMaSV().equals(id)).findFirst().orElse(null);

    }

    // Xóa sinh viên dựa vào id
    public boolean xoaSV(String id) {
        SinhVienChinhQuy sv = timSV(id);
        if (sv == null) {
            return false;
        } else {
            this.danhSachSV.remove(sv);
            this.sinhVienFile.write(danhSachSV);
            soLuongSinhVien --;
            return true;
        }
    }

    // Hien thi thong tin
    public List<SinhVienChinhQuy> findAll() {
        return this.danhSachSV;
    }

    // Xác định tổng số sinh viên của khoa
    public int soLuongSV() {
        return soLuongSinhVien;
    }
// Xac dinh so luong sinh vien chinh quy cua khoa
    public int soLuongSVCQ(){
        return (int) this.danhSachSV.stream().filter(o->!(o instanceof SinhVienTaiChuc)).count();
    }

    // Xác định sinh viên có điểm đầu vào cao nhất
    public SinhVienChinhQuy sVDiemCaoNhat() {
        return this.danhSachSV.stream().max(Comparator.comparingDouble(s -> s.getDiemDauVao())).orElse(null);
    }

    // Danh sách sinh viên tại chức tại nơi liên kết đào tạo cho trước
    public List<SinhVienChinhQuy> locdanhSachSV(String noiDaoTao) {
        List<SinhVienChinhQuy> dsSV = this.danhSachSV.stream().filter(o -> (o instanceof SinhVienTaiChuc) && ((SinhVienTaiChuc) o).getNoiDaoTao().equals(noiDaoTao)).collect(Collectors.toList());
        return dsSV;
    }

    // Danh sách sinh viên có điểm trung bình ở học kì gần nhất từ 8.0
    public List<SinhVienChinhQuy> danhSachSVDiem8() {
        List<SinhVienChinhQuy> dsSV = this.danhSachSV.stream().filter(o -> (o.getKetQua().get(o.getKetQua().size() - 1).getDiemTrungBinh() >= 8.0f)).collect(Collectors.toList());
        return dsSV;
    }

    // Xác định sinh viên có điểm trung bình bất kì học kì cao nhất
    public SinhVienChinhQuy sVDiemTrungBinhCaoNhat() {
        SinhVienChinhQuy sv = this.danhSachSV.stream().max((o1, o2) -> {
            List<KetQuaHocTap> list1 = o1.getKetQua();
            List<KetQuaHocTap> list2 = o2.getKetQua();
            Collections.sort(list1, (s1, s2) -> (int) (s1.getDiemTrungBinh() - s2.getDiemTrungBinh()));
            Collections.sort(list2, (v1, v2) -> (int) (v1.getDiemTrungBinh() - v2.getDiemTrungBinh()));
            float count = list1.get(list1.size() - 1).getDiemTrungBinh() - list2.get(list2.size() - 1).getDiemTrungBinh();
            return (int) count;
        }).get();
        return sv;
    }

    // Sắp xếp sinh viên tăng dần theo loại và giảm dần theo năm học
    public List<SinhVienChinhQuy> sapXepDSSV() {
        Comparator<SinhVienChinhQuy> compareByLoai = new Comparator<SinhVienChinhQuy>() {
            @Override
            public int compare(SinhVienChinhQuy o1, SinhVienChinhQuy o2) {
                if (o1 instanceof SinhVienTaiChuc && o2 instanceof SinhVienTaiChuc) {
                    return 0;
                } else if (o1 instanceof SinhVienTaiChuc) {
                    return 1;
                } else return -1;
            }
        };
        Comparator<SinhVienChinhQuy> compareByNam = new Comparator<SinhVienChinhQuy>() {
            @Override
            public int compare(SinhVienChinhQuy o1, SinhVienChinhQuy o2) {
                return o2.getNamVaoHoc() - o1.getNamVaoHoc();
            }
        };
        List<SinhVienChinhQuy> dsSV = this.danhSachSV.stream().sorted(compareByLoai.thenComparing(compareByNam)).collect(Collectors.toList());
        return dsSV;
    }

    // Thống kê số lượng sinh viên theo vào năm học
    public int thongKe(int namHoc) {
        long count = this.danhSachSV.stream().filter(o -> o.getNamVaoHoc() == namHoc).count();
        return (int) count;
    }

}
