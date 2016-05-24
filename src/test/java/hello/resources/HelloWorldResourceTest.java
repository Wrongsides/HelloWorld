package hello.resources;

import hello.api.Saying;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorldResourceTest {

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new HelloWorldResource("Hello, %s!", "Stranger"))
            .build();

    @Test
    public void testSayHello() {
        Saying actual = resources.client().target("/hello-world")
                .request().get(Saying.class);

        Saying expected = new Saying(1L, "Hello, Stranger!");
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getContent()).isEqualTo(expected.getContent());
    }
}