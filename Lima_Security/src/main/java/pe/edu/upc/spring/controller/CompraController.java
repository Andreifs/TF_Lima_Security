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
import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.model.Compra;
import pe.edu.upc.spring.model.DetalleDispositivoPlan;
import pe.edu.upc.spring.model.DetalleServicioXPlan;
import pe.edu.upc.spring.service.IPlanService;
import pe.edu.upc.spring.service.IUsuarioService;
import pe.edu.upc.spring.service.ICompraService;

@Controller
@RequestMapping("/compra")
public class CompraController {

		@Autowired
		private IPlanService pService;

		@Autowired
		private ICompraService cService;
		
		@RequestMapping("/bienvenido")
		public String irPaginaBienvenida() {
			return "bienvenido";
		}
		
		@RequestMapping("/")
		public String irPaginaListadoPagos(Map<String,Object>model) {
			model.put("listaCompras", cService.listar());
			return "compra";
		}
		
		@RequestMapping("/irListar")
		public String IrPaginaCompra(Map<String, Object> model) {
			model.put("listaCompras", cService.listar());
			return "compra";
		}
		
		@RequestMapping("/registrar/{id}")
		public String registrar (@PathVariable int id,Compra objCompra ,BindingResult binRes,Model model)
		throws ParseException{
			objCompra =new Compra();
			Optional<Plan> objPlan =pService.listarId(id);
			objCompra.setPlan(objPlan.get());
			if(objPlan.isPresent())
				objPlan.ifPresent(o -> model.addAttribute("compra" ,id ));
				if(binRes.hasErrors()) {
				model.addAttribute("listaCompras", cService.listar());
				return("compra");
				}
				else {
					boolean flag = cService.insertar(objCompra);
					if (flag)
						return "redirect:/compra/irListar";
					else {
						model.addAttribute("mensaje", "Ocurrio un error");
						return "redirect:/compra/listar";
					}
				}
			}
			
		@RequestMapping("/eliminar")
		public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
			try {
				if (id != null && id>0) {
					cService.eliminar(id);
					model.put("listaCompras", cService.listar());
				}
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				model.put("mensaje", "Ocurrio un error");
				model.put("listaCompras", cService.listar());
			}
			return "compra";
		}
		
		@RequestMapping("/listar")
		public String listar(Map<String, Object> model) {
			model.put("listaPlanes", pService.listar());
			return "listPlanClient";
		}
		
		@RequestMapping("/listar2")
		public String listar2(Map<String, Object> model) {
			model.put("listaCompras", cService.listar());
			return "listCompra";
		}
		
		
		
		
		
}
