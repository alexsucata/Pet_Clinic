package com.alexsucata.veterinarians;


import com.alexsucata.consults.ConsultEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "veterinarians")
public class VeterinarianEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer veterinarianId;
    private String firstName;
    private String lastName;
    private String address;
    private String speciality;
    @OneToMany(mappedBy = "veterinarianId")
    private List<ConsultEntity>consultEntities;

    public VeterinarianEntity() {
    }

    public Integer getVeterinarianId() {
        return veterinarianId;
    }

    public void setVeterinarianId(Integer veterinarianId) {
        this.veterinarianId = veterinarianId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "VeterinarianEntity{" +
                "veterinarianId=" + veterinarianId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
