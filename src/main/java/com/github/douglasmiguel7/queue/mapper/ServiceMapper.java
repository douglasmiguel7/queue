package com.github.douglasmiguel7.queue.mapper;

import com.github.douglasmiguel7.queue.domain.Service;
import com.github.douglasmiguel7.queue.output.ServiceOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DateMapper.class, CompanyMapper.class})
public interface ServiceMapper {

    @Mapping(target = "companyId", source = "company")
    ServiceOutput toOutput(Service service);

    List<ServiceOutput> toOutputs(List<Service> services);

}
