package br.com.mertens.catalogo.application.category.create;

import br.com.mertens.catalogo.domain.category.Category;
import br.com.mertens.catalogo.domain.category.CategoryID;

public record CreateCategoryOutput(
        CategoryID id
) {

    public static CreateCategoryOutput from(final Category aCategory){
        return new CreateCategoryOutput(aCategory.getId());
    }
}
