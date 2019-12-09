package com.hackersanon.banqi.service;

import com.hackersanon.banqi.dao.UserDAO;
import com.hackersanon.banqi.model.user.User;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.when;

public class UserServiceTest
{
    @Mock
    private UserDAO userDAO;

    @Mock
    private User user;

    private IUserService userService;
    private Long id = 1L;
    private String username;

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @Before
    public void before(){
        username = "testUsername";
        email = "test@test.com";
        password = "12345";
        firstName = "Test";
        lastName = "Tester";
        username = "testUser";
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userDAO);
        when(userDAO.findById(id)).thenReturn(Optional.ofNullable(user));
        when(userDAO.save(ArgumentMatchers.any(User.class))).then(returnsFirstArg());
        when(userDAO.findUserByUsername(username)).thenReturn(user);
        when(userService.getUsername(id)).thenReturn(username);
        when(userService.listAllUsers()).thenReturn(Lists.newArrayList(user));
    }


    @After
    public void after(){
        userService = null;
    }

    @Test
    public void testCreateUser(){

        User testUser = new User(firstName,lastName,email,password,username);
        user = userService.createUser(testUser);
        assertEquals(email, user.getEmail());
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    public void testFindById(){
        assertEquals(user, userService.findById(id));
    }

    @Test
    public void testFindByUsername(){
        assertEquals(user, userDAO.findUserByUsername(username));
    }

    @Test
    public void testDeleteByUserId(){

    }

    @Test
    public void testUpdateUser(){
        User testUser = new User(firstName, lastName, email,password,username);
        assertEquals(email, userService.updateUser(testUser).getEmail());
    }

    @Test
    public void testGetUsername(){
        assertEquals(username, userService.getUsername(id));
    }

    @Test
    public void testListAllUsers(){
        assertEquals(Lists.newArrayList(user), userService.listAllUsers());
    }
}
