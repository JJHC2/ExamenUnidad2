package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import edu.utvt.attendance.persistence.entities.Item;


public interface ItemService {
	    public Item findById(Long id);
	    public List<Item> findAll();
	    public Item save(Item item);
	    public Item update(Long id, Item itemDetails);
	    void deleteById(Long id);
}
