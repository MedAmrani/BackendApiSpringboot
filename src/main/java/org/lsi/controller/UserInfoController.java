package org.lsi.controller;



import org.lsi.exceptions.ValidationException;
import org.lsi.model.UserInfo;
import org.lsi.repository.UserInfoRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
@CrossOrigin("*")
@RestController
public class UserInfoController {


    final
    private UserInfoRepository userInfoRepository;

//    private HashData hashData = new HashData();

    public UserInfoController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }


    @PostMapping("/user")
    public Boolean create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {
        String username = body.get("username");
        if (userInfoRepository.existsByUsername(username)){

            throw new ValidationException("Username already existed");

        }

        String password = body.get("password");
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
//        String hashedPassword = hashData.get_SHA_512_SecurePassword(password);
        String fullname = body.get("fullname");
        System.out.print(fullname);
        String email = body.get("email");
        userInfoRepository.save(new UserInfo(username, encodedPassword, fullname, email));
        return true;
    }
    
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @ResponseBody    
    public UserInfo get(@RequestParam("username") String username) {
    	return userInfoRepository.findByUsername(username);
    }

}
