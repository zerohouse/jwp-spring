package next.web.user;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import next.model.user.User;
import next.service.user.PasswordMismatchException;
import next.service.user.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping("/form")
	public String joinForm(Model model) throws Exception {
		model.addAttribute("user", new User());
		return "user/form";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String join(@Valid User user, BindingResult bindingResult) throws Exception {
		log.debug("user : {}", user);
		if (bindingResult.hasFieldErrors()) {
			return "user/form";
		}
		
		userService.join(user);
		return "redirect:/";
	}

	@RequestMapping("/login/form")
	public String loginForm() throws Exception {
		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String userId, String password, HttpSession session) throws Exception {
		try {
			User user = userService.login(userId, password);
			session.setAttribute("loginUser", user);
			return "redirect:/";
		} catch (PasswordMismatchException e) {
			return "user/login";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.removeAttribute("loginUser");
		return "redirect:/";
	}
}
