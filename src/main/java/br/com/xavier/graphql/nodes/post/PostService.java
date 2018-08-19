package br.com.xavier.graphql.nodes.post;

import br.com.xavier.graphql.nodes.author.AuthorService;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

public class PostService {

	private final PostRepository repository = new PostRepository();
	private final AuthorService authorService = new AuthorService();

	public List<Post> findAll() {
		return repository.findAll();
	}

	public Post findById(@NonNull Long id){
		return repository.findById(id);
	}

	public void save(@NonNull Post post) {
		repository.save(post);
	}

}
