package hello;

import org.junit.Test;

import static org.junit.Assert.*;

public class GreeterTest {

    @Test
    public void testSayHello() throws Exception {

        String saying = "Hello world!";
        String sayHello = new Greeter().sayHello();

        assertTrue(String.format("sayHello '%s' does not match the saying '%s'", sayHello, saying),
                sayHello.equals(saying));
    }
}