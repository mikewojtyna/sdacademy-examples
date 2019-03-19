package pl.sdacademy.db.mongo;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;
import static org.assertj.core.api.Assertions.*;

public class MongoDbIntegraionTest {
	// should be unique random to make tests isolated
	private static final int MONGO_SERVER_PORT = 27017;
	private MongoClient mongoClient;
	private MongodExecutable mongodExecutable;

	@BeforeEach
	void beforeEach() throws Exception {
		startEmbeddedMongoServer();
		mongoClient = MongoClients.create(settings());
	}

	private MongoClientSettings settings() {
		return codecSettings();
	}

	/**
	 * @return
	 * @see
	 * <a href="http://mongodb.github.io/mongo-java-driver/3.8/driver/getting-started/quick-start-pojo/">Created
	 * according to the documentation
	 * </a>
	 */
	private MongoClientSettings codecSettings() {
		return MongoClientSettings.builder().codecRegistry(CodecRegistries.fromRegistries(com.mongodb.MongoClient.getDefaultCodecRegistry(), CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()))).build();
	}

	private void startEmbeddedMongoServer() throws Exception {
		MongodStarter starter = MongodStarter.getDefaultInstance();

		String bindIp = "localhost";
		int port = MONGO_SERVER_PORT;
		IMongodConfig mongodConfig =
			new MongodConfigBuilder().version(Version.Main.PRODUCTION).net(new Net(bindIp, port,
				Network.localhostIsIPv6())).build();

		mongodExecutable = starter.prepare(mongodConfig);
		mongodExecutable.start();
	}

	@AfterEach
	void afterEach() {
		mongoClient.close();
		stopEmbeddedMongoServer();
	}

	private void stopEmbeddedMongoServer() {
		mongodExecutable.stop();
	}

	@DisplayName("show how to create mongo movie collection and query it")
	@Test
	void collection() {
		// given
		MongoDatabase database = mongoClient.getDatabase("movieDb");
		Movie movie = new Movie();
		movie.setTitle("title of the movie");
		movie.setGenres(Arrays.asList("genre0", "genre1"));

		// when
		MongoCollection<Movie> collection = database.getCollection("movie", Movie.class);
		collection.insertOne(movie);

		// then
		Movie foundMovie = collection.find(eq("title", "title of the movie")).first();
		assertThat(foundMovie.getTitle()).isEqualTo("title of the movie");
	}
}
