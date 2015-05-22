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
        return "redirect:/users/" + create(user, response).getId();
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView createForm() {
        User emptyUser = new User();
        return new ModelAndView("userForm", "user", emptyUser);
    }


    // RETRIEVE
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User retrieve(@PathVariable("id") Long id) {
        logger.info("Retrieving user {}", id);
        Preconditions.checkNotNull(userRepository.findOne(id), "User with id %s not found", id);
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView retrieveHTML(@PathVariable("id") Long id) {
        return new ModelAndView("user", "user", retrieve(id));
    }


    // UPDATE
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User update(@PathVariable("id") Long id, @Valid @RequestBody User user) {
        User oldUser = userRepository.findOne(id);
        oldUser.setName(user.getName());
        oldUser.setBirthdate(user.getBirthdate());
        oldUser.setEmail(user.getEmail());
        oldUser.setJoin_date(user.getJoin_date());
        oldUser.setSurname(user.getSurname());
        return userRepository.save(oldUser);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded")
    @ResponseStatus(HttpStatus.OK)
    public String updateHTML(@PathVariable("id") Long id, @Valid @ModelAttribute("user") User user,
                             BindingResult binding) {
        if (binding.hasErrors()) {
            return "userForm";
        }
        return "redirect:/users/" + update(id, user).getId();
    }

    // Update form
    @RequestMapping(value = "/{id}/form", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView updateForm(@PathVariable("id") Long id) {
        return new ModelAndView("userForm", "user", userRepository.findOne(id));
    }

}

