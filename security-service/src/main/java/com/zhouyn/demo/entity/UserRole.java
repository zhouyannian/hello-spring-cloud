package com.zhouyn.demo.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TD_USER_ROLE")
public class UserRole extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_seq")
    @SequenceGenerator(name = "user_role_seq", sequenceName = "SEQ_TD_USER_ROLE", initialValue = 1, allocationSize = 1)
    private Long id;


    @Column
    private Long userId;
    @Column
    private Long roleId;
}
