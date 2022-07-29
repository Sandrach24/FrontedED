/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.uide.plantilla.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import static ec.edu.uide.plantilla.dto.UsuarioDto.CONCATENATED_WORD;
import static ec.edu.uide.plantilla.dto.UsuarioDto.NO_VACIO;
import static ec.edu.uide.plantilla.dto.UsuarioDto.WRONG_INFORMATION;
import static ec.edu.uide.plantilla.dto.UsuarioDto.WRONG_SIZE;
import ec.edu.uide.plantilla.enums.Sexo;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
/**
 *
 * @author macbookpro
 */
@Entity
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_EMPTY)
@Table(name = "equipos")
public class Equipos implements Serializable {
     private static final long serialVersionUID = 1L;

    @Id
   
    @JsonProperty("nombreequipo")
    @Column(nullable = false, length = 45, unique = false)
    @NotBlank(message = NO_VACIO)
    @Size(min = 3, max = 45, message = WRONG_SIZE)
    @Pattern(regexp = CONCATENATED_WORD, message = WRONG_INFORMATION)
    private String nombres;
    
    @JsonProperty("representante")
    @Column(nullable = false, length = 45, unique = false)
    @NotBlank(message = NO_VACIO)
    @Size(min = 6, max = 45, message = WRONG_SIZE)
    @Pattern(regexp = CONCATENATED_WORD, message = WRONG_INFORMATION)
    private String representante;
    
    @JsonProperty("madrina")
    @Column(nullable = false, length = 45, unique = false)
    @NotBlank(message = NO_VACIO)
    @Size(min = 6, max = 45, message = WRONG_SIZE)
    @Pattern(regexp = CONCATENATED_WORD, message = WRONG_INFORMATION)
    private String madrina;
     
    @JsonProperty("disciplina")
    @Column(nullable = false, length = 45, unique = false)
    @NotBlank(message = NO_VACIO)
    @Size(min = 6, max = 45, message = WRONG_SIZE)
    @Pattern(regexp = CONCATENATED_WORD, message = WRONG_INFORMATION)
    private String disciplina;

    @Enumerated(EnumType.ORDINAL)
    private Sexo sexo;
    
    @JsonIgnore
    @ManyToOne
    private Partido partido;
    
    @JsonIgnore
    @OneToOne
    private Persona persona;
}