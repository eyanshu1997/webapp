

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rl
 *
 */
@Entity

public class Report implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String des;
	private String date;
	private String dept;
	private boolean status;
	private String type;
	private static final long serialVersionUID = 1L;

	public Report() {
		super();
	}   
	public String getDes() {
		return this.des;
	}

	public void setDes(String desc) {
		this.des = desc;
	}   
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}   
	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}   
	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
   
}
