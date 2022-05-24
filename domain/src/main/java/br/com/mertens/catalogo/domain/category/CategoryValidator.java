package br.com.mertens.catalogo.domain.category;

import br.com.mertens.catalogo.domain.validation.Error;
import br.com.mertens.catalogo.domain.validation.ValidationHandler;
import br.com.mertens.catalogo.domain.validation.Validator;

public class CategoryValidator extends Validator {

    private final Category category;

    private final Integer NAME_MIN_LENGTH = 3;
    private final Integer NAME_MAX_LENGTH = 255;

    protected CategoryValidator(final Category category, ValidationHandler aHandler) {
        super(aHandler);
        this.category = category;
    }

    @Override
    public void validate() {
        checkNamesConstraints();
    }

    private void checkNamesConstraints() {
        final var name = this.category.getName();
        if(name == null){
            this.validationHandler().append(new Error("'name' should not be null"));
            return;
        }

        if(name.isBlank()){
            this.validationHandler().append(new Error("'name' should not be empty"));
            return;
        }

        final var length = name.trim().length();
        if(length < NAME_MIN_LENGTH || length > NAME_MAX_LENGTH) {
            this.validationHandler().append(new Error("'name' should be between 3 and 255 characters long."));
        }
    }

    public Category getCategory() {
        return category;
    }
}
