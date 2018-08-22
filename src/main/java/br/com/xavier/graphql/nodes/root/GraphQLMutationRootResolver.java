package br.com.xavier.graphql.nodes.root;

import br.com.xavier.graphql.nodes.author.Author;
import br.com.xavier.graphql.nodes.author.AuthorService;
import br.com.xavier.graphql.nodes.post.Post;
import br.com.xavier.graphql.nodes.post.PostService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public class GraphQLMutationRootResolver implements GraphQLMutationResolver {

	private final PostService postService = PostService.getInstance();
	private final AuthorService authorService = AuthorService.getInstance();

	public GraphQLMutationRootResolver() {
	}

	public Post createPost(String content, Long authorId){
		Post newPost = Post.of(postService.getNextId(), content, authorId);

		postService.save(newPost);
		return newPost;
	}

	public Author createAuthor(String name){
		Author newAuthor = Author.of(authorService.getNextId(), name);

		authorService.save(newAuthor);
		return newAuthor;
	}
}
