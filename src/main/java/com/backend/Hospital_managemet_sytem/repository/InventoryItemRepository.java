package com.backend.Hospital_managemet_sytem.repository;

import com.backend.Hospital_managemet_sytem.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem,Long> {
    List<InventoryItem> findAllByExpirationDate(LocalDate date);
}
