/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;


import DBcontext.DBConnection;
import Model.DanhMuc;
import Service.DanhMucInterface;
import java.util.ArrayList;


import java.sql.*;


/**
 *
 * @author H
 */
public class DanhMucService implements DanhMucInterface{
 Connection con = DBConnection.openDbConnection();
    @Override
    public ArrayList<DanhMuc> getAll() {
        ArrayList<DanhMuc> list = new ArrayList<>();
        String sql = "select * from DanhMucSP";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                DanhMuc dm = new DanhMuc();
                dm.setIdDanhMuc(rs.getString("id"));
                dm.setTenDanhMuc(rs.getString("ten"));
                list.add(dm);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(DanhMuc dm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(DanhMuc dm, String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
