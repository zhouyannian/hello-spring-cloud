package com.zhouyn.demo.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "TD_USER")
public class LoginUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "SEQ_TD_USER", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column
    private String userName;//用户名
    @Column
    private String password;//用户密码
}
