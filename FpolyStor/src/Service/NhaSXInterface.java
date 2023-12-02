/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.NhaSX;
import java.util.ArrayList;


/**
 *
 * @author H
 */
public interface NhaSXInterface {
    ArrayList<NhaSX> getAll();
    int add(NhaSX ns);
    int update(NhaSX ns, String id);
}
