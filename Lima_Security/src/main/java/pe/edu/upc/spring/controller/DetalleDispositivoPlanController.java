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

import pe.edu.upc.spring.model.DetalleDispositivoPlan;
import pe.edu.upc.spring.model.Dispositivo;
import pe.edu.upc.spring.model.Plan;
import pe.edu.upc.spring.service.IDetalleDispositivoPlanService;
import pe.edu.upc.spring.service.IDispositivoService;
import pe.edu.upc.spring.service.IPlanService;

@Controller
@RequestMapping("/detalleDispositivoPlan")
public class DetalleDispositivoPlanController {
	
	@Autowired
	private IDetalleDispositivoPlanService dpService;		
	@Autowired
	private IPlanService pService;
	@Autowired
	private IDispositivoService dService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoDetalleDispositivoPlanes(Map<String,Object>model) {
		model.put("listaDetalleDispositivoPlanes", dpService.listar());
		return "listDetalleDispositivo";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		
		model.addAttribute("listaDispositivos", dService.listar());
		model.addAttribute("listaPlanes", pService.listar());
		
		model.addAttribute("detalleDispositivoPlan", new DetalleDispositivoPlan());
		model.addAttribute("plan", new Plan());
		model.addAttribute("dispositivo", new Dispositivo());
		
		return "detalleDispositivoPlan";
	}
	
	@RequestMapping("/registrar")
	public String registrar (@ModelAttribute DetalleDispositivoPlan objDetalleDispositivoPlan,BindingResult binRes,Model model)
	throws ParseException
	{
		if(binRes.hasErrors()) {
		model.addAttribute("listaDispositivoss", dService.listar());
		model.addAttribute("listaPlanes", pService.listar());
		return("detalleDispositivoPlan");
		}
		else {
			boolean flag = dpService.insertar(objDetalleDispositivoPlan);
			if (flag)
				return "redirect:/detalleDispositivoPlan/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/detalleDispositivoPlan/irRegistrar";
			}
		}
	}
		
	@RequestMapping("/modificar/{id}")
	public String modificar1(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException 
	{
		Optional<DetalleDispositivoPlan> objDetalleDispositivoPlan = dpService.listarId(id);
		if(objDetalleDispositivoPlan == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/detalleDispositivoPlan/listar";
		}
		else {
			model.addAttribute("listaPlanes", pService.listar());
			model.addAttribute("listaDispositivos", dService.listar());
			
			if(objDetalleDispositivoPlan.isPresent())
				objDetalleDispositivoPlan.ifPresent(o -> model.addAttribute("detalleDispositivoPlan" ,o ));
			return "detalleDispositivoPlan";
		}
	}		
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				dpService.eliminar(id);
				model.put("listaDetalleDispositivoPlanes", dpService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaDetalleDispositivoPlanes", dpService.listar());
		}
		return "listDetalleDispositivo";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaDetalleDispositivoPlanes", dpService.listar());
		return "listDetalleDispositivo";
	}
	
			
	
}
