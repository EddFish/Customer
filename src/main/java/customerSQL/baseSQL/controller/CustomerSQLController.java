package customerSQL.baseSQL.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import customerSQL.baseSQL.dto.AccountDto;
import customerSQL.baseSQL.dto.CustomerDto;
import customerSQL.baseSQL.dto.SubscriberDto;
import customerSQL.baseSQL.service.ICustomService;

@RestController

public class CustomerSQLController {

	 @Autowired
		ICustomService customerService;
	    
	    @PostMapping( "/subscriber/{account}")
	    public boolean addSubscriber(@PathVariable String account, @RequestBody SubscriberDto subscriberDto) {
	    	return customerService.addSubscriber(account, subscriberDto);
	    }
	    
	    @PostMapping( "/customer")
	    public boolean addCustomer(@RequestBody CustomerDto customerDto) {
	    	return customerService.addCustomer(customerDto);
	    }
	    
	    @PostMapping( "/account/{customer}")
	    public boolean addAccount(@PathVariable String customer, @RequestBody AccountDto accountDto) {
	    	return customerService.addAccount(customer, accountDto);
	    }
}
