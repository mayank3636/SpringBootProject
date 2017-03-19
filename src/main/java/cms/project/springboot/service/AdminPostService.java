package cms.project.springboot.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

<<<<<<< HEAD
import org.eclipse.core.resources.ResourcesPlugin;
=======
>>>>>>> 457256ae3529d4a9f03dcdcf1ee5cd4ca22e503a
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cms.project.springboot.dao.CMSDao;
import cms.project.springboot.model.Post;
@Service
public class AdminPostService {

	@Autowired
	CMSDao dao;
	public boolean savePost(Post post, MultipartFile[] files) {
		String message="";
		if(files!=null)
     	for (int i = 0; i < files.length; i++) {
 			MultipartFile file = files[i];
 			
 			String name = file.getOriginalFilename();
 			if(name.isEmpty()){
 				continue;
 			}
 				
 			try {
 				byte[] bytes = file.getBytes();
 
 				// Creating the directory to store file
 				String rootPath = "D:/";
 				File dir = new File(rootPath + File.separator + "tmpFiles");
 				if (!dir.exists())
 					dir.mkdirs();
 
 				// Create the file on server
 				File serverFile = new File(dir.getAbsolutePath()
 						+ File.separator + name);
 				File f= new File("src/main/resources/static/css"+"/"+name);
 					f.createNewFile();
 				System.out.println(f.getAbsoluteFile());
 			
 				BufferedOutputStream stream = new BufferedOutputStream(
 					new FileOutputStream(f));
 				//new FileOutputStream("D://tmpFiles//"+name));
 						stream.write(bytes);
 				
 				stream.close();
 
 
 				message = message + "You successfully uploaded file=" + name
 						+ "";
<<<<<<< HEAD
 				//ResourcesPlugin.getWorkspace().getRoot().getProjects();
=======
>>>>>>> 457256ae3529d4a9f03dcdcf1ee5cd4ca22e503a
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		}
     	try{
     		Post p =new Post();
     		if(files!=null){
     		if(files[1].getOriginalFilename().isEmpty()){
     			p.setImageName(null);
     		}else{
     			p.setImageName(files[1].getOriginalFilename());
     		}
     			
     		if(files[0].getOriginalFilename().isEmpty()||files==null){
     			p.setVideoName(null);
     		}else{
     			p.setVideoName(files[0].getOriginalFilename());
     		}
     		}else if(files==null){
     			p.setImageName(null);
     			p.setVideoName(null);
     		}
     		
     		p.setStatusText(post.getStatusText());
     		dao.save(p);
     		return true;
     	}catch(ArrayIndexOutOfBoundsException e){
     		
     	}
		return false;
	}

}
