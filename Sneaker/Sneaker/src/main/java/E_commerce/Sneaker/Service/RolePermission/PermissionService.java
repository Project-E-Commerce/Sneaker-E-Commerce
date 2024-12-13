package E_commerce.Sneaker.Service.RolePermission;


import E_commerce.Sneaker.dtos.request.PermissionRequest;
import E_commerce.Sneaker.dtos.response.PermissionResponse;
import E_commerce.Sneaker.mapper.PermissionMapper;
import E_commerce.Sneaker.model.Role.Permission;
import E_commerce.Sneaker.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request){
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);

        return permissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> getAll(){
        var permission = permissionRepository.findAll();
        return permission.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void delete(String permission){
        permissionRepository.deleteById(permission);
    }
}


































