/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.User;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Admin
 */
public interface IUserRepostory {
    ArrayList<User> getAllUsers();
    public int login(User u) ;
    List<User> getUser( String TaiKhoan ,String MatKhau);
}
