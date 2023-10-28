package Arquitectura.Inventario.model.dao;
import Arquitectura.Inventario.model.entity.Inventory;
import org.springframework.data.repository.CrudRepository;
public interface InventoryDao extends CrudRepository <Inventory, Integer> {
}
