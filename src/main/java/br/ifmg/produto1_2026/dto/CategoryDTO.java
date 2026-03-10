package br.ifmg.produto1_2026.dto;

import br.ifmg.produto1_2026.entities.Category;

public class CategoryDTO {


    private Long id;
    private String name;

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public CategoryDTO(Category category) {
      this.name = category.getNome();
      this.id = category.getId();
    }
    public CategoryDTO() {

    }

    public static void add(CategoryDTO categoryDTO) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
