package cat.udl.iaeste.intraweb.controllers;

import cat.udl.iaeste.intraweb.models.User;
import cat.udl.iaeste.intraweb.repositories.UserRepository;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by eduard on 04/05/15.
 */

@Controller
@RequestMapping(value = "/users")
public class UserController {
    final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired UserRepository userRepository;

    // LIST
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> list(@RequestParam(required = false, defaultValue = "0") int page,
                               @RequestParam(required = false, defaultValue = "10") int size) {
        PageRequest request = new PageRequest(page, size);

        return userRepository.findAll(request).getContent();
    }

    @RequestMapping(method = RequestMethod.GET, produces = "text/html")
    public ModelAndView listHtml(@RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "10") int size) {
        return new ModelAndView("users", "users", list(page, size));
    }

    // RETRIEVE
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @ResponseBody
    public User retrieve(@PathVariable("username") String username) {
        logger.info("Retrieving user {}", username);
        Preconditions.checkNotNull(userRepository.findOne(username), "User with id %s not found", username);
        return userRepository.findUserByUsername(username);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView retrieveHTML(@PathVariable("id") String username) {
        return new ModelAndView("user", "user", retrieve(username));
    }

    // RETRIEVE LOGGED USER
    @RequestMapping("/current")
    @ResponseBody
    public User user(Principal user) {
        logger.info("Retrieving current logged in user {}", user.getName());
        return user(user);
    }

    @RequestMapping(value = "/current", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView userHTML( Principal user) {
        return new ModelAndView("user", "user", user(user));
    }
}

