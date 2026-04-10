package webservice;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private List<Empresa> lista = new ArrayList<>();

    @GetMapping
    public List<Empresa> getAll() {
        return lista;
    }

    @PostMapping
    public String add(@RequestBody Empresa empresa) {
        lista.add(empresa);
        return "Empresa adicionada!";
    }

    @PutMapping("/{id}")
    public String atualizar(@PathVariable int id, @RequestBody Empresa atualizada) {
        for (Empresa e : lista) {
            if (e.getId() == id) {
                e.setNome(atualizada.getNome());
                e.setCnpj(atualizada.getCnpj());
                return "Atualizada!";
            }
        }
        return "Não encontrada!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        lista.removeIf(e -> e.getId() == id);
        return "Removida!";
    }
}