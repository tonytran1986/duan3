/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;


import Model.KhachHang;
import Model.KhachHang02;
import java.util.List;



/**
 *
 * @author PC
 */
public interface KhachHangService {

    List<KhachHang> getall();

    List<KhachHang02> getall02();

    boolean add(KhachHang khachhang);

    boolean update(int id, KhachHang khachhang);

    boolean delete(int id);

    public List<KhachHang> GetTK(String SDT);

    public List<KhachHang02> GetTKTheoIDKH(int ID);

    List<KhachHang> SeachTheoSDT(String SDT);

    Integer updateDiemKhachHang(String SDT, int diem);

    String kiemtra(String mail);

    String kiemtrasdt(String sdt);
    
    public List<KhachHang> loadPaging(int pageNum,int fetchRow);

}
