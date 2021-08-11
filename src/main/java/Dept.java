

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Dept
 *
 */
@Entity
public class Dept implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 
	private long id;
	private String Name;
	private static final long serialVersionUID = 1L;	
	public Dept() {
		super();
	} 
	   
	public String getName() {
 		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
	   
	public long getId() {
 		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
   
}
