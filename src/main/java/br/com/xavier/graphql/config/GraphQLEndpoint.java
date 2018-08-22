package br.com.xavier.graphql.config;

import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.SimpleInstrumentation;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

	public GraphQLEndpoint() {
		super(createServletBuilder());
	}

	private static Builder createServletBuilder() {
		GraphQLSchema schema = createGraphQLSchema();
		Builder builder = createServletBuilder(schema);

		configureBuilder(builder);
		return builder;
	}

	private static GraphQLSchema createGraphQLSchema(){
		return GraphQLSchemaFactory.createEndpointSchema();
	}

	private static Builder createServletBuilder(GraphQLSchema schema){
		return SimpleGraphQLServlet.builder(schema);
	}

	private static void configureBuilder(Builder builder) {
//		Instrumentation instrumentation = SimpleInstrumentation.INSTANCE;
//		builder.withInstrumentation(instrumentation);
	}

}
