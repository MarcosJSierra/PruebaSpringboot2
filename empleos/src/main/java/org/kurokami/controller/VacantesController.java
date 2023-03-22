package org.kurokami.controller;

import org.kurokami.model.Vacante;
import org.kurokami.service.IVacanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/vacantes")
@Controller
public class VacantesController {

    @Autowired
    private IVacanteService vacanteService;
    
    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") Integer idVacante, Model model){
        Vacante vacante = vacanteService.buscarPorId(idVacante);
        model.addAttribute("vacante", vacante);
        System.out.println("Vacante: "+ vacante.toString());
        return "detalle";
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model){
        System.out.println("Borrando vacante con ID: " + idVacante);
        model.addAttribute("id", idVacante);
        return "mensaje";
    }

    @GetMapping("/create")
    public String crear(){
        System.out.println("oie zi");
        return "vacantes/formVacante";
    }

    // @PostMapping("/save")
    // public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion, @RequestParam("estatus") String estatus,
    //     @RequestParam("fecha") String fecha, @RequestParam("destacado") int destacado, @RequestParam("salario") double salario, @RequestParam("detalles") String detalles){
        
    //         System.out.println("Nombre: " + nombre);
    //         System.out.println("Fecha: " + fecha);
    //         System.out.println("Descripcion: " + descripcion);
    //         System.out.println("Estatus: " + estatus);
    //         System.out.println("Destacado: " + destacado);
    //         System.out.println("Salario: " + salario);
    //         System.out.println("Detalles: " + detalles);


    //     return "vacantes/listVacantes";
    // }
     @PostMapping("/save")
    public String guardar(Vacante vacante){
        
        System.out.println("Vacante: "+ vacante);


        return "vacantes/listVacantes";
    }
}
