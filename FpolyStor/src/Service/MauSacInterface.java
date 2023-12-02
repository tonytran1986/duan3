/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.MauSac;
import java.util.ArrayList;


/**
 *
 * @author H
 */
public interface MauSacInterface {
    ArrayList<MauSac> getAll();
    public int them(MauSac ms);
    public int sua(MauSac ms, String id);
}
