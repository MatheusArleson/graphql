package br.com.xavier.graphql.nodes.author;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data(staticConstructor = "of")
public class Author {

	@NonNull
	private final Long id;

	@NonNull
	private final String name;

	@NonNull
	private final List<Long> postsIds;
}
