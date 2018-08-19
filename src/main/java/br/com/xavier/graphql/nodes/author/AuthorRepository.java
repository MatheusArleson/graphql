package br.com.xavier.graphql.nodes.author;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

	private final List<Author> authors;

	protected AuthorRepository() {
		this.authors = new ArrayList<>();
		initialize();
	}

	private void initialize() {
		save(Author.of(1L, "Author 1"));
		save(Author.of(2L, "Author 2"));
	}

	public List<Author> findAll() {
		return authors;
	}

	public Author findById(@NonNull Long id){
		return findAll().stream()
			.filter(e -> e.getId().equals(id))
			.findFirst()
			.orElse(null)	;
	}

	public void save(@NonNull Author author) {
		this.authors.add(author);
	}

	public Long countTotal() {
		return authors.size() + 1L;
	}
}
