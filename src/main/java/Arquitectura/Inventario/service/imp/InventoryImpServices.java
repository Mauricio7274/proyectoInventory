package Arquitectura.Inventario.service.imp;

import Arquitectura.Inventario.model.dto.InventoryDto;
import Arquitectura.Inventario.model.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Arquitectura.Inventario.model.dao.InventoryDao;
import org.springframework.transaction.annotation.Transactional;
import Arquitectura.Inventario.service.IInventoryService;

import java.util.List;

@Service
public class InventoryImpServices implements IInventoryService{
    @Autowired
    private InventoryDao inventoryDao;

    @Override
    public List<Inventory> listAll() {
        return (List) inventoryDao.findAll();
    }

    @Transactional
    @Override
    public Inventory save(InventoryDto inventoryDto) {
        Inventory inventory = Inventory.builder()
                .id(inventoryDto.getId())
                .nombre(inventoryDto.getNombre())
                .cantidad(inventoryDto.getCantidad())
                .build();
        return inventoryDao.save(inventory);
    }

    @Transactional(readOnly = true)
    @Override
    public Inventory findById(Integer id) {
        return inventoryDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Inventory inventory) {
        inventoryDao.delete(inventory);
    }

    @Override
    public boolean existById(Integer id) {
        return inventoryDao.existsById(id);
    }
}
