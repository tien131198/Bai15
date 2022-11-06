package service;

import enity.SinhVienChinhQuy;
import enity.SinhVienTaiChuc;

import javax.swing.event.ListDataEvent;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 8:17 PM
    
    ProjectName: Bai15
*/public class Khoa {
    private String tenKhoa;
    private List<SinhVienChinhQuy> danhSachSV;

    public Khoa() {
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
    public void themSV(SinhVienChinhQuy sv){
        this.danhSachSV.add(sv);
    }
    // Tìm sinh viên dựa vào id
    public SinhVienChinhQuy timSV(String id){
        return this.danhSachSV.stream()
                .filter(o->o.getMaSV().equals(id))
                .findFirst().orElse(null);

    }
    // Xóa sinh viên dựa vào id
    public boolean xoaSV(String id){
        SinhVienChinhQuy sv = timSV(id);
        if (sv == null){
            return false;
        }else{
            this.danhSachSV.remove(sv);
            return true;
        }
    }
    // Xác định tổng số sinh viên của khoa
    public int soLuongSV(){
        return this.danhSachSV.size();
    }
    // Xác định sinh viên có điểm đầu vào cao nhất
    public SinhVienChinhQuy sVDiemCaoNhat(){
        return this.danhSachSV.stream()
                .max(Comparator.comparingInt(s->s.getDiemDauVao()))
                .orElse(null);
    }
    // Danh sách sinh viên tại chức tại nơi liên kết đào tạo cho trước
    public List<SinhVienChinhQuy> locdanhSachSV(String noiDaoTao){
        List<SinhVienChinhQuy> dsSV = this.danhSachSV.stream().filter(o->(o instanceof SinhVienTaiChuc)&&((SinhVienTaiChuc)o).getNoiDaoTao().equals(noiDaoTao))
                .collect(Collectors.toList());
        return dsSV;
    }
    // Danh sách sinh viên có điểm trung bình ở học kì gần nhất từ 8.0
    public List<SinhVienChinhQuy> danhSachSVDiem8(){
        List<SinhVienChinhQuy> dsSV = this.danhSachSV.stream()
                .filter(o->(o.getKetQua().get(o.getKetQua().size()-1).getDiemTrungBinh() >= 8.0f))
                .collect(Collectors.toList());
        return dsSV;
    }
    // Lay diem trung binh cao nhat cho tung sinh vien


    // Xác định sinh viên có điểm trung bình bất kì học kì cao nhất
//    public SinhVienChinhQuy sVDiemTrungBinhCaoNhat(){
//
//    }
    // Sắp xếp sinh viên tăng dần theo loại và giảm dần theo năm học

    // Thống kê số lượng sinh viên theo vào năm học
    static int kq =0;
    public int thongKe(int namHoc){

        this.danhSachSV.forEach(o->{
            if (o.getNamVaoHoc() == namHoc){
                kq++;
            }
        });
        return kq;
    }
}
