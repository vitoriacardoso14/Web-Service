package webservice;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    private List<Estudante> lista = new ArrayList<>();

    @GetMapping
    public List<Estudante> getAll() {
        return lista;
    }

    @GetMapping("/{id}")
    public Estudante getById(@PathVariable int id) {
        for (Estudante e : lista) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @PostMapping
    public String add(@RequestBody Estudante estudante) {
        lista.add(estudante);
        return "Estudante adicionado!";
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable int id, @RequestBody Estudante atualizado) {
        for (Estudante e : lista) {
            if (e.getId() == id) {
                e.setNome(atualizado.getNome());
                e.setCurso(atualizado.getCurso());
                return "Atualizado!";
            }
        }
        return "Não encontrado!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        lista.removeIf(e -> e.getId() == id);
        return "Removido!";
    }
}