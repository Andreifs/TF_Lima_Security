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

import pe.edu.upc.spring.model.DetalleServicioXPlan;
import pe.edu.upc.spring.model.Servicio;
import pe.edu.upc.spring.model.Plan;
import pe.edu.upc.spring.service.IDetalleServicioXPlanService;
import pe.edu.upc.spring.service.IServicioService;
import pe.edu.upc.spring.service.IPlanService;

@Controller
@RequestMapping("/detalleServicioXPlan")
public class DetalleServicioXPlanController {
	
	@Autowired
	private IDetalleServicioXPlanService dService;		
	@Autowired
	private IPlanService pService;
	@Autowired
	private IServicioService sService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoDetalleServicioXPlanes(Map<String,Object>model) {
		model.put("listaDetalleServicioXPlanes", dService.listar());
		return "listDetalleServicio";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		
		model.addAttribute("listaServicios", sService.listar());
		model.addAttribute("listaPlanes", pService.listar());
		
		model.addAttribute("detalleServicioXPlan", new DetalleServicioXPlan());
		model.addAttribute("plan", new Plan());
		model.addAttribute("servicio", new Servicio());
		
		return "detalleServicioXPlan";
	}
	
	@RequestMapping("/registrar")
	public String registrar (@ModelAttribute DetalleServicioXPlan objDetalleServicioXPlan,BindingResult binRes,Model model)
	throws ParseException
		{
			if(binRes.hasErrors()) {
			model.addAttribute("listaServicios", sService.listar());
			model.addAttribute("listaPlanes", pService.listar());
			return("detalleServicioXPlan");
			}
			else {
				boolean flag = dService.insertar(objDetalleServicioXPlan);
				if (flag)
					return "redirect:/detalleServicioXPlan/listar";
				else {
					model.addAttribute("mensaje", "Ocurrio un error");
					return "redirect:/detalleServicioXPlan/irRegistrar";
				}
			}
		}
		
	@RequestMapping("/modificar/{id}")
	public String modificar1(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException 
	{
		Optional<DetalleServicioXPlan> objDetalleServicioXPlan = dService.listarId(id);
		if(objDetalleServicioXPlan == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/detalleServicioXPlan/listar";
		}
		else {
			model.addAttribute("listaPlanes", pService.listar());
			model.addAttribute("listaServicios", sService.listar());
			
			if(objDetalleServicioXPlan.isPresent())
				objDetalleServicioXPlan.ifPresent(o -> model.addAttribute("detalleServicioXPlan" ,o ));
			return "detalleServicioXPlan";
		}
	}		
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				dService.eliminar(id);
				model.put("listaDetalleServicioXPlanes", dService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaDetalleServicioXPlanes", dService.listar());
		}
		return "listDetalleServicio";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaDetalleServicioXPlanes", dService.listar());
		return "listDetalleServicio";
	}
	
			
	
}
