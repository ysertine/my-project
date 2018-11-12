package com.my.project.system.domain;

/**
 * @Title SysPermission.java
 * @Description 系统权限实体类
 * @author DengJinbo
 * @date 2018年11月10日
 */
public class SysPermission {

	/**
	 * 主键ID
	 */
	private Long id;
	
	/**
	 * 权限名称
	 */
	private String name;
	
	/**
	 * 父编号
	 */
	private Long parentId;
	
	/**
	 * 父编号列表
	 */
	private String parentIds;
	
	/**
	 * 权限字符串
	 */
	private String permission;
	
	/**
	 * 资源类型：0=menu，1=button
	 */
	private Integer resourceType;
	
	/**
	 * 资源路径
	 */
	private String url;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Integer getResourceType() {
		return resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
