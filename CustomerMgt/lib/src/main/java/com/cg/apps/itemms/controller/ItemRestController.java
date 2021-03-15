package com.cg.apps.itemms.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.customerms.service.ICustomerService;
import com.cg.apps.itemms.dto.ItemDetails;
import com.cg.apps.itemms.entity.Item;
import com.cg.apps.itemms.service.IItemService;
import com.cg.apps.itemms.util.ItemUtil;

@RequestMapping("/items")
@RestController
public class ItemRestController {
	
	@Autowired
	private IItemService service;
	
	@Autowired
	private ItemUtil util;
	
	@Autowired
	private ICustomerService cService;
	
	@GetMapping("/byid/{id}")
	private Set<ItemDetails> itemsBought(@PathVariable("id") long id){
		
		Set<Item> items=cService.itemBoughtByCustomer(id);
		Set<ItemDetails> itemsDetails=util.toDetails(items);
		return itemsDetails;
	}
}
