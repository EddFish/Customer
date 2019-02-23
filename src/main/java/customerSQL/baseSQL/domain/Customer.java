package customerSQL.baseSQL.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"customerName"})

@Entity

public class Customer implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   @Id
   String customerName;
   
   @OneToMany(mappedBy="customer")
   Set<Account> accounts;
   
   
}
