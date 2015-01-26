package next.service;

import next.ResourceNotFoundException;
import next.dao.MockAnswerDao;
import next.dao.MockQuestionDao;

import org.junit.Before;
import org.junit.Test;

public class QnaServiceTest {
	private MockQuestionDao questionDao;
	private MockAnswerDao answerDao;

	private QnaService qnaService;

	@Before
	public void setup() {
		questionDao = new MockQuestionDao();
		answerDao = new MockAnswerDao();
		qnaService = new QnaService(questionDao, answerDao);
	}

	@Test(expected = ResourceNotFoundException.class)
	public void delete_질문_존재하지_않는_경우() throws Exception {
		qnaService.delete(1L);
	}

}
