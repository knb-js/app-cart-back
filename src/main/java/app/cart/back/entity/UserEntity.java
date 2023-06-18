package app.cart.back.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntity {

    private Integer rut;
    private String dv;
    private String nombre;
    private String apellido;
    private String email;
}
