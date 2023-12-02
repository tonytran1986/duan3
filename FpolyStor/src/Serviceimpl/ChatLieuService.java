/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serviceimpl;

import DBcontext.DBConnection;
import Model.ChatLieu;
import Service.ChatLieuInterface;
import java.util.ArrayList;
import Model.ChatLieu;

import java.sql.*;

/**
 *
 * @author H
 */
public class ChatLieuService implements ChatLieuInterface {

    Connection con = DBConnection.openDbConnection();

    @Override
    public ArrayList<ChatLieu> getAll() {
        ArrayList<ChatLieu> list = new ArrayList<>();
        String sql = "select * from chatlieu";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieu ms = new ChatLieu();
                ms.setIdChatLieu(rs.getString("id"));
                ms.setTenChatLieu(rs.getString("ten"));
                list.add(ms);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(ChatLieu cl) {
        String sql = """
                     INSERT INTO ChatLieu
                     (
                         ten
                     )
                     VALUES
                     (?
                         )""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cl.getTenChatLieu());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(ChatLieu cl, String id) {
        String sql = """
                     UPDATE ChatLieu SET ten =? 
                     	WHERE id=?""";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cl.getTenChatLieu());
            ps.setString(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
