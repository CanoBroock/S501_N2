package cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.CanoBroock.Cesar.s05.t01.n02.model.services.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FlorController {
    @Autowired
    private FlorService florService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listSucursales", florService.getAllSucursales());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        // create model attribute to bind form data
        Sucursal sucursal = new Sucursal();
        model.addAttribute("sucursal", sucursal);
        return "new_sucursal";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("sucursal") Sucursal sucursal) {
        // save sucursal to database
        florService.saveSucursal(sucursal);
        return "redirect:/";
    }

    @GetMapping("/getOne/{id}")
    public String getOne(@PathVariable(value = "id") long id, Model model) {

        // get sucursal from the service
        Sucursal sucursal = florService.getSucursalById(id);

        // set sucursal as a model attribute to pre-populate the form
        model.addAttribute("sucursal", sucursal);
        return "update_sucursal";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") long id) {

        // llamamos al metodo eliminar
        this.florService.deleteSucursalById(id);
        return "redirect:/";
    }
}
