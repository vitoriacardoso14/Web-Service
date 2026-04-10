package webservice;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private List<Empresa> empresas = new ArrayList<>(List.of(
        criar(1,"Empresa Alfa LTDA","12.345.678/0001-90","contato@empresa-alfa.com"),
        criar(2,"Beta Comércio ME","98.765.432/0001-10","beta@comercio.com"),
        criar(3,"Gamma Serviços S.A.","11.222.333/0001-44","servicos@gamma.com"),
        criar(4,"Delta Engenharia","22.333.444/0001-55","contato@deltaeng.com"),
        criar(5,"Epsilon Digital","33.444.555/0001-66","email@epsilondigital.com")
    ));

    private Empresa criar(int id,String nome,String cnpj,String email){
        Empresa e = new Empresa();
        e.setId(id); e.setNome(nome); e.setCnpj(cnpj);
        e.setEmailContato(email);
        return e;
    }

    @GetMapping
    public List<Empresa> getAll(){ return empresas; }

    @GetMapping("/{id}")
    public Empresa getById(@PathVariable int id){
        return empresas.stream().filter(e->e.getId()==id).findFirst().orElse(null);
    }

    @PostMapping
    public Empresa create(@RequestBody Empresa e){
        empresas.add(e);
        return e;
    }

    @PutMapping("/{id}")
    public Empresa update(@PathVariable int id,@RequestBody Empresa novo){
        for(Empresa e: empresas){
            if(e.getId()==id){
                e.setNome(novo.getNome());
                e.setCnpj(novo.getCnpj());
                e.setEmailContato(novo.getEmailContato());
                return e;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        empresas.removeIf(e->e.getId()==id);
    }
}