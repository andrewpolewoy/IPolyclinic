package com.it_academy.jd2.storage.api.people;

import com.it_academy.jd2.model.user.Address;
import com.it_academy.jd2.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAddressRepository extends JpaRepository<Address,Integer> {
   Address findById(int id);

   @Query("SELECT a FROM Address a WHERE ?1 MEMBER a.users")
   Address findByUser(User user);

}
