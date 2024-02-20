
package com.example.Hell.repository;

import com.example.Hell.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//                                                 Bảng thao tác,kiểu dữ liệu khóa chính
public interface NewRepository extends JpaRepository<NewEntity, Long>{

    public NewEntity findOne(Long id);
    
}
