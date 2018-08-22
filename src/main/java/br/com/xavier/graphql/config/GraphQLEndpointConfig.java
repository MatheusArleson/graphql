package br.com.xavier.graphql.config;

import br.com.xavier.graphql.nodes.author.AuthorDataResolver;
import br.com.xavier.graphql.nodes.post.PostDataResolver;
import br.com.xavier.graphql.nodes.root.GraphQLMutationRootResolver;
import br.com.xavier.graphql.nodes.root.GraphQLQueryRootResolver;
import br.com.xavier.graphql.nodes.root.GraphQLSubscriptionRootResolver;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;

class GraphQLEndpointConfig {

	private static final String[] SCHEMA_FILES = {"schema.graphqls"};

	private static final GraphQLQueryRootResolver QUERY_ROOT_RESOLVER = new GraphQLQueryRootResolver();
	private static final GraphQLMutationRootResolver MUTATION_ROOT_RESOLVER = new GraphQLMutationRootResolver();
	private static final GraphQLSubscriptionRootResolver SUBSCRIPTION_ROOT_RESOLVER = new GraphQLSubscriptionRootResolver();

	private static final GraphQLResolver[] DATA_RESOLVERS = {
		new PostDataResolver()
		, new AuthorDataResolver()
	};

	private GraphQLEndpointConfig() {
		throw new UnsupportedOperationException("Static is the way to go.");
	}

	protected static String[] getAllSchemaFiles(){
		return SCHEMA_FILES;
	}

	protected static GraphQLResolver[] getDataResolvers(){
		return DATA_RESOLVERS;
	}

	protected static GraphQLQueryResolver getQueryRootResolver() {
		return QUERY_ROOT_RESOLVER;
	}

	protected static GraphQLMutationResolver getMutationRootResolver() {
		return MUTATION_ROOT_RESOLVER;
	}

	protected static GraphQLSubscriptionResolver getSubscriptionRootResolver() {
		return SUBSCRIPTION_ROOT_RESOLVER;
	}

}
