/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Size;
import java.util.ArrayList;


/**
 *
 * @author H
 */
public interface SizeInterface {
    ArrayList<Size> getAll();
    int add(Size s);
    int update(Size s, String ma);
}
