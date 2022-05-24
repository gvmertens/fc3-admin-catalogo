package br.com.mertens.catalogo.application.category.create;

import br.com.mertens.catalogo.domain.category.Category;
import br.com.mertens.catalogo.domain.category.CategoryGateway;
import br.com.mertens.catalogo.domain.validation.handler.ThrowsValidationHandler;

import java.util.Objects;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase{

    private final CategoryGateway gateway;

    public DefaultCreateCategoryUseCase(final CategoryGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    @Override
    public CreateCategoryOutput execute(final CreateCategoryCommand aCommand) {

        final Category aCategory = Category.newCategory(aCommand.name(), aCommand.description(), aCommand.isActive());
        aCategory.validate(new ThrowsValidationHandler());
        gateway.create(aCategory);
        return CreateCategoryOutput.from(aCategory);
    }
}
