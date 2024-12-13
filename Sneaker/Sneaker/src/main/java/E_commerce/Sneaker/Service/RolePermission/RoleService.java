package E_commerce.Sneaker.Service.RolePermission;


import E_commerce.Sneaker.dtos.request.RoleRequest;
import E_commerce.Sneaker.dtos.response.PermissionResponse;
import E_commerce.Sneaker.dtos.response.RoleResponse;
import E_commerce.Sneaker.mapper.RoleMapper;
import E_commerce.Sneaker.repository.PermissionRepository;
import E_commerce.Sneaker.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionRepository permissionRepository;

    public RoleResponse create(RoleRequest request){
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);

        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAll(){
        var roles = roleRepository.findAll();
        return roles
                .stream()
                .map(roleMapper::toRoleResponse)
                .toList();
    }

    public void delete(String role){
        roleRepository.deleteById(role);
    }
}
