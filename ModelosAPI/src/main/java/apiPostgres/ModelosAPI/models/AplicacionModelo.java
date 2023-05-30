package apiPostgres.ModelosAPI.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "Aplicacion")
public class AplicacionModelo {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idAplicacion;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(
        name = "usuario_aplicacion",
        joinColumns = @JoinColumn(name = "id_Usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_Aplicacion"))
    private Set<UsuarioModelo> idsUsuarios = new HashSet<>();
    
}
