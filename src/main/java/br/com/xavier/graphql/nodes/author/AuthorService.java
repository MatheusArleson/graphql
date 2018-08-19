package br.com.xavier.graphql.nodes.author;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorService {

	private final AuthorRepository repository = new AuthorRepository();

	private static final AuthorService INSTANCE = new AuthorService();
	public static AuthorService getInstance(){
		return INSTANCE;
	}

	public List<Author> findAll() {
		return repository.findAll();
	}

	public Author findById(@NonNull Long id){
		return repository.findById(id);
	}

	public void save(@NonNull Author author) {
		repository.save(author);
	}

	public Long getNextId(){
		return repository.countTotal() + 1L;
	}
}
