package com.api.VigiControl.Controlador;

import com.api.VigiControl.Modelo.Asignacion;
import com.api.VigiControl.Modelo.Tarea;
import com.api.VigiControl.Servicio.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping("/listar")
    public List<Tarea> listarTareas(){
        return tareaService.listarTareas();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Tarea> buscarTarea(@PathVariable Integer id){
        try{
            Tarea tareaBusqueda = tareaService.buscarTarea(id);
            return new ResponseEntity<Tarea>(tareaBusqueda,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Tarea>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tarea")
    public Tarea ingresarTarea(@RequestBody Tarea tarea){
        return tareaService.ingresarTarea(tarea);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarTarea(@PathVariable Integer id, @RequestBody Tarea tarea){
        try{
            Tarea tareaModificacion = tareaService.buscarTarea(id);
            tareaModificacion.setAsignaciones(tarea.getAsignaciones());
            tareaModificacion.setNombre(tarea.getNombre());

            tareaService.ingresarTarea(tareaModificacion);
            return new ResponseEntity<Asignacion>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Asignacion>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarTarea(@PathVariable Integer id){
        tareaService.eliminarTarea(id);
    }
}
