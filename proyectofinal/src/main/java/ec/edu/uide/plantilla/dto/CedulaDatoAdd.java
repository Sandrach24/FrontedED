/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uide.plantilla.dto;


import static ec.edu.uide.plantilla.dto.UsuarioDto.NUMERIC;
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
 * @author 
 */
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class CedulaDatoAdd {

    @Size(min = 10, max = 25, message = WRONG_SIZE)
    @Pattern(regexp = NUMERIC, message = WRONG_INFORMATION)
    private String cedula;

    private String dato;
}
