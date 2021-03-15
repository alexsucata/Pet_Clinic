package com.alexsucata.invoices;


import com.alexsucata.consults.ConsultEntity;
import com.alexsucata.owners.OwnerEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer invoiceNo;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "ownerId")
    private OwnerEntity owner;
    @OneToMany(mappedBy = "consultId")
    private List<ConsultEntity>consults;

    public InvoiceEntity() {
    }

    public Integer getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(Integer invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    public List<ConsultEntity> getConsults() {
        return consults;
    }

    public void setConsults(List<ConsultEntity> consults) {
        this.consults = consults;
    }
}
