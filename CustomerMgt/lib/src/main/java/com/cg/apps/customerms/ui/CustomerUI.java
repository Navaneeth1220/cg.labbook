package com.cg.apps.customerms.ui;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.customerms.entity.Account;
import com.cg.apps.customerms.entity.Customer;
import com.cg.apps.customerms.service.ICustomerService;
import com.cg.apps.itemms.entity.Item;
import com.cg.apps.itemms.service.IItemService;

@Component
public class CustomerUI {

	@Autowired
	private ICustomerService service;

	@Autowired
	private IItemService iService;

	public void start() {
		try {
			LocalDateTime date = LocalDateTime.now();

			Customer stew = service.addCutomer("Prasanna");
			Customer nava = service.addCutomer("Navaneeth");

			service.addAmount(stew.getId(), 200000.0);
			service.addAmount(nava.getId(), 10000.0);

			Item item1 = iService.create(100.0, "RAM");
			Item item2 = iService.create(500.0, "Processor");

			Item ram = iService.buyItem(item1.getId(), stew.getId());
			Item processor = iService.buyItem(item2.getId(), nava.getId());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	void display(Customer customer) {
		Account account = customer.getAccount();
		System.out.println("Customer Id= " + customer.getId() + " \nCustomer name: " + customer.getName()
				+ " \nAccount number=" + account.getAccountId() + " \nBalance:" + account.getBalance());
	}

	void displayItem(Item item) {
		System.out.println(item.getId() + " " + item.getPrice() + " " + item.getDesc());
	}
}
