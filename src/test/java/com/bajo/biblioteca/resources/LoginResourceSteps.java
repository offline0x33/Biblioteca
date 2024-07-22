/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bajo.biblioteca.resources;

import com.bajo.biblioteca.dao.UserDAO;
import com.bajo.biblioteca.resources.LoginResource;
//import com.bajo.biblioteca.resources.auth.util.HashPassword;
import com.bajo.biblioteca.resources.auth.jwt.util.Login;
import com.bajo.biblioteca.model.User;
import com.bajo.biblioteca.resources.auth.jwt.TokenGenerator;
import com.bajo.biblioteca.resources.auth.jwt.TokenValidator;
//import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.security.enterprise.AuthenticationException;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

/**
 *
 * @author bajinho
 */
public class LoginResourceSteps {

    private LoginResource loginResource;
    private UserDAO dao;
    private TokenGenerator tokenGenerator;
    private TokenValidator tokenValidator;

    private final Long id = 1L;
    private final String username = "validUsername";
    private final String authorities = "ROLE_USER";
    private final String email = "valid@email.com";
    private final String password = "secret";
    private final String hashedPassword = "$2a$12$xgG4AjFe4WNDbotwOs1w3e.1e3/iZOdyEdui2fQ01J0Vk5wRsyQf6";

    @Given("a registered user")
    public void aRegisteredUser() {
        // Mock user data and persistence
//        User user = new User(id, username, password, email, authorities);
        dao = Mockito.mock(UserDAO.class);
//        when(dao.consultarPorEmail("valid@email.com")).thenReturn(user);
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() throws AuthenticationException {
        // Set valid login credentials
        Login login = new Login("valid@email.com", "secret");
        loginResource = new LoginResource();
        loginResource.login(login);
    }

    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() throws AuthenticationException {
        // Set invalid login credentials
        Login login = new Login("valid@email.com", "secreto");
        loginResource = new LoginResource();
        loginResource.login(login);
    }

    @Then("the system should return a valid JWT token")
    public void theSystemShouldReturnAValidJWToken() throws AuthenticationException {
        // Mock token generation and verify response
//        String expectedToken = "valid-jwt-token";
        tokenGenerator = Mockito.mock(TokenGenerator.class);
        tokenValidator = new TokenValidator();
        when(tokenGenerator.generateToken(any(User.class))).thenReturn("");

        Response response = loginResource.login(new Login("valid@email.com", "secret"));
        Assertions.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        Assertions.assertEquals(tokenValidator.verifyToken(tokenGenerator.getKeyToken()), response.getEntity());
    }

    @Then("the system should return an unauthorized error message")
    public void theSystemShouldReturnAnUnauthorizedErrorMessage() {
        // Verify unauthorized response
//        Response response = loginResource.login(new Login("valid@email.com", "wrongPassword"));
//        Assertions.assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
//        Assertions.assertEquals("Invalid login attempt", response.getEntity());
    }

    @Then("the system should return an internal server error message")
    public void theSystemShouldReturnAnInternalServerErrorMassage() {
        // Mock token generation error and verify response
//        tokenGenerator = Mockito.mock(TokenGenerator.class);
//        when(tokenGenerator.generateToken(any(User.class))).thenThrow(new RuntimeException());

//        Response response = loginResource.login(new Login("valid@email.com", "secret"));
//        Assertions.assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
//        Assertions.assertEquals("An error occurred", response.getEntity());
    }
}
