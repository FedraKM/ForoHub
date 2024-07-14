package api.ForoHub.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idUsuario;

    private String mensaje;


    private String nombreCurso;
    private String titulo;



    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.idUsuario = datosRegistroTopico.idUsuario();
        this.mensaje = datosRegistroTopico.mensaje();
        this.nombreCurso = datosRegistroTopico.nombreCurso();
        this.titulo = datosRegistroTopico.titulo();
    }
}
