package br.com.xavier.graphql.nodes.author;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@NoArgsConstructor
public class AuthorService {

	private final AuthorRepository repository = new AuthorRepository();

	public List<Author> findAll() {
		return repository.findAll();
	}

	public Author findById(@NonNull Long id){
		return repository.findById(id);
	}

	public void save(@NonNull Author author) {
		repository.save(author);
	}
}
