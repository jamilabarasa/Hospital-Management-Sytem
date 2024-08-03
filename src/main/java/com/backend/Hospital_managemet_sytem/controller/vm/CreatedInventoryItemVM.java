package com.backend.Hospital_managemet_sytem.controller.vm;

import com.backend.Hospital_managemet_sytem.model.InventoryItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedInventoryItemVM {

    private InventoryItem inventoryItem;

    private SuccessReponseVM successReponseVM;
}
