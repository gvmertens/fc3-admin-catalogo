package br.com.mertens.catalogo.application.category.create;

import br.com.mertens.catalogo.application.UseCase;
import io.vavr.control.Either;

import javax.management.remote.NotificationResult;

public abstract class CreateCategoryUseCase extends UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {
}
