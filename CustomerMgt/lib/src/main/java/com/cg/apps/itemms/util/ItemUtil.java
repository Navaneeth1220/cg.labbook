package com.cg.apps.itemms.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.cg.apps.itemms.dto.ItemDetails;
import com.cg.apps.itemms.entity.Item;

@Component
public class ItemUtil {
	
	public ItemDetails toDetails(Item item) {
		ItemDetails details = new ItemDetails(item.getId(),item.getPrice(),item.getDesc());
		return details;
	}
	
	public Set<ItemDetails> toDetails(Collection<Item> items){
		Set<ItemDetails> list = new HashSet<>();
		
		for(Item item:items) {
			ItemDetails details=toDetails(item);
			list.add(details);
		}
		return list;
	}
}
