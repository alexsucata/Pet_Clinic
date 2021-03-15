package com.alexsucata.pets;


import com.alexsucata.consults.ConsultEntity;
import com.alexsucata.owners.OwnerEntity;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "pets")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer petId;
    private String petName;
    private Integer age;
    private Boolean isVaccinated;
    private String gender;
    private String race;
    @ManyToOne
    @JoinColumn(name = "ownerId")
    private OwnerEntity ownerId;
    @OneToMany(mappedBy = "petId")
    private List<ConsultEntity> consultEntities;


    public PetEntity() {
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public OwnerEntity getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(OwnerEntity ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "PetsEntity{" +
                "petId=" + petId +
                ", petName='" + petName + '\'' +
                ", age=" + age +
                ", isVaccinated=" + isVaccinated +
                ", gender='" + gender + '\'' +
                ", race='" + race + '\'' +
                '}';
    }

    public void calculateAge(String birthday) {
        String today = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date());
        try {
            Date end = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.ENGLISH)
                    .parse(birthday);
            Date start = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.ENGLISH)
                    .parse(today);
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            int d1 = Integer.parseInt(formatter.format(end));
            int d2 = Integer.parseInt(formatter.format(start));
            int age = (d2 - d1) / 10000;
            this.age = age;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
