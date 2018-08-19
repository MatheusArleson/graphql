package br.com.xavier.graphql.config;

import br.com.xavier.graphql.nodes.author.Author;
import br.com.xavier.graphql.nodes.author.AuthorService;
import br.com.xavier.graphql.nodes.post.Post;
import br.com.xavier.graphql.nodes.post.PostService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

public class GraphqlQueryRootResolver implements GraphQLQueryResolver {

	private final PostService postService = new PostService();
	private final AuthorService authorService = new AuthorService();

	public List<Post> allPosts() {
		return postService.findAll();
	}

	public List<Author> allAuthors() {
		return authorService.findAll();
	}
}
