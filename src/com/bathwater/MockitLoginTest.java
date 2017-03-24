package com.bathwater;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.bathwater.dao.DAO;
import com.bathwater.dto.LoginParameters;
import com.bathwater.dynamodb.helper.IDynamoDBHelper;
import com.bathwater.dynamodb.helper.queries.DynamoDBQueries;
import com.bathwater.dynamodb.helper.queries.IDynamoDBQueries;
import com.bathwater.dynamodb.helper.queries.IDynamoDBScans;
import com.bathwater.elasticsearch.helper.queries.ESItemQueries;
import com.bathwater.elasticsearch.helper.queries.IESItemQueries;
 
@RunWith(MockitoJUnitRunner.class)
public class MockitLoginTest  extends JerseyTest{
    
	public static final String BASE_URI = "http://localhost:8082/BathwaterKidsAWS/rest";
	
	@InjectMocks
	private BathwaterRest bathwaterRest;
	
	private List<MockUserTable> list = new ArrayList<>();
   
    @InjectMocks
    private DAO dao = null;
    
    @Mock
    static IDynamoDBScans scanHelper;
    
    @Mock
	static IDynamoDBHelper helper;

/*    @Before
    @Override
    public Application configure() {
        return new ResourceConfig() {
            {
                register(new TestBinder());
                register(com.bathwater.BathwaterRest.class);
                register(com.bathwater.resetpassword.PasswordResetRest.class);
            }
        };
    }*/
    
    @Test
    public void testInvalidEmailLogin() throws ParseException 
    {
    	LoginParameters log = new LoginParameters();
        
        log.setEmailAddress("rajesh.nitk@gmail.com");
        log.setPassword(Base64.getEncoder().encodeToString("s@mpl3".getBytes()));
        log.setUserType("normal");
        String body = "{"
                + "\"emailAddress\":\"" + log.getEmailAddress() + "\","
                + "\"password\":\"" + log.getPassword() + "\","
                + "\"userType\":\"" + log.getUserType() + "\""
                + "}";
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(BASE_URI).path("/login").request().post(Entity.entity(body, MediaType.APPLICATION_JSON), Response.class);
        
        String res = response.readEntity(String.class);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(res);
        assertEquals("email not registered", json.get("message"));
        assertNull((String) json.get("userid"));
        assertNull((String) json.get("key"));
    }
    
    @Test
    public void testInvalidPassLogin() throws ParseException 
    {
    	LoginParameters log = new LoginParameters();
        
        log.setEmailAddress("rajesh.k.nitk@gmail.com");
        log.setPassword(Base64.getEncoder().encodeToString("s@mpl23".getBytes()));
        log.setUserType("normal");
        String body = "{"
                + "\"emailAddress\":\"" + log.getEmailAddress() + "\","
                + "\"password\":\"" + log.getPassword() + "\","
                + "\"userType\":\"" + log.getUserType() + "\""
                + "}";
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(BASE_URI).path("/login").request().post(Entity.entity(body, MediaType.APPLICATION_JSON), Response.class);
        
        String res = response.readEntity(String.class);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(res);
        assertEquals("email and password did not match", json.get("message"));
        assertNull((String) json.get("userid"));
        assertNull((String) json.get("key"));
    }
    
    @Test
    public void testValidLogin() throws ParseException{

    	LoginParameters log = new LoginParameters();
        
        log.setEmailAddress("rajesh.k.nitk@gmail.com");
        log.setPassword(Base64.getEncoder().encodeToString("s@mpl3".getBytes()));
        log.setUserType("normal");
        log.setToken("eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE0OTAxNjQ2ODIsInVzZXJJZCI6InJhamVzaC5rLm5pdGtAZ21haWwuY29tIn0.XNDoS1-Zz1lWHqUmvAym8dAQA-p8xIhHqpGwPplHGYI");
        String body = "{"
                + "\"emailAddress\":\"" + log.getEmailAddress() + "\","
                + "\"password\":\"" + log.getPassword() + "\","
//                + "\"token\":\"" + log.getToken() + "\","
                + "\"userType\":\"" + log.getUserType() + "\""
                + "}";
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(BASE_URI).path("/login").request().post(Entity.entity(body, MediaType.APPLICATION_JSON), Response.class);
        
        String res = response.readEntity(String.class);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(res);
        assertEquals("success", json.get("message"));
        assertNotNull((String) json.get("userid"));
        assertNotNull((String) json.get("key"));
    }
    
/*    public static class TestBinder extends AbstractBinder{
    	 
        @Override
        public void configure() {
        	helper = new MockDBHelper();
        	scanHelper = new MockDBHelper();
        	bind(new AuthenticationService()).to(AuthenticationService.class);
        	bind(new BathwaterRest(helper, scanHelper, null, null, null)).to(BathwaterRest.class);
            bind(MockDBHelper.class).to(IDynamoDBHelper.class);
            bind(MockDBHelper.class).to(IDynamoDBScans.class);
            bind(DynamoDBQueries.class).to(IDynamoDBQueries.class);
            bind(ESItemQueries.class).to(IESItemQueries.class);     
            bind(Random.class).to(	Random.class);
        }
         
    }*/
 
}