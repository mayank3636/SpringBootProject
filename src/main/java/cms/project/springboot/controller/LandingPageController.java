package cms.project.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cms.project.springboot.dao.CMSDao;
import cms.project.springboot.dao.CommentDao;
import cms.project.springboot.model.AjaxForm;
import cms.project.springboot.model.Post;
import cms.project.springboot.service.AdminPostService;
import cms.project.springboot.service.CommentPostService;

@Controller
public class LandingPageController {
@Autowired
AdminPostService service;
@Autowired
CommentPostService commentService;
@Autowired
CMSDao dao;
@Autowired
CommentDao commentdao;
	@RequestMapping(value="/landingpage")
	public String LandingPage(Model map){
		
        map.addAttribute("posts", dao.findAll());
		
		return "landingpage";	
}
	
	@RequestMapping(value = "/landingpagepostcomment", method = RequestMethod.POST)
	@ResponseBody	
	public void process(@RequestBody AjaxForm payload) 
		{

		System.out.println(payload);

		commentService.commentAdd(payload);
		}
	
@GetMapping("/adminlandingpage")
	public String AdminLandingPage(Post post){
	
	return "adminlandingpage";
}
@PostMapping("/adminlandingpage")
public String checkPersonInfo(@Valid Post post, BindingResult bindingResult,@RequestParam("file") MultipartFile[] files) {
System.out.println(post.getStatusText());
    if (bindingResult.hasErrors()) {
        return "adminlandingpage";
    }else{
    	boolean x=service.savePost(post, files);
    	if(x)	
    	return "redirect:/landingpage";
    }
   return "redirect:/error";
    
}

}