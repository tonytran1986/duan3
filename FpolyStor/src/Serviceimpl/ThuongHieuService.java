/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;

import DBcontext.DBConnection;
import Model.ThuongHieu;
import Service.ThuongHieuInterfacec;
import java.util.ArrayList;
import java.sql.*;



/**
 *
 * @author H
 */
public class ThuongHieuService implements ThuongHieuInterfacec{
        Connection con = DBConnection.openDbConnection();

    @Override
    public ArrayList<ThuongHieu> getAll() {
        ArrayList<ThuongHieu> list = new ArrayList<>();
        String sql = "select * from ThuongHieu";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                ThuongHieu th = new ThuongHieu();
                th.setIdThuongHieu(rs.getString("id"));
                th.setTenThuongHieu(rs.getString("ten"));
                list.add(th);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(ThuongHieu th) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(ThuongHieu th, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
