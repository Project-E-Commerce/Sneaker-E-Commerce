package E_commerce.Sneaker.controller;


import E_commerce.Sneaker.Service.RolePermission.PermissionService;
import E_commerce.Sneaker.dtos.request.PermissionRequest;
import E_commerce.Sneaker.dtos.response.ApiResponse;
import E_commerce.Sneaker.dtos.response.PermissionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @PostMapping
    ApiResponse<PermissionResponse> create(@RequestBody PermissionRequest request){
        return ApiResponse.<PermissionResponse>builder()
                .result(permissionService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<PermissionResponse>> getALl(){
        return ApiResponse.<List<PermissionResponse>>builder()
                .result(permissionService.getAll())
                .build();
    }

    @DeleteMapping("{permission_name}")
    ApiResponse<Void> delete(@PathVariable String permission_name){
        permissionService.delete(permission_name);
        return ApiResponse.<Void>builder().build();
    }
}
