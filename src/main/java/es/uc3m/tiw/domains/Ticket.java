package es.uc3m.tiw.domains;


public class Ticket {
	Integer ticket_id;
	String code;
	Double price;
	String useremail;
	//String userid;
	String eventname;
	User user;
	Event event;
	String category;
public Integer getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(Integer ticket_id) {
		this.ticket_id = ticket_id;
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
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail=useremail;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() { return event; }
	public String getEventname() { return eventname; }
	public void setEvent(Event event) {
		this.event = event;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory() {
		return category;
	}
}
