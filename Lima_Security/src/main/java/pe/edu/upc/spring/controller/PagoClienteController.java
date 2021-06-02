package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Pago;
import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.model.PagoCliente;

import pe.edu.upc.spring.service.IPagoService;
import pe.edu.upc.spring.service.IUsuarioService;
import pe.edu.upc.spring.service.IPagoClienteService;

@Controller
@RequestMapping("/pagocliente")
public class PagoClienteController {

		@Autowired
		private IPagoService rService;
		@Autowired
		private IUsuarioService dService;
		@Autowired
		private IPagoClienteService pService;
		
		@RequestMapping("/bienvenido")
		public String irPaginaBienvenida() {
			return "bienvenido";
		}
		
		@RequestMapping("/")
		public String irPaginaListadoPagos(Map<String,Object>model) {
			model.put("listaPagosClientes", pService.listar());
			return "listPagoCliente";
		}
		
		@RequestMapping("/irRegistrar")
		public String irPaginaRegistrar(Model model) {
			
			model.addAttribute("listaPagos", rService.listar());
			model.addAttribute("listaUsuario", dService.listar());
			
			model.addAttribute("pago", new Pago());
			model.addAttribute("usuario", new Usuario());
			model.addAttribute("pagocliente", new PagoCliente());
			
			return "pagocliente";
		}
		
		@RequestMapping("/registrar")
		public String registrar (@ModelAttribute PagoCliente objPagoCliente,BindingResult binRes,Model model)
		throws ParseException
			{
				if(binRes.hasErrors()) {
				model.addAttribute("listaPagos", rService.listar());
				model.addAttribute("listaUsuario", dService.listar());
				return("pagocliente");
				}
				else {
					boolean flag = pService.insertar(objPagoCliente);
					if (flag)
						return "redirect:/pagocliente/listar";
					else {
						model.addAttribute("mensaje", "Ocurrio un error");
						return "redirect:/pagocliente/irRegistrar";
					}
				}
			}
			
		@RequestMapping("/modificar/{id}")
		public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
		{
			Optional<PagoCliente> objPagoCliente = pService.listarId(id);
			if(objPagoCliente == null) {
				objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
				return "redirect:/pagocliente/listar";
			}
			else {
				model.addAttribute("listaPagos", rService.listar());
				model.addAttribute("listaUsuario", dService.listar());
				
				if(objPagoCliente.isPresent())
					objPagoCliente.ifPresent(o -> model.addAttribute("pagocliente" ,o ));
				return "pagocliente";
			}
		}		
			
		@RequestMapping("/eliminar")
		public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
			try {
				if (id != null && id>0) {
					pService.eliminar(id);
					model.put("listaPagosClientes", pService.listar());
				}
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				model.put("mensaje", "Ocurrio un error");
				model.put("listaPagosClientes", pService.listar());
			}
			return "listPagoCliente";
		}
		
		@RequestMapping("/listar")
		public String listar(Map<String, Object> model) {
			model.put("listaPagosClientes", pService.listar());
			return "listPagoCliente";
		}
		
		
		
}
