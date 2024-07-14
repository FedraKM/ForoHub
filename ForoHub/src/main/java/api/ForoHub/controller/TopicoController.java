package api.ForoHub.controller;

import api.ForoHub.topico.DatosRegistroTopico;
import api.ForoHub.topico.ITopicoRepository;
import api.ForoHub.topico.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private ITopicoRepository iTopicoRepository;


    @PostMapping
    public ResponseEntity<String> registrarTopico(@RequestBody DatosRegistroTopico datosRegistroTopico) {
        try {
            iTopicoRepository.save(new Topico(datosRegistroTopico));
            return ResponseEntity.ok("Tópico registrado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar el tópico: " + e.getMessage());
        }
    }
}
