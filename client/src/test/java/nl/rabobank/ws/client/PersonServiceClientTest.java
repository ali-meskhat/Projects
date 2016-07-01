package nl.rabobank.ws.client;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.rabobank.mtom.ws.generated.GetPersonsRequest;
import nl.rabobank.mtom.ws.generated.Person;
import nl.rabobank.mtom.ws.generated.PersonResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mortbay.jetty.Request;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

/**
 * Created by ame21103 on 29-6-2016.
 */

@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-ws-client-context.xml" })

public class PersonServiceClientTest {

    private GetPersonsRequest getPersonsRequest;

    @Autowired
    private PersonServiceClient personServiceClient;

    private PersonResponse personResponse;

    @Before
    public void before() {

        personResponse =
                new PersonResponse().withPerson(new Person().withId(0).withFirstName("Joe").withLastName("Last Name"));

        getPersonsRequest = new GetPersonsRequest().withName("Joe");

    }

    @Test
    public void testResponse() {
        Assert.assertEquals(personResponse, personServiceClient.getPersons(getPersonsRequest));
    }

}
