package com.zhouyn.demo.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TD_ROLE")
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(name = "role_seq", sequenceName = "SEQ_T_ROLE", initialValue = 1, allocationSize = 1)
    private Long id;

    // 角色
    @Column
    private String role;

    // 角色名称
    @Column
    private String roleName;
}
