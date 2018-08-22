package br.com.xavier.graphql.nodes.author;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class AuthorRepository {

	private final List<Author> authors;

	AuthorRepository() {
		this.authors = new ArrayList<>();
		initialize();
	}

	private void initialize() {
		save(Author.of(1L, "Author 1", new LinkedList<>()));
		save(Author.of(2L, "Author 2", new LinkedList<>()));
	}

	List<Author> findAll() {
		return authors;
	}

	Author findById(@NonNull Long id){
		return findAll().stream()
			.filter(e -> e.getId().equals(id))
			.findFirst()
			.orElse(null)	;
	}

	void save(@NonNull Author author) {
		this.authors.add(author);
	}

	Long countTotal() {
		return authors.size() + 1L;
	}
}
