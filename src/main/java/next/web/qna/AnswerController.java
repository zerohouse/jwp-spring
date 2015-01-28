package next.web.qna;

import javax.annotation.Resource;

import next.model.qna.Answer;
import next.service.qna.QnaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import core.web.Result;

@Controller
@RequestMapping("/questions/{questionId}/answers")
public class AnswerController {
	private static final Logger logger = LoggerFactory.getLogger(AnswerController.class);
	
	@Resource(name = "qnaService")
	private QnaService qnaService;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public @ResponseBody Result save(Answer answer) {
		logger.debug("Answer : {}", answer);
		
		return Result.ok();
	}
}
