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
public class Reviews {
    private int ReviewID;
    private int ProductID;
    private int CustomerID;
    private int Rating;
    private String Comment;
    private Date ReviewDate;
    
    //Contructor

    public Reviews() {
    }

    public Reviews(int ReviewID, int ProductID, int CustomerID, int Rating, String Comment, Date ReviewDate) {
        this.ReviewID = ReviewID;
        this.ProductID = ProductID;
        this.CustomerID = CustomerID;
        this.Rating = Rating;
        this.Comment = Comment;
        this.ReviewDate = ReviewDate;
    }
    
    
    //Getters and Setters

    public int getReviewID() {
        return ReviewID;
    }

    public void setReviewID(int ReviewID) {
        this.ReviewID = ReviewID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public Date getReviewDate() {
        return ReviewDate;
    }

    public void setReviewDate(Date ReviewDate) {
        this.ReviewDate = ReviewDate;
    }
    
    //ToString

    @Override
    public String toString() {
        return "Reviews{" + "ReviewID=" + ReviewID + ", ProductID=" + ProductID + ", CustomerID=" + CustomerID + ", Rating=" + Rating + ", Comment=" + Comment + ", ReviewDate=" + ReviewDate + '}';
    }
    
}
