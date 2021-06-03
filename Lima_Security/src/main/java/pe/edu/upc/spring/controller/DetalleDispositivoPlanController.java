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

import pe.edu.upc.spring.model.Plan;
import pe.edu.upc.spring.service.IPlanService;
import pe.edu.upc.spring.model.Dispositivo;
import pe.edu.upc.spring.model.DetalleDispositivoPlan;
import pe.edu.upc.spring.service.IDispositivoService;
import pe.edu.upc.spring.service.IDetalleDispositivoPlanService;


@Controller
@RequestMapping("/DetalleDispositivoPlan")
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
	public String irPaginaListadoMascotas(Map<String,Object>model) {
		model.put("listaMascotas", pService.listar());
		return "listPets";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		
		model.addAttribute("listaRazas", rService.listar());
		model.addAttribute("listaDueno", dService.listar());
		

	}
	
	public void insertar() {
		try {
			ddService.insertar(detalleDispositivoPlan);
			limpiarDetalleDispositivoPlan();
			this.listDetalleDispositivoPlan();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
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
	
	public List<Plan> getListaPlanes() {
		return listaPlanes;
	}
	
	