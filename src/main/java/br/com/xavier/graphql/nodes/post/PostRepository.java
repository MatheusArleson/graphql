package br.com.xavier.graphql.nodes.post;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

class PostRepository {

	private final List<Post> posts;

	PostRepository() {
		this.posts = new ArrayList<>();
	}

	List<Post> findAll() {
		return posts;
	}

	Post findById(@NonNull Long id){
		return findAll().stream()
			.filter(e -> e.getId().equals(id))
			.findFirst()
			.orElse(null)	;
	}

	void save(@NonNull Post post) {
		this.posts.add(post);
	}

	int countTotal() {
		return posts.size();
	}
}
