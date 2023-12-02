/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;


import DBcontext.DBConnection;
import Model.NhaSX;
import Service.NhaSXInterface;
import java.util.ArrayList;

import java.sql.*;

/**
 *
 * @author H
 */
public class NhaSXService implements NhaSXInterface {

    Connection con = DBConnection.openDbConnection();

    @Override
    public ArrayList<NhaSX> getAll() {
        ArrayList<NhaSX> list = new ArrayList<>();
        String sql = "select * from NSX";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhaSX ns = new NhaSX();
                ns.setIdNhaSX(rs.getString("id"));
                ns.setTenNhaSX(rs.getString("ten"));
                list.add(ns);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(NhaSX ns) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(NhaSX ns, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
