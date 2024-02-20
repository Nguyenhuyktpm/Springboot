/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Hell.service.impl;

import com.example.Hell.converter.NewConverter;
import com.example.Hell.dto.NewDTO;
import com.example.Hell.entity.CategoryEntity;
import com.example.Hell.entity.NewEntity;
import com.example.Hell.repository.CategoryRepository;
import com.example.Hell.repository.NewRepository;
import com.example.Hell.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewService implements INewService {

    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    @Override
    public NewDTO save(NewDTO newDTO) {    
        NewEntity newEntity = new NewEntity();
        if(newDTO.getId() !=null)
        {
            NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());
            newEntity = newConverter.toEntity(newDTO,oldNewEntity);
        }
        else
        {
            newEntity = newConverter.toEntity(newDTO);
        }
        
        
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        newEntity = newRepository.save(newEntity);
        return newConverter.toDTO(newEntity);
    }
}
