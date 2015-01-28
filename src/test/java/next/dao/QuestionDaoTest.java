package next.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import next.dao.qna.QuestionDao;
import next.model.qna.Question;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class QuestionDaoTest {
	@Autowired
	private QuestionDao dut;

	@Test
	public void crud() throws Exception {
		Question expected = new Question("자바지기", "title", "contents");
		dut.insert(expected);

		List<Question> questions = dut.findAll();
		assertTrue(questions.size() > 0);
	}
	
	@Test
	public void updateCommentCount() throws Exception {
		Question expected = new Question("자바지기", "title", "contents");
		dut.insert(expected);
		
		dut.increaseCommentCount(3);
		Question question = dut.findById(3);
		assertThat(question.getCountOfComment(), is(1));
		
		dut.decreaseCommentCount(3);
		question = dut.findById(3);
		assertThat(question.getCountOfComment(), is(0));
	}
}
