package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
public class FuelPrice extends Model
{
    @Id
    private Long id;

    @Constraints.Required
    private String name;

    @Constraints.Required
    private double price;

    public FuelPrice() {}

    public FuelPrice(Long id, String name, double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static Finder<Long,FuelPrice> find = new Finder<Long,FuelPrice>(FuelPrice.class);

    public static List<FuelPrice> findAll(){return FuelPrice.find.all();}

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
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

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
