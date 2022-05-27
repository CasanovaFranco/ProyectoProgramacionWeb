package com.example.service;


import com.example.entities.Supplier;
import com.example.repository.SupplierRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SupplierService implements CrudService<Supplier,Long> {

	private SupplierRepository supplierRepository;

	@Override
	public JpaRepository<Supplier, Long> getJpaRepository() {
		return supplierRepository;
	}
	
}
