package br.com.xavier.graphql.nodes.root;

import br.com.xavier.graphql.nodes.author.Author;
import br.com.xavier.graphql.nodes.author.AuthorService;
import br.com.xavier.graphql.nodes.post.Post;
import br.com.xavier.graphql.nodes.post.PostService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class GraphQLMutationRootResolver implements GraphQLMutationResolver {

	public GraphQLMutationRootResolver() {
	}

	public Post createPost(String content, Long authorId){
		return PostService.getInstance().createPost(content, authorId);
	}

	public Author createAuthor(String name){
		return AuthorService.getInstance().createAuthor(name);
	}
}
