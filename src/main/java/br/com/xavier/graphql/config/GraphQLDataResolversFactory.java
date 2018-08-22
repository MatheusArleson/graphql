package br.com.xavier.graphql.config;

import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.stream.Stream;

class GraphQLDataResolversFactory {

	private GraphQLDataResolversFactory() {
		throw new UnsupportedOperationException("Static is the way to go.");
	}

	static Stream<GraphQLResolver> getDataResolvers(){
		return Stream.of(GraphQLEndpointConfig.getDataResolvers());
	}

}
