package com.sms.smr.infra.inputadapter.dto.menurole;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MenuRoleDto {
    private String menuDescription;
    private String menuCode;
    private String menuPath;    
}
