package com.cg.apps.departmentms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.apps.departmentms.entities.Department;
import com.cg.apps.departmentms.exceptions.DepartmentNotFound;

@Repository
public class DepartmentDaoImpl implements IDepartmentDao {

	@Autowired
	private EntityManager entity;

	@Override
	public Department add(Department dept) {
		entity.persist(dept);
		return dept;
	}

	@Override
	public Department findById(int deptId) {
		Department dept=entity.find(Department.class, deptId);
		if(dept==null) {
			throw new DepartmentNotFound("Department not found for ID= "+deptId);
		}
		return dept;
	}

	@Override
	public Department update(Department dept) {
		dept=entity.merge(dept);
		return dept;
	}

}
