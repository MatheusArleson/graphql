package br.com.xavier.graphql.nodes.post;

import br.com.xavier.graphql.nodes.author.Author;
import br.com.xavier.graphql.nodes.author.AuthorService;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class PostDataResolver implements GraphQLResolver<Post>{

	private final AuthorService authorService = AuthorService.getInstance();

	public PostDataResolver() {
	}

	public Author author(Post post){
		return authorService.findById(post.getAuthorId());
	}
}
