package com.cg.apps.itemms.service;


import com.cg.apps.itemms.entity.Item;

public interface IItemService {
	
	Item create(double price,String description);
	Item findById(String id);
	Item buyItem(String itemId,Long customerId);
}
