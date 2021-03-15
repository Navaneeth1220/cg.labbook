/*
package com.cg.apps.itemms.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.cg.apps.itemms.entity.Item;
import com.cg.apps.itemms.exception.ItemNotFoundException;

@Repository
public class ItemDaoImpl implements IItemDao {

	@PersistenceContext
	private EntityManager entity;
	
	public String generateId() {
		
		
		String charecters="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String id="";
		int length = 10;
		Random rand = new Random();
		char text[]=new char[length];
		
		for(int i=0;i<length;i++) {
			text[i]=charecters.charAt(rand.nextInt(charecters.length()));
		}
		
		for(int i=0;i<text.length;i++) {
			id+=text[i];
		}
		return id;
	}

	@Override
	public Item add(Item item) {
		entity.persist(item);
		return item;
	}

	@Override
	public Item findById(String id) {
		Item item = entity.find(Item.class, id);
		if(item==null) {
			throw new ItemNotFoundException("No item exists for ID="+id);
		}
		return item;
	}

	@Override
	public Item update(Item item) {
		item=entity.merge(item);
		return item;
	}
	
	
		
}
*/
