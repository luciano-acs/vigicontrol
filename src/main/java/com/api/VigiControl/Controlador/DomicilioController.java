package com.api.VigiControl.Controlador;

import com.api.VigiControl.Modelo.Asignacion;
import com.api.VigiControl.Modelo.Distrito;
import com.api.VigiControl.Modelo.Domicilio;
import com.api.VigiControl.Servicio.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @GetMapping("/listar")
    public List<Domicilio> listarDomicilios(){
        return domicilioService.listarDomicilios();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Domicilio> buscarDomicilio(@PathVariable Integer id){
        try{
            Domicilio domicilioBusqueda = domicilioService.buscarDomicilio(id);
            return new ResponseEntity<Domicilio>(domicilioBusqueda,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Domicilio>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/domicilio")
    public Domicilio ingresarDomicilio(@RequestBody Domicilio domicilio){
        return domicilioService.ingresarDomicilio(domicilio);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarDomicilio(@PathVariable Integer id, @RequestBody Domicilio domicilio){
        try{
            Domicilio domicilioModificacion = domicilioService.buscarDomicilio(id);
            domicilioModificacion.setCalle(domicilio.getCalle());
            domicilioModificacion.setLocalidad(domicilio.getLocalidad());
            domicilioModificacion.setNroCalle(domicilio.getNroCalle());

            domicilioService.ingresarDomicilio(domicilioModificacion);
            return new ResponseEntity<Asignacion>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Asignacion>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarDistrito(@PathVariable Integer id){
        domicilioService.eliminarDomicilio(id);
    }
}
