//package E_commerce.Sneaker.mapper;
//
//import E_commerce.Sneaker.dtos.RoleDTO;
//import E_commerce.Sneaker.model.Role.Role;
//
///**
// * this class allows the data exchange from Role class and RoleDTO class
// */
//public class RoleMapper {
//    private static RoleMapper INSTANCE;
//
//    public static RoleMapper getInstance(){
//        if(INSTANCE == null){
//            INSTANCE = new RoleMapper();
//        }
//        return INSTANCE;
//    }
//    public Role toEntity(RoleDTO roleDTO){
//        Role role = new Role();
//        role.setName(roleDTO.getName());
//        return role;
//    }
//    public RoleDTO toDTO(Role role){
//        RoleDTO dto = new RoleDTO();
//        dto.setName(role.getName());
//        dto.setId(role.getId());
//        return dto;
//    }
//}
