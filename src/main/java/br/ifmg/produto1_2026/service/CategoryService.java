package br.ifmg.produto1_2026.service;

import br.ifmg.produto1_2026.dto.CategoryDTO;
import br.ifmg.produto1_2026.entities.Category;
import br.ifmg.produto1_2026.repositories.CategorieRepository;
import br.ifmg.produto1_2026.service.exception.DataBaseError;
import br.ifmg.produto1_2026.service.exception.ResourceNotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategorieRepository categorieRepository;
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){

    List<Category> categories = categorieRepository.findAll();

    List<CategoryDTO> categoriesDTO = new ArrayList<CategoryDTO>();

//    for(Category category : categories){
//        CategoryDTO.add(new CategoryDTO(category));
//    }
     return categories.stream().map (x-> new CategoryDTO(x)).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> opt = categorieRepository.findById(id);
        Category category = opt.orElseThrow(() -> new ResourceNotFound("Categoria não encontrada"));
        return new CategoryDTO(category);
    }
    public CategoryDTO insert(CategoryDTO dto) {
        Category category = new Category();
        category.setNome(dto.getName());

        Category category1 = categorieRepository.save(category);
        return new CategoryDTO(category1);

    }
    @Transactional
    public void delete(Long id) {
        if (categorieRepository.existsById(id)){
            throw new ResourceNotFound("Registro não encontrado, para exclusão");
        }
        try {
            categorieRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseError(e.getMessage());
        }
    }
}
