package pl.sdacademy.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/mvc/msg")
public class MsgController {

	private MsgRepository msgRepository;

	@Autowired
	public MsgController(MsgRepository msgRepository) {
		this.msgRepository = msgRepository;
		// add some default msgs
		msgRepository.save(new Msg("hello", 1));
		msgRepository.save(new Msg("hi", 10));
		msgRepository.save(new Msg("wazzup", 20));
	}

	@ModelAttribute("allMsgs")
	public Collection<Msg> allMsgs() {
		return msgRepository.findAll();
	}

	@PostMapping
	public String saveMsg(Msg msg) {
		msgRepository.save(msg);
		return "redirect:/mvc/msg";
	}

	@GetMapping
	public String getMsgForm() {
		return "msg-form";
	}
}
