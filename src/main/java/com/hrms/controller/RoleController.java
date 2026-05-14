package com.hrms.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hrms.entity.Role;
import com.hrms.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> addRole(
            @RequestBody Role role) {

        return new ResponseEntity<>(
                roleService.addRole(role),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {

        return ResponseEntity.ok(
                roleService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                roleService.getRoleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(
            @PathVariable Long id,
            @RequestBody Role role) {

        return ResponseEntity.ok(
                roleService.updateRole(id, role));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(
            @PathVariable Long id) {

        roleService.deleteRole(id);

        return ResponseEntity.ok(
                "Role Deleted Successfully");
    }
}
