package E_commerce.Sneaker.controller;


import E_commerce.Sneaker.Service.RolePermission.RoleService;
import E_commerce.Sneaker.dtos.request.RoleRequest;
import E_commerce.Sneaker.dtos.response.ApiResponse;
 import E_commerce.Sneaker.dtos.response.RoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody RoleRequest request){
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getALl(){
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("{role_name}")
    ApiResponse<Void> delete(@PathVariable String role_name){
        roleService.delete(role_name);
        return ApiResponse.<Void>builder().build();
    }
}
