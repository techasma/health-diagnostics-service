package com.ignou.hds.HDS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private Long id;

    @NotNull
    private String name;

    @NotNull

    private String email;

    @NotNull
    private String password;

    @NotNull
    private Role role;
}
