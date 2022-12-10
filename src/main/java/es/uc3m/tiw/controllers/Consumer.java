
package es.uc3m.tiw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import es.uc3m.tiw.domains.User;
//import es.uc3m.tiw.domains.Events;
//import es.uc3m.tiw.domains.Tickets;

@Controller
public class Consumer {

	@Autowired
	RestTemplate restTemplate;
	
	// NAVEGACION 
	@RequestMapping("/")	
	public String index(){
		return "index";
	}

	@RequestMapping (value = "pagina-crear-usuario", method = RequestMethod.GET)
	public String mostrarElFormularioDelUsuario(Model modelo){
		modelo.addAttribute("usuario", new User());
		return "ViewCrearUsuario.html";
	}

	@RequestMapping (value = "pagina-borrar-usuario", method = RequestMethod.GET)
	public String mostrarElFormularioBorrarUsuario(){
		return "ViewDeleteUsuario.html";
	}

	@RequestMapping (value = "pagina-actualizar-usuario", method = RequestMethod.GET)
	public String mostrarElFormularioUpdateUsuario(Model modelo){
		modelo.addAttribute("usuario", new User());
		return "ViewUpdateUsuario.html";
	}

	// LLAMADAS AL CONTROLADOR
	@RequestMapping (value = "pagina-usuario/{name}", method = RequestMethod.GET)
	public String returnUsuarios(Model model, @PathVariable String name) {

		User us = restTemplate.getForObject("http://localhost:8081/users/{name}", User.class, name);
		model.addAttribute("usuario", us);
		return "viewUser";

	}

	@RequestMapping (value = "pagina-usuario", method = RequestMethod.POST)
	public String returnUsuariosByNameInForm(Model model, @RequestParam String name) {
		User us = restTemplate.getForObject("http://localhost:8081/users/{name}", User.class, name);
		model.addAttribute("usuario", us);
		return "viewUser";

	}

	@RequestMapping (value = "pagina-todos-usuarios", method = RequestMethod.GET)
	public String returnTodosUsuarios(Model model) {
		User[] listaUs = restTemplate.getForObject("http://localhost:8081/users", User[].class);
		model.addAttribute("userList", listaUs);
		return "viewAllUsers";
	}


	@RequestMapping (value = "pagina-post-usuario", method = RequestMethod.POST)
	public String saveUser(Model model, @ModelAttribute User us) {
		User newUser = restTemplate.postForObject("http://localhost:8081/users", us, User.class);
		model.addAttribute("usuario", us);
		return "index";
	}
	@RequestMapping (value = "pagina-search-usuario", method = RequestMethod.POST)
	public String searchUsuarios(Model model,@RequestParam Integer id) {
		User us = restTemplate.getForObject("http://localhost:8081/users/{id}", User.class, id);
		model.addAttribute("usuario", us);
		return "viewUser";
	}
	@RequestMapping (value = "pagina-search-upd-usuario", method = RequestMethod.POST)
	public String searchUpdUsuarios(Model model,@RequestParam Integer id) {
		User us = restTemplate.getForObject("http://localhost:8081/users/{id}", User.class, id);
		model.addAttribute("usuario", us);
		return "viewUpdateUsuario";

	}
	@RequestMapping (value = "pagina-delete-usuario", method={RequestMethod.POST, RequestMethod.DELETE})
	public String deleteUser(@RequestParam Integer id){
		User delUser = restTemplate.getForObject("http://localhost:8081/users/{id}", User.class, id);
		if (delUser != null) {
			restTemplate.delete("http://localhost:8081/users/{id}", id);
			return "index";
		}else{
			return "error";
		}
	}
	@RequestMapping (value = "pagina-update-usuario", method={RequestMethod.POST, RequestMethod.PUT})
	public String updateUser(Model model, @ModelAttribute User us){
		System.out.println("id" + us.getIduser() + "name" + us.getName());
		restTemplate.put("http://localhost:8081/users/{id}", us, us.getIduser());
		return "index";
	}
/*
	@RequestMapping (value = "pagina-update-usuario", method={RequestMethod.POST, RequestMethod.PUT})
	public String updateUser( Model model, @RequestParam Integer id){
		User updUser = restTemplate.getForObject("http://localhost:8081/users/{id}", User.class, id);
		if (updUser != null) {
			restTemplate.put("http://localhost:8081/users/{id}", id, updUser);
			return "index";
		}else{
			return "error";
		}

	}*/

	/*
	//**********************************EVENTS*******************************************
	@RequestMapping (value = "pagina-crear-evento", method = RequestMethod.GET)
	public String mostrarElFormularioDelevento(Model modelo){
		modelo.addAttribute("evento", new Event());
		return "ViewCrearevento.html";
	}

	@RequestMapping (value = "pagina-borrar-evento", method = RequestMethod.GET)
	public String mostrarElFormularioBorrarevento(){
		return "ViewDeleteevento.html";
	}

	@RequestMapping (value = "pagina-update-evento", method = RequestMethod.GET)
	public String mostrarElFormularioUpdateevento(Model modelo){
		modelo.addAttribute("evento", new Event());
		return "ViewUpdateevento.html";
	}

	// LLAMADAS AL CONTROLADOR
	@RequestMapping (value = "pagina-evento/{name}", method = RequestMethod.GET)
	public String returneventos(Model model, @PathVariable String name) {

		Event us = restTemplate.getForObject("http://localhost:8081/events/{name}", Event.class, name);
		model.addAttribute("evento", us);
		return "viewAllEvents";

	}

	@RequestMapping (value = "pagina-evento", method = RequestMethod.POST)
	public String returneventosByNameInForm(Model model, @RequestParam String name) {
		Event us = restTemplate.getForObject("http://localhost:8081/events/{name}", Event.class, name);
		model.addAttribute("evento", us);
		return "viewAllEvents";

	}


	@RequestMapping (value = "pagina-todos-eventos", method = RequestMethod.GET)
	public String returnTodoseventos(Model model) {
		Event[] listaUs = restTemplate.getForObject("http://localhost:8081/events", Event[].class);
		model.addAttribute("eventList", listaUs);
		return "viewAllEvents";
	}


	@RequestMapping (value = "pagina-post-evento", method = RequestMethod.POST)
	public String saveEvent(Model model, @ModelAttribute Event us) {
		Event newEvent = restTemplate.postForObject("http://localhost:8081/events", us, Event.class);
		model.addAttribute("evento", us);
		return "viewAllEvents";
	}

	@RequestMapping (value = "pagina-delete-evento", method = RequestMethod.POST)
	public String deleteEvent(Model model, @RequestParam String eventName){
		Event delEvent = restTemplate.getForObject("http://localhost:8081/events/{name}", Event.class, eventName);
		if (delEvent != null) {
			restTemplate.delete("http://localhost:8081/events/{id}", delEvent.getIdevent());
		}
		return "index";
	}

	@RequestMapping (value = "pagina-search-evento", method = RequestMethod.POST)
	public String searcheventos(Model model, @RequestParam String name) {
		Event us = restTemplate.getForObject("http://localhost:8081/events/{name}", Event.class, name);
		model.addAttribute("evento", us);
		return "viewUpdateevento";

	}

	@RequestMapping (value = "pagina-update-evento", method = RequestMethod.POST)
	public String deleteEvent(Model model, @ModelAttribute Event us){
		restTemplate.put("http://localhost:8081/events", us, Event.class);
		return "index";
	}

	//****************************************TICKET***************************************
	@RequestMapping (value = "pagina-crear-ticket", method = RequestMethod.GET)
	public String mostrarElFormularioDelticket(Model modelo){
		modelo.addAttribute("ticket", new Ticket());
		return "ViewCrearticket.html";
	}

	@RequestMapping (value = "pagina-borrar-ticket", method = RequestMethod.GET)
	public String mostrarElFormularioBorrarticket(){
		return "ViewDeleteticket.html";
	}

	@RequestMapping (value = "pagina-update-ticket", method = RequestMethod.GET)
	public String mostrarElFormularioUpdateticket(Model modelo){
		modelo.addAttribute("ticket", new Ticket());
		return "ViewUpdateticket.html";
	}

	// LLAMADAS AL CONTROLADOR
	@RequestMapping (value = "pagina-ticket/{name}", method = RequestMethod.GET)
	public String returntickets(Model model, @PathVariable String name) {

		Ticket us = restTemplate.getForObject("http://localhost:8081/tickets/{name}", Ticket.class, name);
		model.addAttribute("ticket", us);
		return "viewAllTickets";

	}

	@RequestMapping (value = "pagina-ticket", method = RequestMethod.POST)
	public String returnticketsByNameInForm(Model model, @RequestParam String name) {
		Ticket us = restTemplate.getForObject("http://localhost:8081/tickets/{name}", Ticket.class, name);
		model.addAttribute("ticket", us);
		return "viewAllTickets";

	}


	@RequestMapping (value = "pagina-todos-tickets", method = RequestMethod.GET)
	public String returnTodostickets(Model model) {
		Ticket[] listaUs = restTemplate.getForObject("http://localhost:8081/tickets", Ticket[].class);
		model.addAttribute("ticketList", listaUs);
		return "viewAllTickets";
	}


	@RequestMapping (value = "pagina-post-ticket", method = RequestMethod.POST)
	public String saveTicket(Model model, @ModelAttribute Ticket us) {
		Ticket newTicket = restTemplate.postForObject("http://localhost:8081/tickets", us, Ticket.class);
		model.addAttribute("ticket", us);
		return "viewAllTickets";
	}

	@RequestMapping (value = "pagina-delete-ticket", method = RequestMethod.POST)
	public String deleteTicket(Model model, @RequestParam String ticketName){
		Ticket delTicket = restTemplate.getForObject("http://localhost:8081/tickets/{name}", Ticket.class, ticketName);
		if (delTicket != null) {
			restTemplate.delete("http://localhost:8081/tickets/{id}", delTicket.getIdticket());
		}
		return "index";
	}

	@RequestMapping (value = "pagina-search-ticket", method = RequestMethod.POST)
	public String searchtickets(Model model, @RequestParam String name) {
		Ticket us = restTemplate.getForObject("http://localhost:8081/tickets/{name}", Ticket.class, name);
		model.addAttribute("ticket", us);
		return "viewUpdateticket";

	}

	@RequestMapping (value = "pagina-update-ticket", method = RequestMethod.POST)
	public String deleteTicket(Model model, @ModelAttribute Ticket us){
		restTemplate.put("http://localhost:8081/tickets", us, Ticket.class);
		return "index";
	}*/
}
