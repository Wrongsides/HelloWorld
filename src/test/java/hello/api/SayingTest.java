package hello.api;

import static io.dropwizard.testing.FixtureHelpers.*;
import static org.assertj.core.api.Assertions.assertThat;
import io.dropwizard.jackson.Jackson;

import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SayingTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void sayingSerializesToJSON() throws Exception {
        final Saying saying = new Saying(1L, "Hello, Stranger!");
        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/saying.json"), Saying.class));

        assertThat(MAPPER.writeValueAsString(saying)).isEqualTo(expected);
    }

}