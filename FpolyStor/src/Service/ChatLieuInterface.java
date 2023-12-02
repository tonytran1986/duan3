/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.ChatLieu;
import java.util.ArrayList;


/**
 *
 * @author H
 */
public interface ChatLieuInterface {
    ArrayList<ChatLieu> getAll();
    int add(ChatLieu cl);
    int update(ChatLieu cl, String id);
}
