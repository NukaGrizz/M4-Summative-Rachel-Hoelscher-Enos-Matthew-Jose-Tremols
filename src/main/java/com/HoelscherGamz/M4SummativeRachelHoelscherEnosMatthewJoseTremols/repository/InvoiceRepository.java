package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.repository;

import com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findAllInvoicesByName(String name);
    List<Invoice> findAllInvoicesByStreet(String street);
    List<Invoice> findAllInvoicesByCity(String city);
    List<Invoice> findAllInvoicesByState(String state);
    List<Invoice> findAllInvoicesByZipcode(String zipcode);
    List<Invoice> findAllInvoicesByItemType(String itemType);
    List<Invoice> findAllInvoicesByItemId(Long itemId);
}
