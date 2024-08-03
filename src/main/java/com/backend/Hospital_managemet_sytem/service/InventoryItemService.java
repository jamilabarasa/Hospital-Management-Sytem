package com.backend.Hospital_managemet_sytem.service;

import com.backend.Hospital_managemet_sytem.model.InventoryItem;

import java.time.LocalDate;
import java.util.List;

public interface InventoryItemService {

    //create inventory item
    //update inventory item
    //get all inventory items
    //get inventory items by id
    //get inventory items by expiry date

    InventoryItem createInventoryItem(InventoryItem inventoryItem);

    InventoryItem updateInventoryItem(InventoryItem inventoryItem);

    List<InventoryItem> getAllInventoryItems();

    InventoryItem getInventoryItemById(Long id);

    List<InventoryItem> getInventoryItemByExpiryDate(LocalDate date);


}
