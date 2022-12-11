
package es.uc3m.tiw.controllers;

import es.uc3m.tiw.domains.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller
public class Consumer {

	@Autowired
	RestTemplate restTemplate;
	
	// NAVEGACION 
	@RequestMapping("/")	
	public String index(){
		return "index";
	}

	@RequestMapping("/u")
	public String index_u(){
		return "index_users";
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

		User us = restTemplate.getForObject("http://localhost:11400/users/{name}", User.class, name);
		model.addAttribute("usuario", us);
		return "viewUser";

	}

	@RequestMapping (value = "pagina-usuario", method = RequestMethod.POST)
	public String returnUsuariosByNameInForm(Model model, @RequestParam String name) {
		User us = restTemplate.getForObject("http://localhost:11400/users/{name}", User.class, name);
		model.addAttribute("usuario", us);
		return "viewUser";

	}

	@RequestMapping (value = "pagina-todos-usuarios", method = RequestMethod.GET)
	public String returnTodosUsuarios(Model model) {
		User[] listaUs = restTemplate.getForObject("http://localhost:11400/users", User[].class);
		model.addAttribute("userList", listaUs);
		return "viewAllUsers";
	}

	@RequestMapping (value = "pagina-post-usuario", method = RequestMethod.POST)
	public String saveUser(Model model, @ModelAttribute User us) {
		User newUser = restTemplate.postForObject("http://localhost:11400/users", us, User.class);
		model.addAttribute("usuario", us);
		return "index_users";
	}
	@RequestMapping (value = "pagina-search-usuario", method = RequestMethod.POST)
	public String searchUsuarios(Model model,@RequestParam Integer id) {
		User us = restTemplate.getForObject("http://localhost:11400/users/{id}", User.class, id);
		model.addAttribute("usuario", us);
		return "viewUser";
	}
	@RequestMapping (value = "pagina-search-upd-usuario", method = RequestMethod.POST)
	public String searchUpdUsuarios(Model model,@RequestParam Integer id) {
		User us = restTemplate.getForObject("http://localhost:11400/users/{id}", User.class, id);
		model.addAttribute("usuario", us);
		return "viewUpdateUsuario";

	}
	@RequestMapping (value = "pagina-delete-usuario", method={RequestMethod.POST, RequestMethod.DELETE})
	public String deleteUser(@RequestParam Integer id){
		//User delUser = restTemplate.getForObject("http://localhost:11400/users/{id}", User.class, id);
		//if (delUser != null)
		System.out.println("id: "+id);
		restTemplate.delete("http://localhost:11400/users/{id}", id);
		return "index_users";
		//}else{
		//	return "error";
		//}
	}
	@RequestMapping (value = "pagina-update-usuario", method={RequestMethod.POST, RequestMethod.PUT})
	public String updateUser(Model model, @ModelAttribute User us){
		restTemplate.put("http://localhost:11400/users/{id}", us, us.getId());
		return "index_users";
	}



	//**********************************EVENTS*******************************************
	@RequestMapping("/e")
	public String index_e(){
		return "index_events";
	}


	@RequestMapping (value = "pagina-crear-evento", method = RequestMethod.GET)
	public String mostrarElFormularioDelevento(Model modelo){
		modelo.addAttribute("event", new Event());
		return "ViewCrearevento.html";
	}
	
	@RequestMapping (value = "pagina-borrar-evento", method = RequestMethod.GET)
	public String mostrarElFormularioBorrarevento(){
		return "ViewDeleteEvento.html";
	}

	@RequestMapping (value = "pagina-actualizar-evento", method = RequestMethod.GET)
	public String mostrarElFormularioUpdateevento(Model modelo){
		modelo.addAttribute("event", new Event());
		return "ViewUpdateEvento.html";
	}

	// LLAMADAS AL CONTROLADOR
	@RequestMapping (value = "pagina-evento/{name}", method = RequestMethod.GET)
	public String returneventos(Model model, @PathVariable String name) {
		Event ev = restTemplate.getForObject("http://localhost:11403/events/{name}", Event.class, name);
		model.addAttribute("event", ev);
		return "viewEvent";
	}

	@RequestMapping (value = "pagina-evento", method = RequestMethod.POST)
	public String returneventosByNameInForm(Model model, @RequestParam String name) {
		Event ev = restTemplate.getForObject("http://localhost:11403/events/{name}", Event.class, name);
		model.addAttribute("event", ev);
		return "viewEvent";
	}


	@RequestMapping (value = "pagina-todos-eventos", method = RequestMethod.GET)
	public String returnTodoseventos(Model model) {
		Event[] listaEv = restTemplate.getForObject("http://localhost:11403/events", Event[].class);
		model.addAttribute("eventList", listaEv);
		return "viewAllEvents";
	}


	@RequestMapping (value = "pagina-post-evento", method = RequestMethod.POST)
	public String saveEvent(Model model, @ModelAttribute Event ev) {
		Event newEvent = restTemplate.postForObject("http://localhost:11403/events", ev, Event.class);
		model.addAttribute("event", ev);
		return "index_events";
	}

	@RequestMapping (value = "pagina-delete-evento", method={RequestMethod.POST, RequestMethod.DELETE})
	public String deleteEvent( @RequestParam String id){
		restTemplate.delete("http://localhost:11403/events/{id}", id);
		return "index_events";

	}

	@RequestMapping (value = "pagina-search-evento", method = RequestMethod.POST)
	public String searcheventos(Model model, @RequestParam Integer id) {
		Event ev = restTemplate.getForObject("http://localhost:11403/events/{name}", Event.class, id);
		model.addAttribute("event", ev);
		return "viewEvent";
	}

	@RequestMapping (value = "pagina-search-upd-evento", method = RequestMethod.POST)
	public String searchUpdEventos(Model model,@RequestParam Integer id) {
		Event ev = restTemplate.getForObject("http://localhost:11403/events/{name}", Event.class, id);
		model.addAttribute("event", ev);
		return "viewUpdateEvento";
	}
	@RequestMapping (value = "pagina-update-evento", method={RequestMethod.POST, RequestMethod.PUT})
	public String updateEvent(Model model, @ModelAttribute Event ev){
		restTemplate.put("http://localhost:11403/events/{name}", ev, ev.getId());
		return "index_events";
	}

	//****************************************TICKET***************************************
	@RequestMapping("/t")
	public String index_t(){
		return "index_tickets";
	}

	@RequestMapping (value = "pagina-crear-ticket", method = RequestMethod.GET)
	public String mostrarElFormularioDelticket(Model modelo){
		modelo.addAttribute("ticket", new Ticket());
		return "ViewCrearticket.html";
	}


	@RequestMapping (value = "pagina-borrar-ticket", method = RequestMethod.GET)
	public String mostrarElFormularioBorrarticket(){
		return "ViewDeleteticket.html";
	}

	@RequestMapping (value = "pagina-actualizar-ticket", method = RequestMethod.GET)
	public String mostrarElFormularioUpdateticket(Model modelo){
		modelo.addAttribute("ticket", new Ticket());
		return "ViewUpdateticket.html";
	}

	// LLAMADAS AL CONTROLADOR
	@RequestMapping (value = "pagina-ticket/{code}", method = RequestMethod.GET)
	public String returntickets(Model model, @PathVariable String code) {
		Ticket tick = restTemplate.getForObject("http://localhost:11402/tickets/{code}", Ticket.class, code);
		model.addAttribute("ticket", tick);
		return "viewTicket";
	}

	@RequestMapping (value = "pagina-ticket", method = RequestMethod.POST)
	public String returnticketsBycodeInForm(Model model, @RequestParam String code) {
		Ticket tick = restTemplate.getForObject("http://localhost:11402/tickets/{name}", Ticket.class, code);
		model.addAttribute("ticket", tick);
		return "viewTicket";
	}
	@RequestMapping (value = "pagina-todos-tickets", method = RequestMethod.GET)
	public String returnTodostickets(Model model) {
		Ticket[] listaTk = restTemplate.getForObject("http://localhost:11402/tickets", Ticket[].class);
		for (Ticket ti : listaTk) {
			ti.setUseremail(ti.getUser().getEmail());
			ti.setEventname(ti.getEvent().getName());
			ti.setCategory(ti.getEvent().getCategory());
		}
		model.addAttribute("ticketList", listaTk);
		return "viewAllTickets";
	}
	@RequestMapping (value = "pagina-post-ticket", method = RequestMethod.POST)
	public String saveTicket(Model model, @ModelAttribute Ticket tk) {
		System.out.println("userid: "+ tk.getUserid() + "ev id: " +tk.getEventid());
		restTemplate.postForObject("http://localhost:11402/tickets", tk , Ticket.class);
		model.addAttribute("ticket", tk);
		return "index_tickets";

	}
	@RequestMapping (value = "pagina-delete-ticket", method={RequestMethod.POST, RequestMethod.DELETE})
	public String deleteTicket(@RequestParam String ticket_id){
		Ticket delTicket = restTemplate.getForObject("http://localhost:11402/tickets/{id}", Ticket.class, ticket_id);

		if (delTicket != null) {
			restTemplate.delete("http://localhost:11402/tickets/{id}", ticket_id);
			return "index_tickets";
		}else{
			return "error";
		}
	}
	@RequestMapping (value = "pagina-search-ticket", method = RequestMethod.POST)
	public String searchtickets(Model model, @RequestParam Integer ticket_id) {
		Ticket ti = restTemplate.getForObject("http://localhost:11402/tickets/{id}", Ticket.class, ticket_id);
		model.addAttribute("ticket", ti);
		ti.setUseremail(ti.getUser().getEmail());
		ti.setEventname(ti.getEvent().getName());
		ti.setCategory(ti.getEvent().getCategory());
		return "viewTicket";
	}

	@RequestMapping (value = "pagina-search-upd-ticket", method = RequestMethod.POST)
	public String searchUPDtickets(Model model, @RequestParam Integer ticket_id) {
		Ticket2 ti2 = restTemplate.getForObject("http://localhost:11402/tickets/{id}", Ticket2.class, ticket_id);
		System.out.println(ti2.getUser().getId());
		Ticket ti = new Ticket();
		ti.setTicket_id(ti2.getId());
		ti.setCode(ti2.getCode());
		ti.setType(ti2.getType());
		ti.setPrice(ti2.getPrice());
		ti.setUserid(ti2.getUser().getId());
		ti.setEventid(ti2.getEvent().getId());
		ti.setCategory(ti2.getEvent().getCategory());
		model.addAttribute("ticket", ti);
		return "viewUpdateticket";

	}

	@RequestMapping (value = "pagina-update-ticket", method={RequestMethod.POST, RequestMethod.PUT})
	public String updateTicket(Model model, @ModelAttribute Ticket tk){
		System.out.println(tk.getTicket_id());

		restTemplate.put("http://localhost:11402/tickets/{id}", tk, tk.getTicket_id());
		return "index_tickets";
	}
}
