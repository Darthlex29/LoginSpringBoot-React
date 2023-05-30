package apiPostgres.ModelosAPI.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "Permiso")
public class PermisoModelo {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idPermiso;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "idsPermisos")
    private Set<RolModelo> idsRoles = new HashSet<>();

}
