package com.hussein.dto;

import com.hussein.model.Roles;
import com.hussein.model.Utilisateur;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RolesDto {

    private  Integer id;

    private String roleName;

    private UtilisateurDto utilisateur;

     public static RolesDto fromEntity (Roles roles) {
         if (roles == null) {
             return null;
         }

         return RolesDto.builder()
                 .id(roles.getId())
                 .roleName(roles.getRoleName())
                 .build();
     }
     public static Roles toEntity(RolesDto rolesDto) {
         if (rolesDto == null) {
             return null;
         }
         Roles roles = new Roles();
         roles.setId(rolesDto.getId());
         roles.setRoleName(rolesDto.getRoleName());

         return roles;
     }
}

