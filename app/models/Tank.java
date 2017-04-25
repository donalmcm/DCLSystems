//Author Dónal McManus
package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;


// Tank Entity managed by the ORM
@Entity
public class Tank extends Model
{
    // Properties
    // Annotate id as the primary key
    @Id
    private int id;
    // Other fields marked as being required (for validation purposes)
    @Constraints.Required
    private String name;
    
    @Constraints.Required
    private int capacity;
    
    @Constraints.Required
    private int dip;
    
    @Constraints.Required
    private int ullage;
    
    // Default constructor
    public Tank()
    {
        
    }
    
    public Tank(int id, String name, int capacity, int dip, int ullage)
    {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.dip = dip;
        this.ullage = ullage;
    }

    public static Finder<Long,Tank> find = new Finder<Long,Tank>(Tank.class);

    public static List<Tank> findAll(){
        return Tank.find.all();
    }

    /*public int getTotal(){
        int sum=0;
        for(int i=0; i < findAll().size(); i++)
        {


        }
        return sum;
    }*/

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getCapacity() 
    {
        return capacity;
    }

    public void setCapacity(int capacity) 
    {
        this.capacity = capacity;
    }

    public int getDip() 
    {
        return dip;
    }

    public void setDip(int dip) 
    {
        this.dip = dip;
    }

    public int getUllage() 
    {
        return ullage;
    }

    public void setUllage(int ullage) 
    {
        this.ullage = ullage;
    }

    public int getPercentage()
    {
        int percentage = (getDip()/getCapacity())*100;
        return  percentage;
    }

    
    

}

