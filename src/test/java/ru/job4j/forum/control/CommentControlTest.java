package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.CommentService;
import ru.job4j.forum.service.PostService;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class CommentControlTest {
    @MockBean
    private CommentService commentService;
    @MockBean
    private PostService posts;
    @Autowired
    private MockMvc mockMvc;

//    @Test
//    @WithMockUser
//    public void CommentServiceMethodPost() throws Exception {
//        Post post = Post.of("Куплю ладу-грант. Дорого.", "бюджет 100к");
//        post.setId(1);
//        Mockito.when(posts.findPostById(Mockito.anyInt())).thenReturn(Optional.of(post).get());
//        this.mockMvc.perform(post("/postComment?idPost=1")
//                .param("message","koment"))
//                .andDo(print())
//                .andExpect(status().is3xxRedirection());
//        ArgumentCaptor<Comment> argument = ArgumentCaptor.forClass(Comment.class);
//        verify(commentService).postComment(argument.capture(), 1);
//        assertThat(argument.getValue().getMessage(), is("koment"));
//    }
}