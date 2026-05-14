package com.hrms.service;

import java.util.List;

import com.hrms.entity.Role;

public interface RoleService {
	
	 Role addRole(Role role);

	    List<Role> getAllRoles();

	    Role getRoleById(Long id);

	    Role updateRole(Long id, Role role);

	    void deleteRole(Long id);

}
