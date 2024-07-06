package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.utvt.attendance.persistence.entities.Item;
import edu.utvt.attendance.persistence.repositories.ItemRepository;

@Service
public class ItemServiceImplementation implements ItemService {
	@Autowired
	private ItemRepository itemrepository;
	
	
	@Transactional(readOnly = false)
	public Item save(Item item) {
		return this.itemrepository.save(item);
	}

	@Transactional(readOnly= false)
	public Item update(Long id, Item item) {
		Optional<Item> itemoptional = null;
		itemoptional = this.findById(id);
		
		if(itemoptional.isPresent()) {
			
			itemoptional.get().setNombre(item.getNombre());
			itemoptional.get().setPrecio(item.getPrecio());
			itemoptional.get().setPerson(item.getPerson());
			return itemrepository.save(item);
			
		}
		return itemoptional.orElseThrow();
	}

	
	@Override
	public List<Item> getAll() {
		return this.itemrepository.findAll();
	}


	@Transactional(readOnly = false)
	public ResponseEntity<Item> deleteById(Long id) {
		
		Optional<Item> itemOptional = null;		
		ResponseEntity<Item> responseEntity = null;
		
		
		itemOptional =  this.itemrepository.findById(id);
		
		if (itemOptional.isPresent()) {
			
			this.itemrepository.delete(itemOptional.get());
			responseEntity = ResponseEntity.noContent().build();
		} else {
			responseEntity = ResponseEntity.notFound().build();
		}
			
		
		return responseEntity;
	}
	
	@Override
	public Optional<Item> findById(Long id) {
		return itemrepository.findById(id);
	}

	@Override
	public Page<Item> get(int page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

}
