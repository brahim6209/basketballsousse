package com.liguebasketball.basketballsousse.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
@RestController
@Transactional
@CrossOrigin("*")
@RequestMapping(path = "user")public class UserController {
   // @Autowired
  //  UserRepository userRepository;





   /* @GetMapping("/all/{role}")
    private List<AppUser> getAllUserByRole(@PathVariable("role") String role){
        List<AppUser> userByRole=userRepository.findByRole(role);
        return userByRole;
    }*/
}
