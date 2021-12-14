package com.it_academy.jd2.service.api.user;

import com.it_academy.jd2.model.dto.UserDto;
import com.it_academy.jd2.model.user.Passport;
import com.it_academy.jd2.model.user.User;
import com.it_academy.jd2.model.user.enums.Role;

import java.util.List;
import java.util.Set;


public interface IUserService {
    User getUserByEmail(String email);
    User registerUser(String email, String password, String tel);
    User getUserByPassport(Passport passport);
    User getUserById(int id);
    String geteMailById(int id);
    List<User> getAll();
    User addUser(User user);
    boolean updatePatient(User user, int id);
    boolean delete(int id);
    List<User> getAllUsersByRole(Set<Role> roles);
    Set<UserDto> getAllUsersInfoByRole(Set<Role> roles);
    User getByTicketId(Set<Role> roles, long id);
    boolean updateAddress(User user, int id);
    boolean updatePassport(User user, int id);
    boolean updateDoctorInfo(User user, int id);

}

