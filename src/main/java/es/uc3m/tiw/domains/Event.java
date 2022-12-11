package es.uc3m.tiw.domains;


import java.util.Set;

public class Event {
	Integer eventid;
	String name;
	String venue;
	String city;
	String country;
	String date;
	String category;
	byte[] image;
	Set<Ticket> tickets;


	public Integer getEventid() {
		return eventid;
	}

	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Set<Ticket> getTickets() {
		return this.tickets;
	}
}

