package com.my.project.system.domain;

/**
 * 系统角色实体类
 * <p>Title: SysRole<／p>
 * <p>Description: 系统角色实体类<／p>
 * @author DengJinbo
 * @date 2018年11月10日
 */
public class SysRole {

	/**
	 * 主键ID
	 */
	private Long id;
	
	/**
	 * 角色名称
	 */
	private String role;
	
	/**
	 * 角色描述
	 */
	private String description;
	
	/**
	 * 状态：0=禁用，1=正常
	 */
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
