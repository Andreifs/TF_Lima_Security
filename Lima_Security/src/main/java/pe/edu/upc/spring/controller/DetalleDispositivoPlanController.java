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
import pe.edu.upc.spring.model.Dueno;
import pe.edu.upc.spring.model.Pet;
import pe.edu.upc.spring.model.Servicio;
import pe.edu.upc.spring.model.Dispositivo;

import pe.edu.upc.spring.model.Plan;
import pe.edu.upc.spring.model.Race;
import pe.edu.upc.spring.service.IDetalleDispositivoPlanService;
import pe.edu.upc.spring.service.IDuenoService;
import pe.edu.upc.spring.service.IPetService;
import pe.edu.upc.spring.service.IServicioService;
import pe.edu.upc.spring.service.IPlanService;
import pe.edu.upc.spring.service.IRaceService;


@Controller
@RequestMapping("/detalleDispositivoXPlan")
public class DetalleDispositivoXPlanController {
	
	@Autowired
	private IDetalleDispositivoXPlanService dService;
	
	
	@Autowired
	private IRaceDispositivo rService;
	@Autowired
	private IDuenoDispositivo dService;
	@Autowired
	private IPetDispositivo pService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoMascotas(Map<String,Object>model) {
		model.put("listaMascotas", pService.listar());
		return "listPets";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		
		model.addAttribute("listaRazas", rService.listar());
		model.addAttribute("listaDueno", dService.listar());
		
		model.addAttribute("race", new Race());
		model.addAttribute("dueno", new Dueno());
		model.addAttribute("pet", new Pet());
		
		return "pet";
	}
	
	@RequestMapping("/registrar")
	public String registrar (@ModelAttribute Pet objPet,BindingResult binRes,Model model)
	throws ParseException
		{
			if(binRes.hasErrors()) {
			model.addAttribute("listaRazas", rService.listar());
			model.addAttribute("listaDueno", dService.listar());
			return("pet");
			}
			else {
				boolean flag = pService.insertar(objPet);
				if (flag)
					return "redirect:/pet/listar";
				else {
					model.addAttribute("mensaje", "Ocurrio un error");
					return "redirect:/pet/irRegistrar";
				}
			}
		}
		
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException 
	{
		Optional<Pet> objPet = pService.listarId(id);
		if(objPet == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/pet/listar";
		}
		else {
			model.addAttribute("listaRazas", rService.listar());
			model.addAttribute("listaDueno", dService.listar());
			
			if(objPet.isPresent())
				objPet.ifPresent(o -> model.addAttribute("pet" ,o ));
			return "pet";
		}
	}		
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				pService.eliminar(id);
				model.put("listaMascotas", pService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaMascotas", pService.listar());
		}
		return "listPets";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaMascotas", pService.listar());
		return "listPets";
	}
	
	
	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoServicios(Map<String, Object> model) {
		model.put("listaServicios", sService.listar());
		return "listServicio";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("servicio", new Servicio());
		return "servicio";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Servicio objServ, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "servicio";
		else {
			boolean flag = sService.insertar(objServ);
			if (flag)
				return "redirect:/servicio/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/servicio/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Servicio> objDisp = sService.listarId(id);
		if(objDisp == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/servicio/listar";
		}
		else {
			model.addAttribute("servicio", objDisp);
			return "servicio";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				sService.eliminar(id);
				model.put("listaServicios", sService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaServicios", sService.listar());
		}
		return "listServicio";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaServicios", sService.listar());
		return "listServicio";
	}
	
	
	
	
}	
	