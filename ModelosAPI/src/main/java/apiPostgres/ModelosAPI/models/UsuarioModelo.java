package apiPostgres.ModelosAPI.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "Usuario")
public class UsuarioModelo {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idUsuario;

    @Column(nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String contrasena;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "idsUsuarios")
    private Set<AplicacionModelo> idsAplicaciones = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE,
    })
    @JoinTable(
        name = "usuario_rol",
        joinColumns = @JoinColumn(name = "id_Usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_Rol"))
    private Set<RolModelo> idsRoles = new HashSet<>();
}
