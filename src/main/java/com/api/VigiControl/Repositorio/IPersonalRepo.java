package com.api.VigiControl.Repositorio;

import com.api.VigiControl.Modelo.Distrito;
import com.api.VigiControl.Modelo.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.reflect.Array;
import java.util.List;

public interface IPersonalRepo extends JpaRepository<Personal,Integer> {
//    @Query(value = "select p from Personal p")
//    List<Personal> listarPrueba();
}
