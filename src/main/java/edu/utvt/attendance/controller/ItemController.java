package edu.utvt.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.utvt.attendance.persistence.entities.Item;
import edu.utvt.attendance.persistence.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {
	 @Autowired
	    private ItemService itemService;
	 
	 @GetMapping
	    public ResponseEntity<List<Item>> getAllItems() {
	        List<Item> items = itemService.findAll();
	        return ResponseEntity.ok().body(items);
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Item> getItemById(@PathVariable(value = "id") Long itemId) {
	        Item item = itemService.findById(itemId);
	        if (item == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(item);
	    }
	 
	 @PostMapping
	    public ResponseEntity<Item> createItem(@RequestBody Item item) {
	        Item createdItem = itemService.save(item);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<Item> updateItem(@PathVariable(value = "id") Long itemId,
	                                           @RequestBody Item itemDetails) {
	        Item updatedItem = itemService.update(itemId, itemDetails);
	        if (updatedItem == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(updatedItem);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteItem(@PathVariable(value = "id") Long itemId) {
	        itemService.deleteById(itemId);
	        return ResponseEntity.noContent().build();
	    }

}
