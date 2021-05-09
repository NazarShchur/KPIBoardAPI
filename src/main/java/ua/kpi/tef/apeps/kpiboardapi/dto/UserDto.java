package ua.kpi.tef.apeps.kpiboardapi.dto;

import lombok.Data;
import ua.kpi.tef.apeps.kpiboardapi.entity.Role;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private Role role;
}
