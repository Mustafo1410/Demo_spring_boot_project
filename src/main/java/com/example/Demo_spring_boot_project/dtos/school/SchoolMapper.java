package com.example.Demo_spring_boot_project.dtos.school;

import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
    SchoolDto toDto(School school);

    @Mapping(ignore = true, target = "id")
   /* @Mapping(ignore = true, target = "createAt")
    @Mapping(ignore = true, target = "updateAt")
    @Mapping(ignore = true, target = "deleteAt")*/
    School toEntity(SchoolDto schoolDto);

    List<SchoolDto> dtoList(List<School> schoolList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget School school, SchoolDto dto);
}
