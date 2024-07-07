package edu.utvt.attendance.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.utvt.attendance.persistence.entities.Item;
import edu.utvt.attendance.persistence.repositories.ItemRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemServiceImplementation implements ItemService {
	@Autowired
    private ItemRepository itemRepository;
	
	@Override
	public Item findById(Long id) {
		  return itemRepository.findById(id).orElse(null);
	}

	@Override
	public List<Item> findAll() {
		 return itemRepository.findAll();
	}

	@Override
	public Item save(Item item) {
		return itemRepository.save(item);
	}

	 @Override
	    public Item update(Long id, Item itemDetails) {
	        Item item = itemRepository.findById(id).orElse(null);
	        if (item != null) {
	            item.setNombre(itemDetails.getNombre());
	            item.setPrecio(itemDetails.getPrecio());
	            return itemRepository.save(item);
	        }
	        return null;
	    }
	 @Override
	    public void deleteById(Long id) {
	        itemRepository.deleteById(id);
	    }
}
