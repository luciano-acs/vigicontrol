package com.api.VigiControl.Servicio;

import com.api.VigiControl.Modelo.Domicilio;
import com.api.VigiControl.Modelo.Personal;
import com.api.VigiControl.Repositorio.IPersonalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService {

    @Autowired
    private IPersonalRepo personalRepo;

    public List<Personal> listarPersonal() {
        return personalRepo.findAll();
    }

    public Personal buscarPersonal(Integer id) {
        return personalRepo.findById(id).get();
    }

    public Personal ingresarPersona(Personal personal) {
        return personalRepo.save(personal);
    }

    public void eliminarPersonal(Integer id) {
        personalRepo.deleteById(id);
    }

//    public List<Personal> listarPrueba() {
//        return personalRepo.listarPrueba();
//    }

//    public List<Personal> listarPrueba() {
//        return personalRepo.listarPrueba();
//    }
}
