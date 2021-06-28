package pe.edu.upc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listCompra")
public class ListCompraController {
	
	public String irPaginaBienvenida() {
		return "listCompra";
	}

}
