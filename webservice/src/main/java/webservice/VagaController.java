package webservice;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    private List<Vaga> lista = new ArrayList<>();

    @GetMapping
    public List<Vaga> getAll() {
        return lista;
    }

    @PostMapping
    public String add(@RequestBody Vaga vaga) {
        lista.add(vaga);
        return "Vaga adicionada!";
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable int id, @RequestBody Vaga atualizada) {
        for (Vaga v : lista) {
            if (v.getId() == id) {
                v.setCargo(atualizada.getCargo());
                v.setSalario(atualizada.getSalario());
                return "Atualizada!";
            }
        }
        return "Não encontrada!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        lista.removeIf(v -> v.getId() == id);
        return "Removida!";
    }
}