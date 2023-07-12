package com.api.VigiControl.Repositorio;

import com.api.VigiControl.Modelo.Asignacion;
import com.api.VigiControl.Modelo.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAsignacionRepo extends JpaRepository<Asignacion, Integer> {

}
