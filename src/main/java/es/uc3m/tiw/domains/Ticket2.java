package es.uc3m.tiw.domains;


import javax.persistence.*;

public class Ticket2 {
    private Integer id;

    private String code;

    private String type;

    private Double price;

    private User user;

    private Event event;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() { return event; }

    public void setEvent(Event event) {
        this.event = event;
    }
}