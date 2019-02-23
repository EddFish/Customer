package customerSQL.baseSQL.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customerSQL.baseSQL.domain.Customer;


public interface ICustomerRepository extends JpaRepository<Customer, String> {

}
