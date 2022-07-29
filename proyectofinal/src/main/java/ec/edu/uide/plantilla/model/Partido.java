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
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static ec.edu.uide.plantilla.dto.UsuarioDto.PASSWORD;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


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
@Table(name = "partido")
public class Partido implements Serializable {
     private static final long serialVersionUID = 1L;

    @Id
   
    @JsonProperty("contrincante1")
    @Column(nullable = false, length = 45, unique = true)
    @NotBlank(message = NO_VACIO)
    @Size(min = 6, max = 45, message = WRONG_SIZE)
    @Pattern(regexp = CONCATENATED_WORD, message = WRONG_INFORMATION)
    private String contrincante1;
    
    @JsonProperty("contricante2")
    @Column(nullable = false, length = 45, unique = true)
    @NotBlank(message = NO_VACIO)
    @Size(min = 6, max = 45, message = WRONG_SIZE)
    @Pattern(regexp = CONCATENATED_WORD, message = WRONG_INFORMATION)
    private String contrincante2;

   
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    @JsonProperty("hora")
    @Column(nullable = false, length = 45, unique = true)
    @Size(min = 1, max = 45, message = WRONG_SIZE)
    @Pattern(regexp =PASSWORD, message = WRONG_INFORMATION)
    private String hora;
    
    @JsonIgnore
    @OneToMany(mappedBy = "partido")
    private List<Equipos> equipos;
    
    
   
}