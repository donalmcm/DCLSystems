package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

// Product Entity managed by the ORM
@Entity
public class FuelSales extends Model
{
    
        // Properties
        // Annotate id as the primary key
        @Id
        private int id;
        // Other fields marked as being required (for validation purposes)
        @Constraints.Required
        private String fuelType;
        
        @Constraints.Required
        private String date;
        
        @Constraints.Required
        private double unitSP;
        
        @Constraints.Required
        private double unitNet;
        
        @Constraints.Required
        private double unitCP;
        
        @Constraints.Required
        private double unitProfit;
        
        @Constraints.Required
        private int qtySold;
        
        @Constraints.Required
        private int valSold;
        
        @Constraints.Required
        private int net;
        
        @Constraints.Required
        private double profit;
        
        // Default constructor
        public FuelSales()
        {
            
        }
        
        // Constructor to initialise object
        public FuelSales(int id, String fuelType, String date, double unitSP, double unitNet, double unitCP, double unitProfit, int qtySold, int valSold, int net, double profit)
        {
            this.id = id;
            this.fuelType = fuelType;
            this.date = date;
            this.unitSP = unitSP;
            this.unitNet = unitNet;
            this.unitCP = unitCP;
            this.unitProfit = unitProfit;
            this.qtySold = qtySold;
            this.valSold = valSold;
            this.net = net;
            this.profit = profit;         
        }


    public int getId()
    {
	return id;
    }

    public void setId(int id)
    {
   	this.id = id;
    }

    public String getFuelType() 
    {
        return fuelType;
    }

    public void setFuelType(String fuelType) 
    {
        this.fuelType = fuelType;
    }

    public String getDate() 
    {
        return date;
    }

    public void setDate(String date) 
    {
        this.date = date;
    }

    public double getUnitSP() 
    {
        return unitSP;
    }

    public void setUnitSP(double unitSP) 
    {
        this.unitSP = unitSP;
    }

    public double getUnitNet() 
    {
        return unitNet;
    }

    public void setUnitNet(double unitNet) 
    {
        this.unitNet = unitNet;
    }

    public double getUnitCP() 
    {
        return unitCP;
    }

    public void setUnitCP(double unitCP) 
    {
        this.unitCP = unitCP;
    }

    public double getUnitProfit() 
    {
        return unitProfit;
    }

    public void setUnitProfit(double unitProfit) 
    {
        this.unitProfit = unitProfit;
    }

    public int getQtySold() 
    {
        return qtySold;
    }

    public void setQtySold(int qtySold) 
    {
        this.qtySold = qtySold;
    }

    public int getValSold() 
    {
        return valSold;
    }

    public void setValSold(int valSold) 
    {
        this.valSold = valSold;
    }

    public int getNet() 
    {
        return net;
    }

    public void setNet(int net) 
    {
        this.net = net;
    }

    public double getProfit() 
    {
        return profit;
    }

    public void setProfit(double profit) 
    {
        this.profit = profit;
    }


}
