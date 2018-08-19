package br.com.xavier.graphql.nodes.post;

import lombok.Data;
import lombok.NonNull;

@Data(staticConstructor = "of")
public class Post {

	@NonNull
	private final Long id;

	@NonNull
	private final String content;

	@NonNull
	private final Long authorId;

}
