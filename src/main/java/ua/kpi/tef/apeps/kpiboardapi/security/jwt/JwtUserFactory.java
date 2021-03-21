package ua.kpi.tef.apeps.kpiboardapi.security.jwt;

import lombok.Data;
import ua.kpi.tef.apeps.kpiboardapi.entity.Status;
import ua.kpi.tef.apeps.kpiboardapi.entity.User;

@Data
public final class JwtUserFactory {
    public static JwtUser create(User user) {
        return JwtUser.builder()
                .id(user.getId())
                .password(user.getPassword())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .enable(user.getStatus().equals(Status.ACTIVE))
                .build();
    }
}
