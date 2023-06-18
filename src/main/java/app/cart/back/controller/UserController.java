package app.cart.back.controller;


import app.cart.back.dto.ResponseDTO;
import app.cart.back.entity.UserEntity;
import app.cart.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("(/v1/getUser")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<ResponseDTO> findAllUser(){
        ResponseDTO resp = ResponseDTO.builder().build();

        try {
            List<UserEntity> listUser = userService.findAllUser();
            resp = ResponseDTO
                    .builder()
                    .status(Objects.nonNull(listUser))
                    .message(Objects.nonNull(listUser) ? "Usuarios obtenidos con éxito" : "Ha ocurrido un error para obtener los usuarios")
                    .data(listUser)
                    .build();
            return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<ResponseDTO>(ResponseDTO
                    .builder()
                    .status(false)
                    .message("Error al obtener el servicio: "+ e.getMessage())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByRut/{rut}")
    public ResponseEntity<ResponseDTO> findByUser(@PathVariable("rut") Integer rut){
        try {
            UserEntity user = userService.findByUser(rut);
            return new ResponseEntity<ResponseDTO>(ResponseDTO
                    .builder()
                    .status(Objects.nonNull(user))
                    .message(Objects.nonNull(user) ? "Usuarios obtenidos con éxito" : "Ha ocurrido un error para obtener los usuarios")
                    .data(user)
                    .build(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<ResponseDTO>(ResponseDTO
                    .builder()
                    .status(false)
                    .message("Error al obtener usuario" + e.getMessage())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/getUpdateUser")
    public ResponseEntity<ResponseDTO> update(@RequestBody UserEntity user){
        ResponseDTO resp = ResponseDTO.builder().build();

        try {
            Integer updateUser = userService.updateUser(user);

            resp = ResponseDTO
                    .builder()
                    .status(updateUser > 0 )
                    .message(updateUser > 0 ? "Usuario actualizado" : "Error no se ha logrado actualizar el usuario")
                    .build();
            return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<ResponseDTO>(ResponseDTO
                    .builder()
                    .status(false)
                    .message("Error al actualizar usuario" + e.getMessage())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getInsertUser")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserEntity user){

        ResponseDTO resp = ResponseDTO.builder().build();

        try {
            Integer addUser = userService.addUser(user);

            resp = ResponseDTO
                    .builder()
                    .status(addUser > 0)
                    .message(addUser > 0 ? "Usuario Agregado con Exito" : "Ha ocurrido un error al agregar el usuario")
                    .build();
            return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<ResponseDTO>(ResponseDTO
                    .builder()
                    .status(false)
                    .message("Error al actualizar usuario" + e.getMessage())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/getDeleteUser/{rut}")
    public ResponseEntity<ResponseDTO> deleteByRut(@PathVariable("rut") Integer rut) {
        ResponseDTO resp = ResponseDTO.builder().build();
        try {
            Integer deleteUser =  userService.deleteByRut(rut);
            resp = ResponseDTO
                    .builder()
                    .status(deleteUser > 0)
                    .message(deleteUser > 0 ? "Usuario eliminado con exito" : "Ha ocurrido un error al eliminar el usuario")
                    .build();
            return new ResponseEntity<ResponseDTO>(resp, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<ResponseDTO>(ResponseDTO
                    .builder()
                    .status(false)
                    .message("Error al eliminar usuario" + e.getMessage())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
