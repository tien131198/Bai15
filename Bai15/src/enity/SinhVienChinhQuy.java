package enity;

import java.time.LocalDate;
import java.util.List;

/* Welcome to project
    @author: tienb
    Date: 11/6/2022
    Time: 7:45 PM
    
    ProjectName: Bai15
*/public class SinhVienChinhQuy {
    protected String maSV;
    protected String ten;
    protected LocalDate ngaySinh;
    protected int namVaoHoc;
    protected int diemDauVao;
    protected List<KetQuaHocTap> ketQua;

    public SinhVienChinhQuy() {
    }

    public SinhVienChinhQuy(String maSV, String ten, LocalDate ngaySinh, int namVaoHoc, int diemDauVao, List<KetQuaHocTap> ketQua) {
        this.maSV = maSV;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.namVaoHoc = namVaoHoc;
        this.diemDauVao = diemDauVao;
        this.ketQua = ketQua;
    }

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

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getNamVaoHoc() {
        return namVaoHoc;
    }

    public void setNamVaoHoc(int namVaoHoc) {
        this.namVaoHoc = namVaoHoc;
    }

    public int getDiemDauVao() {
        return diemDauVao;
    }

    public void setDiemDauVao(int diemDauVao) {
        this.diemDauVao = diemDauVao;
    }

    public List<KetQuaHocTap> getKetQua() {
        return ketQua;
    }

    public void setKetQua(List<KetQuaHocTap> ketQua) {
        this.ketQua = ketQua;
    }

    @Override
    public String toString() {
        return "SinhVienChinhQuy{" +
                "maSV='" + maSV + '\'' +
                ", ten='" + ten + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", namVaoHoc=" + namVaoHoc +
                ", diemDauVao=" + diemDauVao +
                ", ketQua=" + ketQua +
                '}';
    }
}
