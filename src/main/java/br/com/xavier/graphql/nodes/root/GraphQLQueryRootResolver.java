package br.com.xavier.graphql.nodes.root;

import br.com.xavier.graphql.nodes.author.Author;
import br.com.xavier.graphql.nodes.author.AuthorService;
import br.com.xavier.graphql.nodes.post.Post;
import br.com.xavier.graphql.nodes.post.PostService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

public class GraphQLQueryRootResolver implements GraphQLQueryResolver {

	private final PostService postService = PostService.getInstance();
	private final AuthorService authorService = AuthorService.getInstance();

	public List<Post> allPosts() {
		return postService.findAll();
	}

	public List<Author> allAuthors() {
		return authorService.findAll();
	}
}
