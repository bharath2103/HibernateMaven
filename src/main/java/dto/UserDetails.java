package dto;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity (name = "USER_DETAILS")
public class UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int userId;

    @Column(name = "Name")
    private String userName;

    @Column(name = "age")
    private int userAge;

    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "description")
    @Lob 
    private String description;

    @ElementCollection
    private Set<UserAddress> listOfUserAddress = new HashSet<>();


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

    public Set<UserAddress> getListOfUserAddress() {
        return listOfUserAddress;
    }

    public void setListOfUserAddress(Set<UserAddress> listOfUserAddress) {
        this.listOfUserAddress = listOfUserAddress;
    }
}
