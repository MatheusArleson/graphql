package br.com.xavier.graphql.config;

import br.com.xavier.graphql.nodes.author.AuthorDataResolver;
import br.com.xavier.graphql.nodes.post.PostDataResolver;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.servlet.SimpleGraphQLServlet;
import org.jetbrains.annotations.NotNull;

import javax.servlet.annotation.WebServlet;
import java.util.stream.Stream;

@WebServlet(urlPatterns = "/graphql")
public class GraphqlEndpoint extends SimpleGraphQLServlet {

	public GraphqlEndpoint() {
		super(buildSchema());
	}

	@NotNull
	private static Builder buildSchema() {

		return SimpleGraphQLServlet.builder(
			SchemaParser.newParser()
				.file("schema.graphqls")
				.resolvers(getAllResolvers())
				.build()
				.makeExecutableSchema()
		);
	}

	private static GraphQLResolver[] getAllResolvers(){
		Stream<GraphQLResolver> resolversStream = Stream.concat(getRootResolvers(), getDataResolvers());
		return resolversStream.toArray(GraphQLResolver[]::new);
	}

	private static Stream<GraphQLResolver> getDataResolvers(){
		return Stream.of(
			new PostDataResolver()
			, new AuthorDataResolver()
		);
	}

	private static Stream<GraphQLResolver> getRootResolvers() {
		GraphQLResolver queryRootResolver = getQueryRootResolver();
		GraphQLResolver mutationRootResolver = getMutationRootResolver();
		GraphQLResolver subscriptionRootResolver = getSubscriptionRootResolver();

		return Stream.of(
			queryRootResolver
			, mutationRootResolver
			, subscriptionRootResolver
		);
	}

	private static GraphQLQueryResolver getQueryRootResolver() {
		return new GraphqlQueryRootResolver();
	}

	private static GraphQLMutationResolver getMutationRootResolver() {
		return new GraphqlMutationRootResolver();
	}

	private static GraphQLSubscriptionResolver getSubscriptionRootResolver() {
		return new GraphqlSubscriptionRootResolver();
	}

}
