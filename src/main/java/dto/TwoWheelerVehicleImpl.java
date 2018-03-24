package dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bike")
public class TwoWheelerVehicleImpl extends Vehicle {
    @Column(name = "STEERING_BAR")
    private String steeringBar;

    public String getSteeringBar() {
        return steeringBar;
    }

    public void setSteeringBar(String steeringBar) {
        this.steeringBar = steeringBar;
    }
}
