package br.com.xavier.graphql.config;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;

import java.util.stream.Stream;

class GraphQLSchemaFactory {

	private GraphQLSchemaFactory() {
		throw new UnsupportedOperationException("Static is the way to go.");
	}

	static GraphQLSchema createEndpointSchema(){
		String[] allSchemaFiles = getAllSchemaFiles();
		GraphQLResolver[] allResolvers = getAllResolvers();

		return SchemaParser.newParser()
			.files(allSchemaFiles)
			.resolvers(allResolvers)
			.build()
			.makeExecutableSchema();
	}

	private static String[] getAllSchemaFiles(){
		return GraphQLEndpointConfig.getAllSchemaFiles();
	}

	private static GraphQLResolver[] getAllResolvers(){
		Stream<GraphQLResolver> resolversStream = Stream.concat(getRootResolvers(), getDataResolvers());
		return resolversStream.toArray(GraphQLResolver[]::new);
	}

	private static Stream<GraphQLResolver> getRootResolvers() {
		return GraphQLRootResolversFactory.getRootResolvers();
	}

	private static Stream<GraphQLResolver> getDataResolvers(){
		return GraphQLDataResolversFactory.getDataResolvers();
	}

}
