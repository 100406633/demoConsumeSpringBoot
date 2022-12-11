package es.uc3m.tiw.domains;


public class Ticket {
	Integer id;
	String code;
	Double price;
	//String userid;
	//Integer eventid;
	User user;
	Event event;
	//String category;
public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}
	/*public String getuserid() {
		return user.getEmail();
	}
	public String getuserid() {
		return userid;
	}*/
	public void setUser(User user) {
		this.user = user;
	}
	/*public void setuserid(String userid) {
		this.userid = userid;
	}*/
	public Event getEvent() { return event; }
	/*public Integer getEventid() { return eventid; }*/
	public void setEvent(Event event) {
		this.event = event;
	}
	/*public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory() {
		return category;
	}*/
}
