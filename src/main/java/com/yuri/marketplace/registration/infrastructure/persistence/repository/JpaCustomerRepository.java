package com.yuri.marketplace.registration.infrastructure.persistence.repository;

import com.yuri.marketplace.registration.domain.Customer;
import com.yuri.marketplace.registration.domain.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaCustomerRepository implements CustomerRepository {
    private final CustomerEntityRepository customerEntityRepository;

    public JpaCustomerRepository(CustomerEntityRepository customerEntityRepository) {
        this.customerEntityRepository = customerEntityRepository;
    }


    @Override
    public Customer save(Customer customer) {
        customerEntityRepository.save(mapper(customer));
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }

    private static com.yuri.marketplace.registration.infrastructure.persistence.entity.Customer mapper(Customer customer){
        return com.yuri.marketplace.registration.infrastructure.persistence.entity.Customer.builder()
                .id(customer.getId().id())
                .firstName(customer.getName())
                .email(customer.getEmail())
                .build();
        }
}
