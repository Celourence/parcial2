package br.com.spring.parcial2.Controllers;

import br.com.spring.parcial2.Models.Cliente;
import br.com.spring.parcial2.Statement.ClienteStatement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.sql.SQLException;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @RequestMapping(value = "/novoCliente", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("cliente", new Cliente());
        return "novoCliente";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvar(@ModelAttribute Cliente cliente) throws SQLException {
        ClienteStatement.add(cliente);
        return "redirect:/clientes";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) throws SQLException{
        model.addAttribute("clientes", ClienteStatement.List());

        return "clientes";
    }

}
