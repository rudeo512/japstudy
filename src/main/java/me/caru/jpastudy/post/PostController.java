package me.caru.jpastudy.post;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * PostController
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 23.
 */

@RestController
@RequiredArgsConstructor
@Slf4j
public class PostController {
	final private PostRepository postRepository;

	@GetMapping("/posts/{id}")
	public String getPost(@PathVariable("id") Post post) {
		return post.getTitle();
	}

	@GetMapping("/posts")
	public Integer getAllPost() {
		List<Post> posts = postRepository.findAll();
		log.info("posts == {}", posts);
		return posts.size();
	}
}
