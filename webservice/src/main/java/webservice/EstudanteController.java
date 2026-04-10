package webservice;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    private List<Estudante> estudantes = new ArrayList<>(List.of(
        criar(1,"Ana Paula Souza","ana.souza@email.com","2002-03-15",2020),
        criar(2,"Carlos Henrique Lima","carlos.lima@email.com","2001-10-22",2019),
        criar(3,"Fernanda Oliveira","fernanda.oliveira@email.com","2003-07-05",2021),
        criar(4,"Lucas Pereira","lucas.pereira@email.com","2002-04-11",2020),
        criar(5,"Gabriela Martins","gabriela.martins@email.com","2001-12-25",2019),
        criar(6,"Rafael Costa","rafael.costa@email.com","2000-09-13",2018),
        criar(7,"Juliana Silva","juliana.silva@email.com","2002-06-18",2020),
        criar(8,"Marcos Vinícius","marcos.vinicius@email.com","2003-01-30",2021),
        criar(9,"Camila Azevedo","camila.azevedo@email.com","2001-11-08",2019),
        criar(10,"Felipe Cardoso","felipe.cardoso@email.com","2000-08-27",2018)
    ));

    private Estudante criar(int id,String nome,String email,String nasc,int ano){
        Estudante e = new Estudante();
        e.setId(id); e.setNome(nome); e.setEmail(email);
        e.setNascimento(nasc); e.setAnoIngresso(ano);
        return e;
    }

    @GetMapping
    public List<Estudante> getAll(){ return estudantes; }

    @GetMapping("/{id}")
    public Estudante getById(@PathVariable int id){
        return estudantes.stream().filter(e->e.getId()==id).findFirst().orElse(null);
    }

    @PostMapping
    public Estudante create(@RequestBody Estudante e){
        estudantes.add(e);
        return e;
    }

    @PutMapping("/{id}")
    public Estudante update(@PathVariable int id,@RequestBody Estudante novo){
        for(Estudante e: estudantes){
            if(e.getId()==id){
                e.setNome(novo.getNome());
                e.setEmail(novo.getEmail());
                e.setNascimento(novo.getNascimento());
                e.setAnoIngresso(novo.getAnoIngresso());
                return e;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        estudantes.removeIf(e->e.getId()==id);
    }
}