package com.hrms.serviceimpl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.entity.Role;
import com.hrms.repository.RoleRepository;
import com.hrms.service.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    @Override
    public Role updateRole(Long id, Role role) {

        Role existing = roleRepository.findById(id).orElseThrow();

        existing.setRoleName(role.getRoleName());
        existing.setDescription(role.getDescription());

        return roleRepository.save(existing);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
