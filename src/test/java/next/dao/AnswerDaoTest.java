package next.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import next.dao.qna.AnswerDao;
import next.model.qna.Answer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class AnswerDaoTest {
	@Autowired
	private AnswerDao dut;
	
	@Test
	public void crud() throws Exception {
		long questionId = 1L;
		Answer expected = new Answer("javajigi", "answer contents", questionId);
		dut.insert(expected);
		
		List<Answer> answers = dut.findAllByQuestionId(questionId);
		assertTrue(answers.size() > 0);
	}
}
