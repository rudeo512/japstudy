package me.caru.jpastudy.post;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import me.caru.jpastudy.IntegrationTest;

/**
 * PostControllerTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 23.
 */

public class PostControllerTest extends IntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PostRepository postRepository;

	@Test
	public void getPost() throws Exception {
		Post post = new Post("springboot");
		Post result = postRepository.save(post);

		mockMvc.perform(get("/posts/" + result.getId()))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string("springboot"));
	}

	@Test
	public void getAllPost() throws Exception {

		mockMvc.perform(get("/posts"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("1")));
	}
}