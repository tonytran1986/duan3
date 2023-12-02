/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;

import DBcontext.DBConnection;
import Model.MauSac;
import Service.MauSacInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author H
 */
public class MauSacService implements MauSacInterface {

    Connection con = DBConnection.openDbConnection();

    @Override
    public ArrayList<MauSac> getAll() {
        ArrayList<MauSac> list = new ArrayList<>();
        String sql = "select * from MauSac";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setIdMau(rs.getString("id"));
                ms.setTenMau(rs.getString("ten"));
                list.add(ms);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int them(MauSac ms) {
        String sql = """
                     INSERT INTO MauSac
                     (
                         ten
                     )
                     VALUES
                     (?
                         )""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ms.getTenMau());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public int sua(MauSac ms, String id) {
        String sql = """
                     UPDATE MauSac SET ten =? 
                     	WHERE id=?""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ms.getTenMau());
            ps.setString(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
