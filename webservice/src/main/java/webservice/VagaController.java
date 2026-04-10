package webservice;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    private List<Vaga> vagas = new ArrayList<>(List.of(
        criar(1,"Desenvolvedor Java","Backend com Spring","2025-10-01",true,1),
        criar(2,"Analista de Suporte Técnico","Suporte a clientes","2025-09-27",true,2),
        criar(3,"Engenheiro de Software","Sistemas corporativos","2025-10-03",false,3),
        criar(4,"Analista de Dados","SQL e Python","2025-09-18",true,4),
        criar(5,"Designer Digital","UX/UI","2025-09-30",false,5),
        criar(6,"Consultor de Projetos","Gestão de projetos","2025-10-06",true,1),
        criar(7,"Programador Full Stack","Frontend e backend","2025-10-04",true,2)
    ));

    private Vaga criar(int id,String t,String d,String p,boolean a,int emp){
        Vaga v = new Vaga();
        v.setId(id); v.setTitulo(t); v.setDescricao(d);
        v.setPublicacao(p); v.setAtivo(a); v.setIdEmpresa(emp);
        return v;
    }

    @GetMapping
    public List<Vaga> getAll(){ return vagas; }

    @GetMapping("/{id}")
    public Vaga getById(@PathVariable int id){
        return vagas.stream().filter(v->v.getId()==id).findFirst().orElse(null);
    }

    @PostMapping
    public Vaga create(@RequestBody Vaga v){
        vagas.add(v);
        return v;
    }

    @PutMapping("/{id}")
    public Vaga update(@PathVariable int id,@RequestBody Vaga nova){
        for(Vaga v: vagas){
            if(v.getId()==id){
                v.setTitulo(nova.getTitulo());
                v.setDescricao(nova.getDescricao());
                v.setPublicacao(nova.getPublicacao());
                v.setAtivo(nova.isAtivo());
                v.setIdEmpresa(nova.getIdEmpresa());
                return v;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        vagas.removeIf(v->v.getId()==id);
    }
}