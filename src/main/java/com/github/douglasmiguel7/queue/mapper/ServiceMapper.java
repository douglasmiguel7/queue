package com.github.douglasmiguel7.queue.mapper;

import com.github.douglasmiguel7.queue.domain.Service;
import com.github.douglasmiguel7.queue.input.ServiceInput;
import com.github.douglasmiguel7.queue.mapper.qualifier.Conversions;
import com.github.douglasmiguel7.queue.mapper.qualifier.Convertion;
import com.github.douglasmiguel7.queue.mapper.qualifier.ToLong;
import com.github.douglasmiguel7.queue.mapper.qualifier.ToTime;
import com.github.douglasmiguel7.queue.output.ServiceOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {Conversions.class})
public interface ServiceMapper {

    @Mapping(target = "companyId", source = "company", qualifiedBy = {Convertion.class, ToLong.class})
    @Mapping(target = "endAt", source = "endAt", qualifiedBy = {Convertion.class, ToTime.class})
    ServiceOutput toOutput(Service service);

    List<ServiceOutput> toOutputs(List<Service> services);

    Service toService(Long id);

    Service toService(ServiceInput serviceInput);

}
