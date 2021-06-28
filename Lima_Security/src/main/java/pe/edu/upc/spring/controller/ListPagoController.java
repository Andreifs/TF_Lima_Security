package pe.edu.upc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listPago")
public class ListPagoController {
	
	public String irPaginaListPago() {
		return "listPago";
	}

}
