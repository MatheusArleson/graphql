package br.com.xavier.graphql.config;

import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.stream.Stream;

class GraphQLRootResolversFactory {

	private GraphQLRootResolversFactory() {
		throw new UnsupportedOperationException("Static is the way to go.");
	}

	static Stream<GraphQLResolver> getRootResolvers() {
		GraphQLResolver queryRootResolver = GraphQLEndpointConfig.getQueryRootResolver();
		GraphQLResolver mutationRootResolver = GraphQLEndpointConfig.getMutationRootResolver();
		GraphQLResolver subscriptionRootResolver = GraphQLEndpointConfig.getSubscriptionRootResolver();

		return Stream.of(
			queryRootResolver
			, mutationRootResolver
			, subscriptionRootResolver
		);
	}

}
