package com.fresco.codelab.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fresco.codelab.model.CodeLabRepo;
import com.fresco.codelab.model.CodeLabRepoVersion;
import com.fresco.codelab.model.CodeLabUser;
import com.fresco.codelab.repo.CodeLabUserRepository;
import com.fresco.codelab.service.DashboardService;
import com.fresco.codelab.service.RegisterService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	public DashboardService dashBoardService ;
	
	public String repo_name;
	
	
	@Autowired	
	public CodeLabUserRepository userRepo;
	
	@PostMapping("/createnewrepo")
	public String register(@RequestParam String repo_name) {
		this.repo_name = repo_name;
		List<CodeLabUser> users = userRepo.findAll();
		dashBoardService.saveRepo(repo_name,users.get(0).getUserAutoGenId());
		return "redirect:/dashboard/";
	}
	
	
	
	
	@GetMapping("")
	public ModelAndView dashboard() {
		List<CodeLabUser> users = userRepo.findAll();		
		ModelAndView mv = new ModelAndView();
		List<CodeLabRepo> codeLabRepos = dashBoardService.getUserOwnedRepos(users.get(0).getUserAutoGenId());
		List<CodeLabRepo> myRepo = dashBoardService.getUserOwnedRepos(users.get(0).getUserAutoGenId());
		mv.addObject("myrepos",  codeLabRepos);
		mv.addObject("allrepos", myRepo);
		mv.setViewName("homepage.jsp");
		return mv;
	}
	
	
	@GetMapping("/openrepo/{repoId}")
	public ModelAndView openRepo(@PathVariable Long repoId) {
		List<CodeLabUser> users = userRepo.findAll();
		Long userId = users.get(0).getUserAutoGenId();
		String username = users.get(0).getUsername();
		ModelAndView mv = new ModelAndView();		
		CodeLabRepo repo = dashBoardService.getRepoWithRepoIdAndOwnerId(repoId, userId);
		Optional<CodeLabUser> codeLabUser = userRepo.findById(repo.getRepoOwnerId());
		CodeLabUser codeUser = codeLabUser.get();
		if(repo == null) {
			return dashboard();
		}	
		mv.addObject("repo", repo);
		mv.addObject("repoOwner", codeUser);		
		mv.setViewName("repodashboardpage.jsp");
		return mv;
	}
	
	
	@PostMapping("/uploadcode/{repoId}") 
    public String singleFileUpload(@PathVariable Long repoId, @RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
		
		
		List<CodeLabUser> users = userRepo.findAll();
		Long userId = users.get(0).getUserAutoGenId();
		
		CodeLabRepo codeLabRepo = dashBoardService.getRepoWithRepoIdAndOwnerId(repoId, userId) ;
		
		if(dashBoardService.getRepoWithRepoIdAndOwnerId(repoId, userId) == null) {
			return "redirect:/dashboard";
		}		
		
		List<Integer> versions = codeLabRepo.getVersions().parallelStream().map(CodeLabRepoVersion::getVersion)
				.collect(Collectors.toList());
		int latestVersion = versions.size() == 0 ? 1 : Collections.max(versions) + 1;
		
		
		Path path = Paths.get("C:\\Users\\Home\\Documents\\workspace-sts-3.9.6.RELEASE\\CodeLab\\uploads\\" + repoId + "-" + latestVersion);
		try {
			Files.write(path, file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dashBoardService.unzipFiles(path.toString());
		
		//new File(path.toString()).delete();
		
		dashBoardService.uploadCode(userId, repoId);
		
		
        return "redirect:/dashboard/openrepo/" + repoId;
    }

	
	@GetMapping("/openrepo/{repoId}/version/{version}")
	public ModelAndView openRepoVersion(@PathVariable Long repoId, @PathVariable Integer version) {
	
		List<CodeLabUser> users = userRepo.findAll();
		Long userId = users.get(0).getUserAutoGenId();
		
		CodeLabRepo repo = dashBoardService.getRepoWithRepoIdAndOwnerId(repoId, userId);
		if(repo == null) {
			return dashboard();
		}
		
		
		
		//dashboardService.getFiles("uploads/" + repoId + "-" + version + "code");
		ModelAndView mv = new ModelAndView();
		mv.addObject("repo", repo);
		mv.addObject("version", version);
		mv.addObject("repoCode", dashBoardService.getFiles("C:\\Users\\Home\\Documents\\workspace-sts-3.9.6.RELEASE\\CodeLab\\uploads\\" + repoId + "-" + version + "code"));
		mv.setViewName("repocodepage.jsp");
		return mv;
	}
	
	@PostMapping("/savecode/{repoId}/{version}")
	public String saveCode(@PathVariable Long repoId, @PathVariable Integer version, String filename, String code) {
		List<CodeLabUser> users = userRepo.findAll();
		Long userId = users.get(0).getUserAutoGenId();
		CodeLabRepo repo = dashBoardService.getRepoWithRepoIdAndOwnerId(repoId, userId);
		if(repo == null)
			return "redirect:/dashboard";
	
		dashBoardService.saveCode(repoId, version, filename, code);
		//dashBoardService.uploadCode(userId, repoId);
		return "redirect:/dashboard/openrepo/" + repoId + "/version/" + version;
	}
	
	@PostMapping("/adddeveloper/{repoId}")
	public String addDeveloper(@PathVariable Long repoId, String developer) {
		List<CodeLabUser> users = userRepo.findAll();
		Long userId = users.get(0).getUserAutoGenId();
		CodeLabRepo repo = dashBoardService.getRepoWithRepoIdAndOwnerId(repoId, userId);
		if(repo == null)
			return "redirect:/dashboard";
		dashBoardService.addRepoToUserName(repo, developer, userId);
		return "redirect:/dashboard/openrepo/"+repoId;
	}
	
}
