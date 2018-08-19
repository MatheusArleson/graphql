package br.com.xavier.graphql.nodes.author;

import br.com.xavier.graphql.nodes.post.Post;
import com.coxautodev.graphql.tools.GraphQLResolver;

public class AuthorDataResolver implements GraphQLResolver<Post>{

	private final AuthorService service = new AuthorService();

	public AuthorDataResolver() {

	}

}
