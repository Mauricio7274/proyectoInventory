package Arquitectura.Inventario.service;


import Arquitectura.Inventario.model.dto.InventoryDto;
import Arquitectura.Inventario.model.entity.Inventory;

import java.util.List;
public interface IInventoryService {
    List<Inventory> listAll();

    Inventory save(InventoryDto cliente);
    Inventory findById (Integer id);
    void delete (Inventory cliente);
    boolean existById(Integer id);
}
