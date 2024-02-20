/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
*/

package com.example.Hell.repository;

import com.example.Hell.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nqhkt
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
    RoleEntity findOneByCode(int code);
}