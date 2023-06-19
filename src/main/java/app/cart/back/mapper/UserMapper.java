package app.cart.back.mapper;

import app.cart.back.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select  " +
            "    Rut as rut , " +
            "    Dv as dv , " +
            "    Nombre as nombre , " +
            "    Apellido as apellido , " +
            "    Email as email " +
            "    from users")
    List<UserEntity> findAllUser();

    @Select("select " +
            "    Rut as rut, " +
            "    Dv as dv, " +
            "    Nombre as nombre, " +
            "    Apellido as apellido, " +
            "    Email as email " +
            "    from users where rut = #{rut}")
    UserEntity findByUser(Integer rut);

    @Insert("INSERT INTO  users(rut,dv,nombre, apellido, email) " +
            "    VALUES (#{rut}, #{dv}, #{nombre}, #{apellido}, #{email})")
    Integer addUser(UserEntity userEntity);

    @Update("update users " +
            "set nombre  =#{nombre}, " +
            "    apellido= #{apellido}, " +
            "    email   = #{email} " +
            "where rut = #{rut}")
    Integer updateUser(UserEntity userEntity);

    @Delete("delete from users where rut = #{rut}")
    Integer deleteByRut(Integer rut);
}
