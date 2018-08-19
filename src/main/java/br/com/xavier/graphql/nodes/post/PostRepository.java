package br.com.xavier.graphql.nodes.post;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PostRepository {

	private final List<Post> posts;

	protected PostRepository() {
		this.posts = new ArrayList<>();
		initialize();
	}

	private void initialize() {
		save(Post.of(1L, "Post 1", 1L));
		save(Post.of(2L, "Post 2", 2l));
	}

	public List<Post> findAll() {
		return posts;
	}

	public Post findById(@NonNull Long id){
		return findAll().stream()
			.filter(e -> e.getId().equals(id))
			.findFirst()
			.orElse(null)	;
	}

	public void save(@NonNull Post post) {
		this.posts.add(post);
	}

	public int countTotal() {
		return posts.size();
	}
}
