package br.com.xavier.graphql.nodes.post;

import br.com.xavier.graphql.nodes.author.Author;
import br.com.xavier.graphql.nodes.author.AuthorService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.Objects;

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

	public Post createPost(@NonNull String content, @NonNull Long authorId){
		Author author = authorService.findById(authorId);
		if(Objects.isNull(author)){
			throw new IllegalArgumentException("Unknown Author id.");
		}

		Long postId = getNextId();
		Post newPost = Post.of(postId, content, authorId);

		save(newPost);

		authorService.findById(authorId).getPostsIds().add(postId);

		return newPost;
	}

	Long getNextId(){
		return repository.countTotal() + 1L;
	}

	void save(@NonNull Post post) {
		repository.save(post);
	}

}
