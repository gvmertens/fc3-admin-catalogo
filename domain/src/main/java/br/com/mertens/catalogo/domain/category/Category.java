package br.com.mertens.catalogo.domain.category;

import br.com.mertens.catalogo.domain.AggregateRoot;
import br.com.mertens.catalogo.domain.validation.ValidationHandler;

import java.time.Instant;
import java.util.UUID;

public class Category extends AggregateRoot<CategoryID> {

    private String name;
    private String description;
    private boolean active;
    private Instant createdAt;
    private Instant updateAt;
    private Instant deletedAt;

    private Category(final CategoryID id, final String name, final String description, final boolean active, final Instant createdAt, final Instant updateAt, final Instant deletedAt) {
        super(id);
        this.name = name;
        this.description = description;
        this.active = active;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.deletedAt = deletedAt;
    }

    public static Category newCategory(final String aName, final String aDescription, final boolean isActive){

        final var id = CategoryID.unique();
        final var instant = Instant.now();
        final var deletedAt = isActive ? null : instant;
        return new Category(id, aName, aDescription, isActive, instant, instant, deletedAt);
    }

    @Override
    public void validate(final ValidationHandler handler) {
        new CategoryValidator(this, handler).validate();
    }

    public Category deactivate(){
        if(getDeletedAt() == null){
            this.deletedAt = Instant.now();
        }
        this.active = false;
        this.updateAt = Instant.now();
        return this;
    }

    public Category activate(){
        this.deletedAt = null;
        this.active = true;
        this.updateAt = Instant.now();
        return this;
    }

    public Category update(final String aName, final String aDescription, final boolean isActive){
        this.name = aName;
        this.description = aDescription;
        if(isActive){
            activate();
        } else {
            deactivate();
        }
        this.updateAt = Instant.now();
        return this;
    }

    public CategoryID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}
