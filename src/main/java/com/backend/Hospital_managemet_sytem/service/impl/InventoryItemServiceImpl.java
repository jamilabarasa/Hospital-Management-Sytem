package com.backend.Hospital_managemet_sytem.service.impl;

import com.backend.Hospital_managemet_sytem.security.exceptions.ResourceNotFoundException;
import com.backend.Hospital_managemet_sytem.model.InventoryItem;
import com.backend.Hospital_managemet_sytem.repository.InventoryItemRepository;
import com.backend.Hospital_managemet_sytem.service.InventoryItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class InventoryItemServiceImpl implements InventoryItemService {

    private InventoryItemRepository inventoryItemRepository;

    public InventoryItemServiceImpl(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }


    @Override
    public InventoryItem createInventoryItem(InventoryItem inventoryItem) {
        log.debug("Request to save inventory Item {}",inventoryItem);
        return inventoryItemRepository.save(inventoryItem);
    }

    @Override
    public InventoryItem updateInventoryItem(InventoryItem inventoryItem) {
        log.debug("Request to update inventory Item {}",inventoryItem);
        //check if it exists
        InventoryItem inventoryItem1 = inventoryItemRepository.findById(inventoryItem.getId()).orElseThrow(()->
                new ResourceNotFoundException("Inventory Item not found with ID {}"+inventoryItem.getId()));

        inventoryItem1.setDescription(inventoryItem.getDescription());
        inventoryItem1.setName(inventoryItem.getName());
        inventoryItem1.setUnit(inventoryItem.getUnit());
        inventoryItem1.setQuantity(inventoryItem.getQuantity());
        inventoryItem1.setExpirationDate(inventoryItem.getExpirationDate());

        log.debug("About to save updated Inventory Item {}",inventoryItem1);

        return inventoryItemRepository.save(inventoryItem1);
    }

    @Override
    public List<InventoryItem> getAllInventoryItems() {
        log.debug("Request to get all Inventory Items");
        List<InventoryItem> inventoryItems = inventoryItemRepository.findAll();
        return inventoryItems;
    }

    @Override
    public InventoryItem getInventoryItemById(Long id) {

        log.debug("Request to get inventoryItem  by ID {}",id);
        //check if it exists
        InventoryItem inventoryItem = inventoryItemRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Inventory Item not found with ID {}"+id));

        return inventoryItem;
    }

    @Override
    public List<InventoryItem> getInventoryItemByExpiryDate(LocalDate date) {
        log.debug("Request to get all Inventory Items by expiry date");
        List<InventoryItem> inventoryItems = inventoryItemRepository.findAllByExpirationDate(date);
        return inventoryItems;
    }
}
