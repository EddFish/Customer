package customerSQL.baseSQL.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import customerSQL.baseSQL.domain.Subscriber;

public interface ISubscriberRepository extends JpaRepository<Subscriber, String>{
   	
   
}
