package com.alexsucata.consults;


import com.alexsucata.invoices.InvoiceEntity;
import com.alexsucata.pets.PetEntity;
import com.alexsucata.veterinarians.VeterinarianEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consults")
public class ConsultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer consultId;
    private Date consultDate;
    private String description;
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "petId")
    private PetEntity petId;
    @ManyToOne
    @JoinColumn(name = "veterinarianId")
    private VeterinarianEntity veterinarianId;
    @ManyToOne
    @JoinColumn(name = "invoiceNo")
    private InvoiceEntity invoice;

    public ConsultEntity() {
    }

    public Integer getConsultId() {
        return consultId;
    }

    public void setConsultId(Integer consultId) {
        this.consultId = consultId;
    }

    public Date getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(Date consultDate) {
        this.consultDate = consultDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public PetEntity getPetId() {
        return petId;
    }

    public void setPetId(PetEntity petId) {
        this.petId = petId;
    }

    public VeterinarianEntity getVeterinarianId() {
        return veterinarianId;
    }

    public void setVeterinarianId(VeterinarianEntity veterinarianId) {
        this.veterinarianId = veterinarianId;
    }

    public InvoiceEntity getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntity invoice) {
        this.invoice = invoice;
    }
}
