/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bathwater;

import java.util.Base64;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.Test;
import static junit.framework.TestCase.assertNotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * @author rajeshk
 */
public class TestLogin {
    
    public static final String BASE_URI = "http://localhost:8082/BathwaterKidsAWS/rest";
    
    @Test
    public void testLoginBlankDetails() throws ParseException {
        String emailAddress = "";
        String password = "";
        String userType = "normal";
        
        String body = "{"
                + "\"emailAddress\":\"" + emailAddress + "\","
                + "\"password\":\"" + password + "\","
                + "\"userType\":\"" + userType + "\""
                + "}";
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(BASE_URI).path("/login").request().post(Entity.entity(body, MediaType.APPLICATION_JSON), Response.class);
        
        String res = response.readEntity(String.class);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(res);
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+json);
        assertEquals("success", json.get("message"));
        assertNull((String) json.get("userid"));
        assertNull((String) json.get("key"));
    }
    
    @Test
    public void testLogin() throws ParseException {
        String emailAddress = "rajesh.k.nitk@gmail.com";
        String password = Base64.getEncoder().encodeToString("s@mpl3".getBytes());
        String userType = "normal";
        
        String body = "{"
                + "\"emailAddress\":\"" + emailAddress + "\","
                + "\"password\":\"" + password + "\","
                + "\"userType\":\"" + userType + "\""
                + "}";
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(BASE_URI).path("/login").request().post(Entity.entity(body, MediaType.APPLICATION_JSON), Response.class);
        
        String res = response.readEntity(String.class);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(res);

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+json);
        assertEquals("success", json.get("message"));
        assertNotNull((String) json.get("userid"));
        assertNotNull((String) json.get("key"));
    }
    
    @Test
    public void testLoginIncorrectpassword() throws ParseException {
        String emailAddress = "rajesh.k.nitk@gmail.com";
        String password = Base64.getEncoder().encodeToString("wrong password".getBytes());
        String userType = "normal";
        
        String body = "{"
                + "\"emailAddress\":\"" + emailAddress + "\","
                + "\"password\":\"" + password + "\","
                + "\"userType\":\"" + userType + "\""
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
    public void testLoginInvalidEmail() throws ParseException {
        String emailAddress = "rajesh@test.com";
        String password = Base64.getEncoder().encodeToString("s@mpl3".getBytes());
        String userType = "normal";
        
        String body = "{"
                + "\"emailAddress\":\"" + emailAddress + "\","
                + "\"password\":\"" + password + "\","
                + "\"userType\":\"" + userType + "\""
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
    public void testLoginFBUserWithoutMembership() throws ParseException {
        String emailAddress = "rajkumar@bathwaterkids.com";
        String userType = "fbUser";
        
        String body = "{"
                + "\"emailAddress\":\"" + emailAddress + "\","
                + "\"userType\":\"" + userType + "\""
                + "}";
        
        Client client = ClientBuilder.newClient();
        Response response = client.target(BASE_URI).path("/login").request().post(Entity.entity(body, MediaType.APPLICATION_JSON), Response.class);
        
        String res = response.readEntity(String.class);
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(res);
        
        
        assertEquals("success without membership", json.get("message"));
    }
    
}
