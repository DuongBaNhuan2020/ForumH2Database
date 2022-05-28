package com.dev2qa.forum.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ReplyMessageController {
	@Autowired
	private ReplyMessageService replyMessageService;
	@RequestMapping("/detailTopic")
	public ModelAndView detailTopic(@RequestParam long u_id, @RequestParam long top_id) {
		List<ReplyMessage> listReply = replyMessageService.listAll();
		List<ReplyMessage> listReplyShow = new ArrayList<ReplyMessage>();
		ModelAndView mav = new ModelAndView("forum_show_topic");
		for(ReplyMessage r:listReply) {
			if(r.getTopic().getId()==top_id) {
				listReplyShow.add(r);
			}
		}
		User author=listReplyShow.get(0).getUser();
		ReplyMessage firstReplyMessage=listReplyShow.get(0);
		mav.addObject("listReply", listReplyShow);
		mav.addObject("author", author);
		mav.addObject("firstReplyMessage", firstReplyMessage);
		return mav;
		
	}
}
