/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author H
 */
public class ChatLieu {
     private String idChatLieu;
    private String tenChatLieu;

    public ChatLieu() {
    }

    public ChatLieu(String idChatLieu, String tenChatLieu) {
        this.idChatLieu = idChatLieu;
        this.tenChatLieu = tenChatLieu;
    }

    public String getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(String idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }
    
}
