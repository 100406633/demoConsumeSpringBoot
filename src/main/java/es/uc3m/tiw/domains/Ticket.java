package es.uc3m.tiw.domains;


public class Ticket {
	Integer id;
	String code;
	Double price;
	
	User user;

	String userEmail;
	Event event;

	Integer eventid;

	String category;
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
	public String getUserEmail() {
		return user.getEmail();
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Event getEvent() { return event; }
	public Integer getEventid() { return event.getId(); }
	public void setEvent(Event event) {
		this.event = event;
	}
	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory() {
		return event.getCategory();
	}
}
