package com.github.douglasmiguel7.queue.mapper;

import com.github.douglasmiguel7.queue.domain.Service;
import com.github.douglasmiguel7.queue.mapper.qualifier.Conversions;
import com.github.douglasmiguel7.queue.mapper.qualifier.ObjectConvertion;
import com.github.douglasmiguel7.queue.mapper.qualifier.ToLong;
import com.github.douglasmiguel7.queue.mapper.qualifier.ToTime;
import com.github.douglasmiguel7.queue.output.ServiceOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {Conversions.class})
public interface ServiceMapper {

    @Mapping(target = "companyId", source = "company", qualifiedBy = {ObjectConvertion.class, ToLong.class})
    @Mapping(target = "endAt", source = "endAt", qualifiedBy = {ObjectConvertion.class, ToTime.class})
    ServiceOutput toOutput(Service service);

    List<ServiceOutput> toOutputs(List<Service> services);

}
