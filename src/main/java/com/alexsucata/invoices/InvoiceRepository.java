package com.alexsucata.invoices;

import java.util.List;

public interface InvoiceRepository {

    void create(InvoiceEntity invoice);

    InvoiceEntity findById(Integer invoiceNo);

    List<InvoiceEntity> findAll();

    void update(InvoiceEntity invoiceNo, InvoiceEntity invoice);

    void delete(Integer invoiceNo);

}
