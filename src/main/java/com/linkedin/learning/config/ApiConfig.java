package com.linkedin.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


@Configuration
public class ApiConfig {
	/*Add two beans to the class: ObjectMapper and ObjectWriter*/
	
	/*Why use serialization and deserialization? 
	 * Serialization is saving the state of an Object, 
	 * and being able to reconstitute that state at a later time by deserialization.
	 * 1. During server shutdown, for example, the internal HTTP Sessions are "serialized" out to persistent store so they can be recovered or shared. 
	 * 2. One major use for serialization is for transport. You want to copy or move an object to a remote computer, say a UserProfile. You can serialize the UserProfile, send the serialized data (typically XML) and deserialize it to a new object on the receiving end, at which point it can be manipulated as though it were the original object.
	 * */
	
	/*ObjectMapper defines how JSON strings in the request body are DESERIALIZED from requests in POJOs or Plain Old Java Objects, which we use to model our data.*/
	/*Server receives requests, DESERIALIZEs strings to Java Objects*/
	@Bean
	public ObjectMapper objectMapper() {
		//to parse iso-formatted dates
//		ObjectMapper objectMapper = new ObjectMapper()
//			.registerModule(new ParameterNamesMoudul())
//			.registerModule(new Jdk8Module())
//			.regsiterModule(new JavaTimeModule());
		
		return new ObjectMapper();
	}
	@Bean
	public ObjectWriter objectWritter(ObjectMapper objectMapper) {
		return objectMapper.writerWithDefaultPrettyPrinter();
	}
	
	/*ObjectWritter defines how we SERIALIZE our Java objects into a JSON string in the response body.*/
	/*Server send responses, SERIAZLIZEs Java objects to strings. */

}
