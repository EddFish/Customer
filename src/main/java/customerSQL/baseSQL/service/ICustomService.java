package customerSQL.baseSQL.service;

import customerSQL.baseSQL.dto.AccountDto;
import customerSQL.baseSQL.dto.CustomerDto;
import customerSQL.baseSQL.dto.SubscriberDto;

public interface ICustomService {

	boolean addSubscriber(String account, SubscriberDto subscriberDto);

	boolean addCustomer(CustomerDto customerDto);

	boolean addAccount(String customer, AccountDto accountDto);

	

}
