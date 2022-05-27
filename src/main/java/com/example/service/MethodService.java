package com.example.service;


import com.example.entities.Method;

import com.example.repository.MethodRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MethodService implements CrudService<Method,Long> {

	private MethodRepository methodRepository;

	@Override
	public JpaRepository<Method, Long> getJpaRepository() {
		return methodRepository;
	}
	
}
