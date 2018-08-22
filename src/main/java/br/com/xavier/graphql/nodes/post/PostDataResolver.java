package br.com.xavier.graphql.nodes.post;

import br.com.xavier.graphql.nodes.author.Author;
import br.com.xavier.graphql.nodes.author.AuthorService;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class PostDataResolver implements GraphQLResolver<Post>{

	public PostDataResolver() {
	}

	public Author author(Post post){
		return AuthorService.getInstance().findById(post.getAuthorId());
	}
}
