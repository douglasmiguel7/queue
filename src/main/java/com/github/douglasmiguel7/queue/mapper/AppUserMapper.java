package com.github.douglasmiguel7.queue.mapper;

import com.github.douglasmiguel7.queue.domain.AppUser;
import com.github.douglasmiguel7.queue.mapper.qualifier.Conversions;
import com.github.douglasmiguel7.queue.mapper.qualifier.Convertion;
import com.github.douglasmiguel7.queue.mapper.qualifier.ToLong;
import com.github.douglasmiguel7.queue.output.AppUserOutput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {Conversions.class})
public interface AppUserMapper {

    @Mapping(target = "role", expression = "java(appUser.getRole().getName())")
    @Mapping(target = "companyId", source = "company", qualifiedBy = {Convertion.class, ToLong.class})
    AppUserOutput toOutput(AppUser appUser);

    List<AppUserOutput> toOutputs(List<AppUser> appUsers);
}
