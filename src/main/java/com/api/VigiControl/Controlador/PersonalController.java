package com.api.VigiControl.Controlador;

import com.api.VigiControl.Modelo.Asignacion;
import com.api.VigiControl.Modelo.Personal;
import com.api.VigiControl.Servicio.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

//    @GetMapping("/listar/prueba")
//    public List<Personal> listarPrueba(){
//        return personalService.listarPrueba();
//    }

//    @GetMapping("/listar/prueba")
//    public List<Personal> listarPrueba(){
//        return personalService.listarPrueba();
//    }
    @GetMapping("/listar")
    public List<Personal> listarPersonal(){
        return personalService.listarPersonal();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Personal> buscarPersonal(@PathVariable Integer id){
        try{
            Personal personalBusqueda = personalService.buscarPersonal(id);
            return new ResponseEntity<Personal>(personalBusqueda,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Personal>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/persona")
    public Personal ingresarPersona(@RequestBody Personal personal){
        return personalService.ingresarPersona(personal);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarLocalidad(@PathVariable Integer id, @RequestBody Personal personal){
        try{
            Personal personalModificacion = personalService.buscarPersonal(id);
            personalModificacion.setApellido(personal.getApellido());
            personalModificacion.setAsignaciones(personal.getAsignaciones());
            personalModificacion.setCargo(personal.getCargo());
            personalModificacion.setDomicilio(personal.getDomicilio());
            personalModificacion.setNombre(personal.getNombre());

            personalService.ingresarPersona(personalModificacion);
            return new ResponseEntity<Asignacion>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Asignacion>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarLocalidad(@PathVariable Integer id){
        personalService.eliminarPersonal(id);
    }
}
