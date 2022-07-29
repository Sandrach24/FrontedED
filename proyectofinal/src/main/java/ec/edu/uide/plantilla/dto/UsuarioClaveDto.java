/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uide.plantilla.dto;

import static ec.edu.uide.plantilla.dto.UsuarioDto.ALFANUMERIC_NO_ACCENTS;
import static ec.edu.uide.plantilla.dto.UsuarioDto.PASSWORD;
import static ec.edu.uide.plantilla.dto.UsuarioDto.WRONG_INFORMATION;
import static ec.edu.uide.plantilla.dto.UsuarioDto.WRONG_SIZE;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Dante
 */
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioClaveDto {

    @Size(min = 4, max = 45, message = WRONG_SIZE)
    @Pattern(regexp = ALFANUMERIC_NO_ACCENTS, message = WRONG_INFORMATION)
    private String usuario;

    @Size(min = 8, max = 16, message = WRONG_SIZE)
    @Pattern(regexp = PASSWORD, message = WRONG_INFORMATION)
    private String clave;
}
