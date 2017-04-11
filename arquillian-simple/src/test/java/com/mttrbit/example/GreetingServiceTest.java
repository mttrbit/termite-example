package com.mttrbit.example;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class GreetingServiceTest {
	
	@Inject
	GreetingService greetingService;
	
	@Deployment
    public static Archive<?> myApp() {
        return ShrinkWrap
                .create(WebArchive.class)
                .addClasses(GreetingService.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
	
    @Test
    public void testPerformTest() {
        assertThat(greetingService.hello("Tom"), is("Hello, Tom!"));
    }
}
