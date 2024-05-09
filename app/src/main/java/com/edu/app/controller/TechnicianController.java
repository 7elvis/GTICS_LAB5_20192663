package com.edu.app.controller;

import com.edu.app.entity.Employees;
import com.edu.app.repository.DepartmentsRepository;
import com.edu.app.repository.EmployeesRepository;
import com.edu.app.repository.JobsRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/technician")
public class TechnicianController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    TechnicianRepository technicianRepository;

    //@Autowired
    //JobsRepository jobsRepository;

    //@Autowired
    //DepartmentsRepository departmentsRepository;

    @GetMapping(value = {"", "/"})
    public String listaEmployee(Model model) {
        model.addAttribute("listaTechnician", technicianRepository.findAll());
        //model.addAttribute("listaJobs", jobsRepository.findAll());
        //model.addAttribute("listaDepartments", departmentsRepository.findAll());
        return "/technician/lista";
    }

    @GetMapping("/new")
    public String nuevoEmployeeForm(Model model) {
        model.addAttribute("technician", new Technician());
        //model.addAttribute("listaJobs", jobsRepository.findAll());
        //model.addAttribute("listaJefes", employeesRepository.findAll());
        //model.addAttribute("listaDepartments", departmentsRepository.findAll());
        return "technician/Frm";
    }

    @PostMapping("/save")
    public String guardarEmployee(@ModelAttribute("technucian") @Valid Employees employees,
            BindingResult bindingResult,
            RedirectAttributes attr,
            //@RequestParam(name = "fechaContrato", required = false) String fechaContrato, Model model) {


            if (technician.getTechnicianid() == 0) {
                try {

                    technicianRepository.save(technician);
                    attr.addFlashAttribute("msg", "Tecnico creado exitosamente");
                    return "redirect:/technician";
                } catch (Exception ex) {
                    //model.addAttribute("listaJobs", jobsRepository.findAll());
                    //model.addAttribute("listaJefes", employeesRepository.findAll());
                    //model.addAttribute("listaDepartments", departmentsRepository.findAll());
                    model.addAttribute("msg", ex.getMessage());
                    ex.printStackTrace();
                    return "technician/Frm";
                }
            } else {

                try {
                    technucianRepository.save(technician);
                    attr.addFlashAttribute("msg", "Tecnico actualizado exitosamente");
                } catch (Exception ex) {
                    //model.addAttribute("listaJobs", jobsRepository.findAll());
                    //model.addAttribute("listaJefes", employeesRepository.findAll());
                    //model.addAttribute("listaDepartments", departmentsRepository.findAll());
                    model.addAttribute("msg", ex.getMessage());
                    ex.printStackTrace();
                    return "technician/Frm";
                }
                return "redirect:/technician";
            }
        }
    }

    @GetMapping("/edit")
    public String editarEmployee(@RequestParam("id") int id, Model model) {
        Technician technician = technicianRepository.findById(id).orElse(null);

        if (technician != null) {
            //model.addAttribute("technician", employee);
            //model.addAttribute("listaJobs", jobsRepository.findAll());
            //model.addAttribute("listaJefes", employeesRepository.findAll());
            //model.addAttribute("listaDepartments", departmentsRepository.findAll());
            return "employee/Frm";
        }
        return "redirect:/technician";
    }

    @GetMapping("/delete")
    public String borrarEmpleado(Model model,
            @RequestParam("id") int id,
            RedirectAttributes attr) {

        try {
            Optional<Technician> optTechnician = TechnicisnRepository.findById(id);

            if (optTechnician.isPresent()) {
                technicianRepository.deleteById(id);
                attr.addFlashAttribute("msg", "Tecnico borrado exitosamente");
            }
        } catch (Exception ex) {
            attr.addFlashAttribute("msg", "No se pudo borrar tecnico: " + ex.getMessage());
        }
        return "redirect:/technician";

    }

    @PostMapping("/search")
    public String buscar(@RequestParam("s") String s, Model model) {
        if (s == null || s.equals("")) {
            model.addAttribute("listaTechnician", technicianRepository.findAll());
        } else {
            model.addAttribute("listaTechnician", technicianRepository.Search(s));
        }
        model.addAttribute("s", s);
        return "/technician/lista";
    }

}
