package com.github.douglasmiguel7.queue.mapper;

import com.github.douglasmiguel7.queue.domain.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    default Long asLong(Company company) {
        return company.getId();
    }

}
