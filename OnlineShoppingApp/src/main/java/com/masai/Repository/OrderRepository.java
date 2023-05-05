package com.masai.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.Exception.OrderException;
import com.masai.model.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
	
	public List<Orders> findByOrderDate(LocalDate orderDate) throws OrderException;
	
	@Query("select e from orders e inner join address a on a.address_id=e.AID where a.city = ?1")
	public List<Orders> findByOrderByCity(String city) throws OrderException;
	
}
