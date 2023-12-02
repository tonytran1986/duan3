/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.DanhMuc;
import java.util.ArrayList;


/**
 *
 * @author H
 */
public interface DanhMucInterface {
    ArrayList<DanhMuc> getAll();
    int add(DanhMuc dm);
    int update(DanhMuc dm, String ma);
    
}
