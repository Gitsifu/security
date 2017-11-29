package com.sifu.security.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 角色实体
 *
 * @author sifu
 */
@Data
@Entity
public class SysRole {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
