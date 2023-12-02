/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;

import DBcontext.DBConnection;
import Model.Size;
import Service.SizeInterface;
import java.util.ArrayList;

import java.sql.*;

/**
 *
 * @author H
 */
public class SizeService implements SizeInterface {

    Connection con = DBConnection.openDbConnection();

    @Override
    public ArrayList<Size> getAll() {
        ArrayList<Size> list = new ArrayList<>();
        String sql = "select * from KichCo";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Size s = new Size();
                s.setIdSize(rs.getString("id"));
                s.setTenSize(rs.getString("ten"));
                list.add(s);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(Size s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Size s, String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
