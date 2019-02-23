package customerSQL.baseSQL.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customerSQL.baseSQL.domain.Account;

public interface IAccountRepository extends JpaRepository<Account, String>{

}
