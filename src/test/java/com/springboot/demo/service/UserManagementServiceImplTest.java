package com.springboot.demo.service;

import com.springboot.demo.dao.UserRepository;
import com.springboot.demo.dtos.UserDto;
import com.springboot.demo.entity.User;
import com.springboot.demo.service.impl.UserManagementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UserManagementServiceImplTest {

    @InjectMocks
    private UserManagementServiceImpl userManagementService;
    @Mock
    private UserRepository userRepository;
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setFirstName("Test First Name");
        user.setLastName("Test Last Name");
    }

    @Test
    void createUserTest() {
        when(userRepository.save(any(User.class))).thenReturn(user);
        User result = userManagementService.createUser(user);
        assertEquals(user.getFirstName(), result.getFirstName());
        assertEquals(user.getLastName(), result.getLastName());
    }

    @Test
    void createUserNullTest() {
        User result = userManagementService.createUser(user);
        assertNull(result);
    }

    @Test
    void findByIdTest(){
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        User result = userManagementService.findById(1);
        assertEquals(user.getFirstName(),result.getFirstName());
    }

    @Test
    void findByIdEmptyTest(){
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        User result = userManagementService.findById(1);
        assertNull(result);
    }

    @Test
    void findByMobileIdNumberWithNativeTest(){
        UserDto userDto= new UserDto();
        userDto.setContactNumber("");
        userDto.setId(2);
        userDto.setAddress("");

        when(userRepository.findByMobileIdNumberWithNative(anyLong(),anyString(),anyString())).thenReturn(List.of(user));

        List<User> userList = userManagementService.findByMobileIdNumberWithNative(userDto);

        assertNotNull(userList);
        assertEquals(user.getFirstName(),userList.get(0).getFirstName());
    }


}
