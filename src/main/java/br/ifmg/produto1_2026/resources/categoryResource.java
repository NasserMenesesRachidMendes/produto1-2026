package br.ifmg.produto1_2026.resources;

import br.ifmg.produto1_2026.dto.CategoryDTO;
import br.ifmg.produto1_2026.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class categoryResource {

    @Autowired
    private CategoryService categorieService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> category(){


        List<CategoryDTO> categories = categorieService.findAll();


        return ResponseEntity.ok().body(categories);
    };
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> category(@PathVariable Long id){

        CategoryDTO dto = categorieService.findById(id);

        return ResponseEntity.ok().body(dto);
    }

    public ResponseEntity <CategoryDTO> insert(@RequestBody CategoryDTO dto){
        CategoryDTO returnDTO = categorieService.insert(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(returnDTO.getId()).toUri();
        return ResponseEntity.created(location).body(returnDTO);
    }
}
