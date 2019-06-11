package com.zhouyn.demo.serviceProvider.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_STUDENT")
@Builder
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Student extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long studentId;
    private String studentName;
    private Long classId;
}
