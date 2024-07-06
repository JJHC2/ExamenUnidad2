package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import edu.utvt.attendance.persistence.entities.Item;



public interface ItemService {
	
	    public Item save(Item item);
		
		public Item update(Long id, Item item);
		
		public List<Item> getAll();
		
		public Optional<Item> findById(Long id);
		
		public ResponseEntity<Item> deleteById(Long id);	
		
		public Page<Item>get(int page, Integer size);
}
