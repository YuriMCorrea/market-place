package com.yuri.marketplace.registration.infrastructure.persistence.repository;

import com.yuri.marketplace.registration.domain.Customer;
import com.yuri.marketplace.registration.domain.CustomerId;
import com.yuri.marketplace.registration.domain.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

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
        var iterable = customerEntityRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(JpaCustomerRepository::mapper).toList();

    }

    private static com.yuri.marketplace.registration.infrastructure.persistence.entity.Customer mapper(Customer customer){
        return com.yuri.marketplace.registration.infrastructure.persistence.entity.Customer.builder()
                .id(customer.getId().id())
                .firstName(customer.getName())
                .email(customer.getEmail())
                .build();
        }

    private static Customer mapper(com.yuri.marketplace.registration.infrastructure.persistence.entity.Customer entity){
        String fullName = Optional.ofNullable(entity.getLastName())
                .map(lastName -> entity.getFirstName() + " " + lastName)
                .orElseGet(entity::getFirstName);

        return new Customer(new CustomerId(entity.getId()), fullName, entity.getEmail());
    }
}
