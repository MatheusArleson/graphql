package br.com.xavier.graphql.nodes.author;

import br.com.xavier.graphql.nodes.post.Post;
import br.com.xavier.graphql.nodes.post.PostService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorDataResolver implements GraphQLResolver<Author>{

	public AuthorDataResolver() {
	}

	public List<Post> posts(@NonNull Author author){
		return author.getPostsIds().stream()
			.map(postId -> PostService.getInstance().findById(postId))
			.collect(Collectors.toList());
	}

}
