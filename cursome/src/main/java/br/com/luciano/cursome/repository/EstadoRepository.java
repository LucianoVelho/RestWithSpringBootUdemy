/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.luciano.cursome.repository;

import br.com.luciano.cursome.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luciano Velho Garcia
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
    
}
