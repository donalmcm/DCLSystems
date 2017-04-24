package models;

import java.util.*;
import javax.persistence.*;

import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity
public class RewardMember extends Model
{
    @Id
    private Long id;

    @Constraints.Required
    private String name;

    @Constraints.Required
    private String address;

    @Constraints.Required
    private String contactNumber;

    @Constraints.Required
    private int points;

    // Default constructor
    public RewardMember(){}

    // constructor to initialise object
    public RewardMember(Long id, String name, String address, String contactNumber, int points)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.points = points;
    }

    public static Finder<Long, RewardMember> find = new Finder<Long,RewardMember>(RewardMember.class);

    public static List<RewardMember> findAll() {
        return RewardMember.find.all();
    }

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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
