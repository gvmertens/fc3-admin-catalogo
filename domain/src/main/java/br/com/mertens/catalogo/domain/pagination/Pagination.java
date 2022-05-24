package br.com.mertens.catalogo.domain.pagination;

import java.util.List;

public record Pagination<T>(int currentPagem, int perPage, long total, List<T> items) {
}
