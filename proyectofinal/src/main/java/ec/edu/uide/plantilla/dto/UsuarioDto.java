/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uide.plantilla.dto;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
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
public class UsuarioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String NO_VACIO = "No debe estar vacio";
    public static final String WRONG_SIZE = "Medida equivocada";
    public static final String WRONG_INFORMATION = "informacion incorrecta";
    public static final String ALFANUMERIC_NO_ACCENTS = "[A-Za-z0-9]+";
    public static final String ALFA_NO_ACCENTS = "[A-Za-z]+";
    public static final String CONCATENATED_WORD = "[a-zA-Z\\ ]+";
    public static final String PASSWORD = "[a-zA-Z0-9\\.\\-\\_\\*\\@\\#\\$\\%\\&\\^\\+\\=\\{\\[\\}\\]\\:\\;\\<\\>\\,\\?\\¿\\/]+";
    public static final String NUMERIC = "[0-9]+";

    @NotBlank(message = NO_VACIO)
    @Size(min = 10, max = 25, message = WRONG_SIZE)
    @Pattern(regexp = NUMERIC, message = WRONG_INFORMATION)
    private String cedula;

    @NotBlank(message = NO_VACIO)
    @Size(min = 4, max = 45, message = WRONG_SIZE)
    @Pattern(regexp = ALFANUMERIC_NO_ACCENTS, message = WRONG_INFORMATION)
    private String usuario;

    @NotBlank(message = NO_VACIO)
    @Size(min = 8, max = 16, message = WRONG_SIZE)
    @Pattern(regexp = PASSWORD, message = WRONG_INFORMATION)
    private String clave;

  
    @Size(min = 10, max = 45, message = WRONG_SIZE)
    @Pattern(regexp = CONCATENATED_WORD, message = WRONG_INFORMATION)
    private String nombres;

    @Size(min = 10, max = 45, message = WRONG_SIZE)
    @Email(message = WRONG_INFORMATION)
    private String email;

  
    @Size(min = 9, max = 10, message = WRONG_SIZE)
    @Pattern(regexp = NUMERIC, message = WRONG_INFORMATION)
    private String telefono;

    @Size(min = 10, max = 255, message = WRONG_SIZE)
    @Pattern(regexp = PASSWORD, message = WRONG_INFORMATION)
    private String urlFoto;

}
