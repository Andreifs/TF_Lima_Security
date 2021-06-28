package pe.edu.upc.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.sun.el.parser.ParseException;


import pe.edu.upc.spring.model.Plan;
import pe.edu.upc.spring.service.IPlanService;

@Controller
@RequestMapping("/plan")
public class PlanController {
	
	@Autowired
	private IPlanService pService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoPlanes(Map<String, Object> model) {
		model.put("listaPlanes", pService.listar());
		return "listPlan";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("plan", new Plan());
		return "plan";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Plan objPlan, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "plan";
		else {
			boolean flag;
			if(pService.buscarNombre(objPlan.getNombrePlan()).isEmpty() ||
					pService.buscarDescripcion(objPlan.getDescripcionPlan()).isEmpty())
			{
				flag=pService.insertar(objPlan);
			}
			else {
				model.addAttribute("mensaje", "Este Plan ya existe");
				return "redirect:/plan/irRegistrar";
			}
	
			if (flag)
				return "redirect:/plan/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/plan/irRegistrar";
			}
		}
	}
	
	/*@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Plan objPlan, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "plan";
		else {
			boolean flag = pService.insertar(objPlan);
			if (flag)
				return "redirect:/plan/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/plan/irRegistrar";
			}
		}
	}*/
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Plan> objPlan = pService.listarId(id);
		if(objPlan == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/plan/listar";
		}
		else {
			model.addAttribute("plan", objPlan);
			return "plan";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				pService.eliminar(id);
				model.put("listaPlanes", pService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaPlanes", pService.listar());
		}
		return "listPlan";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaPlanes", pService.listar());
		return "listPlan";
	}
	
	@RequestMapping("/irBuscar")
	public String buscar(Model model) {
		model.addAttribute("plan", new Plan());
		return "listPlan";
	}
	
	@RequestMapping("/buscar")
	public String findByCategory(Map<String, Object> model, 
								@ModelAttribute Plan plan) 
			throws ParseException	
	{
		List<Plan> listaPlanes;
		plan.setNombrePlan(plan.getNombrePlan());
		listaPlanes = pService.buscarNombre(plan.getNombrePlan());
		if (listaPlanes.isEmpty()) {
			listaPlanes = pService.buscarId(plan.getIdPlan());
		}
		if (listaPlanes.isEmpty()) {
			model.put("mensaje", "No se encontraron coincidencias");
		}
		model.put("listaPlanes", listaPlanes);
		return "listPlan";
	}
	
	
}
