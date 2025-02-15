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
public class Warehouse {
    private int WarehouseID;
    private int ProductID;
    private int StockLevel;
    private Date LastUpdated;
    
    //Contructors
    public Warehouse(){}

    public Warehouse(int WarehouseID, int ProductID, int StockLevel, Date LastUpdated) {
        this.WarehouseID = WarehouseID;
        this.ProductID = ProductID;
        this.StockLevel = StockLevel;
        this.LastUpdated = LastUpdated;
    }

    public int getWarehouseID() {
        return WarehouseID;
    }

    public void setWarehouseID(int WarehouseID) {
        this.WarehouseID = WarehouseID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getStockLevel() {
        return StockLevel;
    }

    public void setStockLevel(int StockLevel) {
        this.StockLevel = StockLevel;
    }

    public Date getLastUpdated() {
        return LastUpdated;
    }

    public void setLastUpdated(Date LastUpdated) {
        this.LastUpdated = LastUpdated;
    }

    @Override
    public String toString() {
        return "Warehouse{" + "WarehouseID=" + WarehouseID + ", ProductID=" + ProductID + ", StockLevel=" + StockLevel + ", LastUpdated=" + LastUpdated + '}';
    }
    
    
}


