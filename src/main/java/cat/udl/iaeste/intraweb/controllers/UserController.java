package cat.udl.iaeste.intraweb.controllers;

import cat.udl.iaeste.intraweb.models.User;
import cat.udl.iaeste.intraweb.repositories.UserRepository;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by eduard on 04/05/15.
 */

@Controller
@RequestMapping(value = "/users")
public class UserController {

    final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    // LIST
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> list(@RequestParam(required = false, defaultValue = "0") int page,
                               @RequestParam(required = false, defaultValue = "10") int size) {

        PageRequest pageRequest = new PageRequest(page, size);
        return userRepository.findAll(pageRequest).getContent();
    }

    @RequestMapping(method = RequestMethod.GET, produces = "text/html")
    public ModelAndView listHTML(@RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "10") int size) {
        return new ModelAndView("users", "users", list(page, size));
    }

    // CREATE
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User create(@Valid @RequestBody User user, HttpServletResponse response) {
        return userRepository.save(user);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String createHtml(@Valid @ModelAttribute("user") User user, BindingResult binding, HttpServletResponse response) {
        if (binding.hasErrors()) {
            return "userForm";
        }
        return "redirect:/users/" + create(user, response).getUsername();
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView createForm() {
        User emptyUser = new User();
        return new ModelAndView("userForm", "user", emptyUser);
    }


    // RETRIEVE
    @RequestMapping(value = "/{usename}", method = RequestMethod.GET)
    @ResponseBody
    public User retrieve(@PathVariable("username") String username) {
        logger.info("Retrieving user {}", username);
        Preconditions.checkNotNull(userRepository.findOne(username), "User with username %s not found", username);
        return userRepository.findOne(username);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView retrieveHTML(@PathVariable("username") String username) {
        return new ModelAndView("user", "user", retrieve(username));
    }


    // UPDATE
    @RequestMapping(value = "/{username}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User update(@PathVariable("username") String username, @Valid @RequestBody User user) {
        User oldUser = userRepository.findOne(username);
        oldUser.setName(user.getName());
        oldUser.setBirthdate(user.getBirthdate());
        oldUser.setEmail(user.getEmail());
        oldUser.setJoin_date(user.getJoin_date());
        oldUser.setSurname(user.getSurname());
        oldUser.setDismiss_date(user.getDismiss_date());
        return userRepository.save(oldUser);
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseStatus(HttpStatus.OK)
    public String updateHTML(@PathVariable("username") String username, @Valid @ModelAttribute("user") User user,
                             BindingResult binding) {
        if (binding.hasErrors()) {
            return "userForm";
        }
        return "redirect:/users/" + update(username, user).getUsername();
    }

    // Update form
    @RequestMapping(value = "/{username}/form", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView updateForm(@PathVariable("username") String username) {
        return new ModelAndView("userForm", "user", userRepository.findOne(username));
    }

}

