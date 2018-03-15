package dto;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity (name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int userId;

    @Column(name = "NAME")
    private String userName;

    @Column(name = "AGE")
    private int userAge;

    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "DESCRIPTION")
    @Lob 
    private String description;

    @ElementCollection
    @JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    @GenericGenerator(name = "sequence-gen", strategy = "sequence")
    @CollectionId(columns = {@Column(name = "ADDRESS_ID")}, type = @Type(type = "long"), generator = "sequence-gen")
    private Collection<UserAddress> listOfUserAddress = new ArrayList<>();


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<UserAddress> getListOfUserAddress() {
        return listOfUserAddress;
    }

    public void setListOfUserAddress(Collection<UserAddress> listOfUserAddress) {
        this.listOfUserAddress = listOfUserAddress;
    }
}
