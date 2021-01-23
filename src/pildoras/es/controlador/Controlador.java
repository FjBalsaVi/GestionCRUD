package pildoras.es.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pildoras.es.controlador.entity.Cliente;
import pildoras.es.dao.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@RequestMapping("/lista")
	public String listaClientes(Model elModelo) {
		
		List<Cliente> clientes = clienteDAO.getClientes();
		
		elModelo.addAttribute("clientes", clientes);
		
		return "lista-clientes";
	}
	
	@RequestMapping("/muestraFormularioAgregar")
	public String muestraFormularioAgregar(Model elModelo) {
		
		Cliente elCliente=new Cliente();
		
		elModelo.addAttribute("cliente", elCliente);
		
		return "formularioCliente";
	}
	
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente elCliente) {
		
		// Insertar Cliente en BBDD
		
		clienteDAO.insertarCliente(elCliente);
		
		return "redirect:/cliente/lista";
	}
}
