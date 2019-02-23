package customerSQL.baseSQL.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import customerSQL.baseSQL.dao.IAccountRepository;
import customerSQL.baseSQL.dao.ICustomerRepository;
import customerSQL.baseSQL.dao.ISubscriberRepository;
import customerSQL.baseSQL.domain.Account;
import customerSQL.baseSQL.domain.Customer;
import customerSQL.baseSQL.domain.Subscriber;
import customerSQL.baseSQL.dto.AccountDto;
import customerSQL.baseSQL.dto.CustomerDto;
import customerSQL.baseSQL.dto.SubscriberDto;

@Service

public class CustomerServiceImpl implements ICustomService{

	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	IAccountRepository accountRepository;
	
	@Autowired
	ISubscriberRepository subscriberRepository;

	@Override
	public boolean addSubscriber(String accountName, SubscriberDto subscriberDto) {
		Account account = accountRepository.findById(accountName).orElse(null);
		if (account == null) {
			return false;
		}
		Subscriber subscriber = subscriberRepository.findById(subscriberDto.getName()).orElse(null);
		if(subscriber != null) {
			return false;
		}
		subscriber = new Subscriber();
		subscriber.setSubscriberName(subscriberDto.getName());
		subscriber.setAccount(account);
		subscriberRepository.save(subscriber);
			
		return true;
		
	}

	@Override
	@Transactional
	public boolean addCustomer(CustomerDto customerDto) {
		boolean res = customerRepository.existsById(customerDto.getName());
		if (!res) {
			Customer customer = new Customer();
			customer.setCustomerName(customerDto.getName());
			customerRepository.save(customer);
		}
		return !res;
	}

	@Override
	@Transactional
	public boolean addAccount(String customerName, AccountDto accountDto) {
		Customer customer = customerRepository.findById(customerName).orElse(null);
		if(customer == null) {
			return false;
		}
		Account account = accountRepository.findById(accountDto.getName()).orElse(null);
		if (account != null) {
			return false;
		}
		account = new Account();
		account.setAccountName(accountDto.getName());
		account.setCustomer(customer);
		accountRepository.save(account);
			
		return true;
	}
	
	
}
