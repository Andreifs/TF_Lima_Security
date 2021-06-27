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

import pe.edu.upc.spring.model.Compra;
import pe.edu.upc.spring.model.DetalleServicioXPlan;
import pe.edu.upc.spring.model.Pago;
import pe.edu.upc.spring.model.Plan;
import pe.edu.upc.spring.service.ICompraService;
import pe.edu.upc.spring.service.IPagoService;

@Controller
@RequestMapping("/pago")
public class PagoController {
	
	@Autowired
	private IPagoService pgService;
	
	@Autowired
	private ICompraService cService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoPagos(Map<String, Object> model) {
		model.put("listaPagos", pgService.listar());
		return "listPago";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("listaCompras", cService.listar());
		
		model.addAttribute("pago", new Pago());
		model.addAttribute("compra", new Compra());
		
		return "pago";
	}
	

	
	@RequestMapping("/registrar")
	public String registrar (@ModelAttribute Pago objPago,BindingResult binRes,Model model)
	throws ParseException
		{
			if(binRes.hasErrors()) {
			model.addAttribute("listaCompras", cService.listar());
			return("detalleServicioXPlan");
			}
			else {
				boolean flag = pgService.insertar(objPago);
				if (flag)
					return "redirect:/pago/bienvenido";
				else {
					model.addAttribute("mensaje", "Ocurrio un error");
					return "redirect:/pago/irRegistrar";
				}
			}
		}
	
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaPagos", pgService.listar());
		return "listPago";
	}
	
	
	
	
}