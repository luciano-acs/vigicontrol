package com.api.VigiControl.Controlador;

import com.api.VigiControl.Modelo.Asignacion;
import com.api.VigiControl.Servicio.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaciones")
public class AsignacionController {

    @Autowired
    private AsignacionService asignacionService;

    @GetMapping("/listar")
    public List<Asignacion> listarAsignaciones(){return asignacionService.listarAsisgnaciones();}

    @GetMapping("/listar/{id}")
    public ResponseEntity<Asignacion> buscarAsignacion(@PathVariable Integer id){
        try{
            Asignacion asignacionBusqueda = asignacionService.buscarAsignacion(id);
            return new ResponseEntity<Asignacion>(asignacionBusqueda,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Asignacion>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/asignacion")
    public Asignacion ingresarAsignacion(@RequestBody Asignacion asignacion){
        return asignacionService.ingresarAsignacion(asignacion);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarAsignacion(@PathVariable Integer id, @RequestBody Asignacion asignacion){
        try{
            Asignacion asignacionModificacion = asignacionService.buscarAsignacion(id);
            asignacionModificacion.setFecha(asignacion.getFecha());
            asignacionModificacion.setPersonal(asignacion.getPersonal());
            asignacionModificacion.setTarea(asignacion.getTarea());

            asignacionService.ingresarAsignacion(asignacionModificacion);
            return new ResponseEntity<Asignacion>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Asignacion>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarAsignacion(@PathVariable Integer id){
        asignacionService.eliminarAsignacion(id);
    }
}
