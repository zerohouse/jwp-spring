package next.web.qna;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import next.model.qna.Question;
import next.service.qna.QnaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"", "/questions"})
public class QuestionController {
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	
	@Resource(name = "qnaService")
	private QnaService qnaService;

	@RequestMapping("")
	public String list(Model model) {
		model.addAttribute("questions", qnaService.findAll());
		return "list";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable long id, Model model) {
		model.addAttribute("question", qnaService.findById(id));
		return "show";
	}
	
	@RequestMapping("/form")
	public String form(Model model) {
		model.addAttribute("question", new Question());
		return "form";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String save(@Valid Question question, BindingResult bindingResult) {
		logger.debug("Question : {}", question);
		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				logger.debug("error : {}", error);
			}
			return "form";
		}
		qnaService.save(question);
		return "redirect:/";
	}
}
