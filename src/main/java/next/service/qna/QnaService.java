package next.service.qna;

import java.util.List;

import javax.annotation.Resource;

import next.dao.qna.AnswerDao;
import next.dao.qna.QuestionDao;
import next.model.qna.Answer;
import next.model.qna.Question;

import org.springframework.stereotype.Service;

@Service
public class QnaService {
	@Resource(name = "questionDao")
	private QuestionDao questionDao;
	
	@Resource(name = "answerDao")
	private AnswerDao answerDao;

	public Question findById(long questionId) {
		Question question = questionDao.findById(questionId);
		List<Answer> answers = answerDao.findAllByQuestionId(questionId);
		return question.withAnswers(answers);
	}

	public List<Question> findAll() {
		return questionDao.findAll();
	}

	public void save(Question question) {
		questionDao.insert(question);
	}

	public void addAnswer(long questionId, Answer answer) {
		answer.setQuestionId(questionId);
		answerDao.insert(answer);
		questionDao.updateCommentCount(questionId);
	}
}
