/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.ThuongHieu;
import java.util.ArrayList;


/**
 *
 * @author H
 */
public interface ThuongHieuInterfacec {
    ArrayList<ThuongHieu> getAll();
    int add(ThuongHieu th);
    int update(ThuongHieu th, String id);
}
