package br.com.xavier.graphql.nodes.author;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

	public Author createAuthor(@NonNull String name){
		Author newAuthor = Author.of(getNextId(), name, new LinkedList<>());

		save(newAuthor);
		return newAuthor;
	}

	void save(@NonNull Author author) {
		repository.save(author);
	}

	Long getNextId(){
		return repository.countTotal() + 1L;
	}

	public void addPost(@NonNull Long authorId, Long postId){
		Author author = this.findById(authorId);
		if(Objects.isNull(author)){
			throw new IllegalArgumentException("Unknown Author id.");
		}

		author.getPostsIds().add(postId);
	}
}
