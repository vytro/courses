package com.diplomado.courses.services.mapper;

public interface CustomMapper <DTO, E>{
    E toEntity(DTO dto);
    DTO toDto(E e);
    DTO toDtoDetailed(E e);
}
