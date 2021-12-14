package com.it_academy.jd2.storage.api.people;

import com.it_academy.jd2.model.dto.UserDto;
import com.it_academy.jd2.model.user.Passport;
import com.it_academy.jd2.model.user.User;
import com.it_academy.jd2.model.user.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface IUserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByeMail(String eMail);
    User findByeMail(String eMail);
    User findByPassport(Passport passport);
    @Query("SELECT u.eMail FROM User u WHERE u.id=?1")
    String findEmailById(int id);
    List<User> findByRolesIn(Set<Role> roles);

    User findById(int id);

    @Query("SELECT new com.it_academy.jd2.model.dto.UserDto(u.id, p.lastName, p.firstName, p.number) " +
            "FROM User u INNER JOIN u.passport AS p " +
            "JOIN u.roles r WHERE r IN (?1) AND u.active=true")
    Set<UserDto> findUsersInfoByRole(Set<Role> roles);

    @Query("SELECT u FROM User u JOIN u.tickets t JOIN u.roles r WHERE r IN (?1) AND t.id=?2")
    User findByTicketId(Set<Role> roles, long id);


}
