package com.cg.apps.itemms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.apps.itemms.entity.Item;

public interface IItemRepository extends JpaRepository<Item,String> {

}
