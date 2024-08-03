package com.backend.Hospital_managemet_sytem.controller;

import com.backend.Hospital_managemet_sytem.controller.vm.CreatedAppointmentVM;
import com.backend.Hospital_managemet_sytem.controller.vm.CreatedInventoryItemVM;
import com.backend.Hospital_managemet_sytem.controller.vm.SuccessReponseVM;
import com.backend.Hospital_managemet_sytem.model.Appointment;
import com.backend.Hospital_managemet_sytem.model.InventoryItem;
import com.backend.Hospital_managemet_sytem.model.enumerations.Status;
import com.backend.Hospital_managemet_sytem.service.InventoryItemService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/inventory-items")
public class InventoryItemController {
    private InventoryItemService inventoryItemService;

    public InventoryItemController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    @PostMapping
    public ResponseEntity<CreatedInventoryItemVM> createInventoryItem(@Valid @RequestBody InventoryItem inventoryItem){
        log.debug("REST Request to save Inventory Item {}",inventoryItem);
        InventoryItem inventoryItem1 = inventoryItemService.createInventoryItem(inventoryItem);

        SuccessReponseVM successReponse = new SuccessReponseVM(
                "Inventory Item Created Successfully",
                String.valueOf(Status.SUCCESS),
                HttpStatus.CREATED.value(),
                System.currentTimeMillis()
        );
        CreatedInventoryItemVM createdInventoryItemVM = new CreatedInventoryItemVM(
                inventoryItem1,
                successReponse
        );
        return  new ResponseEntity<>(createdInventoryItemVM,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CreatedInventoryItemVM> updateInventoryItem(@Valid @RequestBody InventoryItem inventoryItem){
        log.debug("REST Request to update Inventory Item {}",inventoryItem);
        InventoryItem inventoryItem1 = inventoryItemService.updateInventoryItem(inventoryItem);

        SuccessReponseVM successReponse = new SuccessReponseVM(
                "Inventory Item Updated Successfully",
                String.valueOf(Status.SUCCESS),
                HttpStatus.OK.value(),
                System.currentTimeMillis()
        );
        CreatedInventoryItemVM createdInventoryItemVM = new CreatedInventoryItemVM(
                inventoryItem1,
                successReponse
        );
        return  new ResponseEntity<>(createdInventoryItemVM,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryItem> getInventoryItemById(@PathVariable long id){
        log.debug("REST Request to get InventoryItem by ID {}",id);
        InventoryItem inventoryItem = inventoryItemService.getInventoryItemById(id);
        return new ResponseEntity<>(inventoryItem,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<InventoryItem>> getAllInventoryItem(){
        log.debug("REST Request to get all InventoryItems");
        List<InventoryItem> inventoryItems = inventoryItemService.getAllInventoryItems();
        return new ResponseEntity<>(inventoryItems,HttpStatus.OK);
    }

    @GetMapping("/{expirydate}/expirydate")
    public ResponseEntity<List<InventoryItem>> getAllInventoryItemByExpiryDate(@PathVariable LocalDate expirydate){
        log.debug("REST Request to get all InventoryItems by expiration date  {}",expirydate);
        List<InventoryItem> inventoryItems = inventoryItemService.getInventoryItemByExpiryDate(expirydate);
        return new ResponseEntity<>(inventoryItems,HttpStatus.OK);
    }
}
