package dto;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class StudentMarks {

    private Integer tamil;
    private Integer english;
    private Integer mathematics;
    private Integer science;
    private Integer socialScience;

    public Integer getTamil() {
        return tamil;
    }

    public void setTamil(Integer tamil) {
        this.tamil = tamil;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getMathematics() {
        return mathematics;
    }

    public void setMathematics(Integer mathematics) {
        this.mathematics = mathematics;
    }

    public Integer getScience() {
        return science;
    }

    public void setScience(Integer science) {
        this.science = science;
    }

    public Integer getSocialScience() {
        return socialScience;
    }

    public void setSocialScience(Integer socialScience) {
        this.socialScience = socialScience;
    }
}
