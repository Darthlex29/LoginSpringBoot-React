package apiPostgres.ModelosAPI.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "Rol")
public class RolModelo {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idRol;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(
        name = "rol_permiso",
        joinColumns = @JoinColumn(name = "id_Rol"),
        inverseJoinColumns = @JoinColumn(name = "id_Permiso"))
    private Set<PermisoModelo> idsPermisos = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "idsRoles")
    private Set<UsuarioModelo> idsUsuarios = new HashSet<>();

    
}
