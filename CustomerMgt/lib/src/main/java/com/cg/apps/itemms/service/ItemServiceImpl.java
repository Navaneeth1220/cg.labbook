
package com.cg.apps.itemms.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.customerms.dao.ICustomerRepository;
import com.cg.apps.customerms.entity.Customer;
import com.cg.apps.customerms.exceptions.CustomerNotFoundException;
import com.cg.apps.customerms.exceptions.InvalidIdException;
import com.cg.apps.itemms.dao.IItemRepository;
import com.cg.apps.itemms.entity.Item;
import com.cg.apps.itemms.exception.ItemNotFoundException;

@Service
public class ItemServiceImpl implements IItemService {
	
	@Autowired
	IItemRepository dao;
	
	@Autowired
	ICustomerRepository cDao;
	
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
	
	@Transactional
	@Override
	public Item create(double price,String description) {
		String id=generateId();
		Item item = new Item(id,price,description);
		item=dao.save(item);
		return item;
	}

	@Override
	public Item findById(String id) {
		Optional<Item> item = dao.findById(id);
		if (!item.isPresent()) {
			throw new ItemNotFoundException("Item not available for this id, Invalid customer id");
		}
		return item.get();
	}
	
	@Transactional
	@Override
	public Item buyItem(String itemId, Long customerId) {
		validateId(customerId);
		validateItemId(itemId);
		
		Optional<Item> item = dao.findById(itemId);
		if (!item.isPresent()) {
			throw new ItemNotFoundException("Item not available for this id, Invalid customer id");
		}
		Item item1=item.get();
		
		Optional<Customer> customer = cDao.findById(customerId);
		if(!customer.isPresent()) {
			throw new CustomerNotFoundException("Customer not found");
		}
		
		Customer customer1=customer.get();
		
		item1.setBoughtBy(customer1);
		item1=dao.save(item1);
		
		Set<Item> items = customer1.getBoughtItems();
		if(items==null) {
			items=new HashSet<>();
			customer1.setBoughtItems(items);
		}
		
		
		
		items.add(item1);
		cDao.save(customer1);
		
		return item1;
	}
	
	
	 void validateId(Long id)
    {
        if(id<0)
        {
            throw new InvalidIdException("ID can't be negative");
        }
    }

    void validateItemId(String id)
    {
        if(id==null || id.isEmpty() || id.trim().isEmpty())
        {
            throw new InvalidIdException("ID can't be null");
        }
    }
	

	

	
	
}

