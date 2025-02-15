/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author locpx
 */
public class Notifications {
    private int NotificationID;
    private int UserID;
    private int Message;
    private Date SendDate;
    
    //Contructor
    public Notifications() {
    }
    
    public Notifications(int NotificationID, int UserID, int Message, Date SendDate) {
        this.NotificationID = NotificationID;
        this.UserID = UserID;
        this.Message = Message;
        this.SendDate = SendDate;
    }
    
    //Getters and Setters

    public int getNotificationID() {
        return NotificationID;
    }

    public void setNotificationID(int NotificationID) {
        this.NotificationID = NotificationID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getMessage() {
        return Message;
    }

    public void setMessage(int Message) {
        this.Message = Message;
    }

    public Date getSendDate() {
        return SendDate;
    }

    public void setSendDate(Date SendDate) {
        this.SendDate = SendDate;
    }

    @Override
    public String toString() {
        return "Notifications{" + "NotificationID=" + NotificationID + ", UserID=" + UserID + ", Message=" + Message + ", SendDate=" + SendDate + '}';
    }


}
