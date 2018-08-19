package br.com.xavier.graphql.nodes.post;

import br.com.xavier.graphql.nodes.author.AuthorService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostService {

	private final PostRepository repository = new PostRepository();
	private final AuthorService authorService = AuthorService.getInstance();

	private static final PostService INSTANCE = new PostService();
	public static PostService getInstance(){
		return INSTANCE;
	}

	public List<Post> findAll() {
		return repository.findAll();
	}

	public Post findById(@NonNull Long id){
		return repository.findById(id);
	}

	public Long getNextId(){
		return repository.countTotal() + 1L;
	}

	public void save(@NonNull Post post) {
		repository.save(post);
	}

}
