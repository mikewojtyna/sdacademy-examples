package pl.sdacademy.mvc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
public class MsgControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private MsgRepository msgRepository;

	@DisplayName("should show msg page with all messages when GET on /mvc/msg")
	@Test
	void test() throws Exception {
		// when
		mockMvc.perform(get("/mvc/msg"))

			// then
			// @formatter:off
		.andExpect(status().isOk())
		.andExpect(model().attribute("allMsgs", msgRepository.findAll()))
		.andExpect(view().name("msg-form"));
			// @formatter:on
	}
}
