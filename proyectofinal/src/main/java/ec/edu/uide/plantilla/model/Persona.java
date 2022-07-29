/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uide.plantilla.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import com.fasterxml.jackson.annotation.JsonProperty;
import static ec.edu.uide.plantilla.dto.UsuarioDto.CONCATENATED_WORD;
import static ec.edu.uide.plantilla.dto.UsuarioDto.NO_VACIO;
import static ec.edu.uide.plantilla.dto.UsuarioDto.NUMERIC;
import static ec.edu.uide.plantilla.dto.UsuarioDto.PASSWORD;
import static ec.edu.uide.plantilla.dto.UsuarioDto.WRONG_INFORMATION;
import static ec.edu.uide.plantilla.dto.UsuarioDto.WRONG_SIZE;
import ec.edu.uide.plantilla.enums.Sexo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
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
 *
 */
@Entity
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_EMPTY)
@Table(name = "persona_universal")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @JsonProperty("nro.cedula")
    @Column(nullable = false, length = 25)
    @NotBlank(message = NO_VACIO)
    @Size(min = 10, max = 25, message = WRONG_SIZE)
    @Pattern(regexp = NUMERIC, message = WRONG_INFORMATION)
    private String cedula;

    @JsonProperty("apellidosNombres")
    @Column(nullable = false, length = 45, unique = true)
    @NotBlank(message = NO_VACIO)
    @Size(min = 3, max = 45, message = WRONG_SIZE)
    @Pattern(regexp = CONCATENATED_WORD, message = WRONG_INFORMATION)
    private String nombres;

    @Enumerated(EnumType.ORDINAL)
    private Sexo sexo;

    @Null
    @JsonProperty("foto")
    @Column(nullable = true, length = 255)
    @Size(min = 10, max = 255, message = WRONG_SIZE)
    @Pattern(regexp = PASSWORD, message = WRONG_INFORMATION)
    private String urlFoto;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;

    @NotBlank
    @Column(nullable = true, length = 10)
    @Size(min = 9, max = 10, message = WRONG_SIZE)
    @Pattern(regexp = NUMERIC, message = WRONG_INFORMATION)
    private String telefono;

    @NotBlank
    @JsonProperty("e-mail")
    @Column(nullable = true, length = 45)
    @Size(min = 8, max = 45, message = WRONG_SIZE)
    @Email(message = WRONG_INFORMATION)
    private String email;

    @JsonIgnore
    @ManyToOne
    private Equipos equipos;
    //    @JsonProperty("telfonos")
            //    @OneToMany(mappedBy = "persona")
            //    private List<Telefono> telefonos;
            //
            //    @JsonProperty("emails")
            //    @OneToMany(mappedBy = "persona")
            //    private List<Emails> emails;

}
