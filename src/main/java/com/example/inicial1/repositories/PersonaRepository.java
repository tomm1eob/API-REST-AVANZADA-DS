package com.example.inicial1.repositories;

import com.example.inicial1.entities.Persona;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    // Métodos Query
        //List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
        // boolean existByDni(int dni);

            // Con Paginacion
            // Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    // Query con JPQL
        @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
        List<Persona> search(@Param("filtro") String filtro);

        // Con Paginacion
            @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
            Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    // Query nativas (con SQL)
        // @Query(
        //        value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%"
        //       nativeQuery= true
        //)
        //List<Persona> searchNativo(@Param("filtro") String filtro);

        // Con Paginacion
            // Query nativas (con SQL)
            // @Query(
            //        value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%"
            //       countQuery = "SELECT count(*) FROM persona",
            //       nativeQuery= true
            //)
            //List<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}