package com.api.VigiControl.Servicio;

import com.api.VigiControl.Modelo.Asignacion;
import com.api.VigiControl.Repositorio.IAsignacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionService {

    @Autowired
    private IAsignacionRepo asignacionRepo;

    public List<Asignacion> listarAsisgnaciones() {
        return asignacionRepo.findAll();
    }

    public Asignacion buscarAsignacion(Integer id) {
        return asignacionRepo.findById(id).get();
    }

    public Asignacion ingresarAsignacion(Asignacion asignacion) {
        return asignacionRepo.save(asignacion);
    }

    public void eliminarAsignacion(Integer id) {
        asignacionRepo.deleteById(id);
    }
}
