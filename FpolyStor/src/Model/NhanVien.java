
package Model;

import java.util.Date;


public class NhanVien {
    private String id;
    private String ten, tendem, ho;
    private Date ngaysinh;
    private boolean gioitinh;
    private String sdt;
    private String tk;
    private String mk;
    private String email;
//    private Chucvu chucvu;
    private boolean TT;

    public NhanVien() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTendem() {
        return tendem;
    }

    public void setTendem(String tendem) {
        this.tendem = tendem;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Chucvu getChucVu() {
//        return chucvu;
//    }
//
//    public void setChucVu(Chucvu chucvu) {
//        this.chucvu = chucvu;
//    }

    public boolean isTT() {
        return TT;
    }

    public void setTT(boolean TT) {
        this.TT = TT;
    }

//    public String getgt(int gt) {
//        return gt == 1 ? "Nam" : "Nữ";
//    }

}
