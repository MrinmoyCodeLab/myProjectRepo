package com.fresco.codelab.service;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fresco.codelab.model.CodeLabRepo;
import com.fresco.codelab.model.CodeLabRepoVersion;
import com.fresco.codelab.model.CodeLabUser;
import com.fresco.codelab.repo.CodeLabRepoRepository;
import com.fresco.codelab.repo.CodeLabRepoVersionRepository;
import com.fresco.codelab.repo.CodeLabUserRepository;
import java.util.Map.Entry;
import org.springframework.util.StringUtils;
import static java.util.stream.Collectors.toMap;
@Service
public class DashboardService {
	
	
	@Autowired
	CodeLabUserRepository codeLabUserRepository;
	@Autowired
	CodeLabRepoRepository  codeLabRepoRepository ;
	@Autowired 
	CodeLabRepoVersionRepository codeLabRepoVersionRepository ;
	/*@Autowired 
	CodeLabUser codeLabUser;	
	@Autowired 
	CodeLabRepo codeLabRepo;
	@Autowired 
	CodeLabRepoVersion codeLabRepoVersion ;*/
	
	
	public Long saveRepo(String repo_name, Long userId) {	
		
		CodeLabRepo codeLabRepo = new CodeLabRepo();
		codeLabRepo.setRepoName(repo_name);
		codeLabRepo.setRepoOwnerId(userId);
		//codeLabRepo
		CodeLabRepo createdRepo = codeLabRepoRepository.save(codeLabRepo);		
		return createdRepo.getRepoAutoGenId();
	}
	
	@SuppressWarnings("unchecked")
	public List<CodeLabRepo> getUserOwnedRepos(Long userId) {
		
		List<CodeLabRepo> codeLabRepos = codeLabRepoRepository.findAll();
		List<CodeLabRepo> codeLabReposList = new ArrayList<CodeLabRepo>();
		if( codeLabRepos!= null) {
			for(CodeLabRepo codeLabRepo : codeLabRepos ) {
				if(codeLabRepo.getRepoOwnerId() == userId ) {
					codeLabReposList.add(codeLabRepo);
					return codeLabReposList;
				}
			}
		}
		
			
		return null;
	}

	public CodeLabRepo getRepoWithRepoIdAndOwnerId(Long repoId, Long userId) {		
		List<CodeLabRepo> codeLabRepos = codeLabRepoRepository.findAll();		
		if( codeLabRepos!= null) {
			for(CodeLabRepo codeLabRepo : codeLabRepos ) {
				if(codeLabRepo.getRepoAutoGenId() == repoId && codeLabRepo.getRepoOwnerId() == userId ) {
					return codeLabRepo;
				}
			}
		}	
		return null;
	}
	
	public void addRepoToUserName(CodeLabRepo repo, String username, Long ownerId) {
		
		CodeLabUser codeLabUser =  new CodeLabUser(); 
		CodeLabRepo codeLabRepoData = new CodeLabRepo();
		Set<CodeLabRepo> repos = new HashSet<CodeLabRepo>();
		
		List<CodeLabUser> allCodeLabUser = codeLabUserRepository.findAll();	
		
		if(repo.getRepoOwnerId() == ownerId) {
			repos.add(repo);
		}
		if(allCodeLabUser != null) {
			for(CodeLabUser codeLabUsers: allCodeLabUser ) {
				if(codeLabUsers.getUsername().equalsIgnoreCase(username)) {
					codeLabUsers.setRepos(repos);
					codeLabUserRepository.save(codeLabUsers);
					break;
				}
			}
		}
	
		List<CodeLabRepo> codeLabRepos = codeLabRepoRepository.findAll();	
		/*codeLabUser.setUsername(username);
		codeLabUserRepository.save(codeLabUser);
		codeLabRepoRepository.save(repo);*/
	
	}
	
	public Set<CodeLabRepo> getUserDeveloperRepos(Long userId) {		
		Optional<CodeLabUser> codeLabUser = codeLabUserRepository.findById(userId);
		if(codeLabUser.isPresent()) {
			 return codeLabUser.get().getRepos();
		}	
		return null;
	}

	public CodeLabRepo getRepoWithRepoIdAndDeveloperId(Long repoId, Long userId) {		
		
		List<CodeLabUser> CodeLabUserList = codeLabUserRepository.findAll();
		if( CodeLabUserList!= null) {
			for(CodeLabUser codeLabUser : CodeLabUserList ) {
				if(codeLabUser.getUserAutoGenId() == userId) {
					Set<CodeLabRepo> repoSet = codeLabUser.getRepos();
					if(repoSet != null) {
						for(CodeLabRepo repo : repoSet) {
							if(repo.getRepoAutoGenId() == repoId ) {
								return repo;
							
							}
						}
					}
					
					
				}
			}
		}	
		
		return null;
	}

	public Integer uploadCode(Long userId, Long repoId) {	
		
		//List<CodeLabRepoVersion> codeLabRepoVersions = new ArrayList<CodeLabRepoVersion>();
		CodeLabRepoVersion codeLabRepoVersion1 = new CodeLabRepoVersion();
		
		
		CodeLabRepoVersion codeLabRepoVersion = new CodeLabRepoVersion();
		codeLabRepoVersion.setVersionOwnerId(userId);
		codeLabRepoVersion.setVersion(userId.intValue());
		
		codeLabRepoVersion.setIsMrPending(true);
		
		List<CodeLabUser> CodeLabUserList = codeLabUserRepository.findAll();	
		
		if( CodeLabUserList!= null) {
			for(CodeLabUser codeLabUser : CodeLabUserList ) {
				if(codeLabUser.getUserAutoGenId() == userId) {
					Set<CodeLabRepo> repoSet = codeLabUser.getRepos();
					codeLabRepoVersion.setIsMaster(true);
					if(repoSet != null && repoSet.size() > 0) {
						for(CodeLabRepo repo : repoSet) {
							if(repo.getRepoAutoGenId() == repoId ) {
								codeLabRepoVersion.setRepo(repo);
							
							}
						}
					}else {
						
						List<CodeLabRepo> repo = codeLabRepoRepository.findAll();
						
						codeLabRepoVersion.setRepo(repo.get(0));
					}
					
					
				}
			}
		}	
		
		try {
			codeLabRepoVersion1 = codeLabRepoVersionRepository.save(codeLabRepoVersion);
		} catch (Exception e) {
			e.printStackTrace();
		}				
		return codeLabRepoVersion1.getId();
	}
	
	public CodeLabRepo getRepoWithRepoIdAndUserIdAndVersionId(Long repoId, Long userId, Integer version) {
				
		List<CodeLabRepo>  codeLabRepoList = codeLabRepoRepository.findAll() ;		
		
		List<CodeLabUser> CodeLabUserList = codeLabUserRepository.findAll();
		if( CodeLabUserList!= null) {
			for(CodeLabUser codeLabUser : CodeLabUserList ) {
				if(codeLabUser.getUserAutoGenId() == userId) {
					Set<CodeLabRepo> repoSet = codeLabUser.getRepos();
					if(repoSet != null) {
						for(CodeLabRepo repo : repoSet) {
							if(repo.getRepoAutoGenId() == repoId) {
								return repo;
								
							
							}
						}
					}
					
					
				}
			}
		}	
		
	
		return null;
	}

	public List<CodeLabUser> getAllUsersExcept(Long userId) {
		
		List<CodeLabUser> allCodeLabUser = codeLabUserRepository.findAll();	
		
		Predicate<CodeLabUser> filterData = new Predicate<CodeLabUser>() {			
			@Override
			public boolean test(CodeLabUser t) {
				if(t.getUserAutoGenId() != userId) {
					return true;
				}
				return false;
			}
		};
		List<CodeLabUser> allCodeLabUser1 = allCodeLabUser.stream().filter(filterData).collect(Collectors.toList());		
		return allCodeLabUser1 ;
	}
	
	
	/*public static void main(String[] args) {
		
		List<CodeLabUser> allCodeLabUser = Arrays.asList(		
		new CodeLabUser(1l,"A","abc","abc"),
		new CodeLabUser(2l,"B","bcd","bcd")
		);
		
		Predicate<CodeLabUser> filterData = c -> {
			if(c.getUserAutoGenId() != 1l) {
				return true ;
			} 
			return false;
			};
		
		//allCodeLabUser.removeIf(filterData);
		
		List<CodeLabUser> allCodeLabUser1 = allCodeLabUser.stream().filter(filterData).collect(Collectors.toList());
		
		System.out.println(allCodeLabUser1);
		
	}
	*/
	
	
	public void saveFiles(File file) {		
		StringBuilder sb = new StringBuilder();
		sb.append("content of text file");	
		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file));
			ZipEntry e = new ZipEntry("mytext.txt");
			out.putNextEntry(e);
			byte[] data = sb.toString().getBytes();
			out.write(data, 0, data.length);
			out.closeEntry();
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
	
	private void extractFile(ZipInputStream zipIn, String filePath){
		try {
			String path = "";
			String[] arr = filePath.split("/");
			for(int i=0; i < arr.length - 1; i++)
				path += arr[i] + "/";
			File f = new File(path);
			if(!f.exists())
				f.mkdirs();
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
			byte[] bytesIn = new byte[4096];
			int read = 0;
			while ((read = zipIn.read(bytesIn)) != -1) {
				bos.write(bytesIn, 0, read);
			}
			bos.close();
		}catch(Exception e) {e.printStackTrace();}
	}

	public void unzipFiles(String zipFilePath){
		try {
			String destDirectory = zipFilePath + "code";
			File destDir = new File(destDirectory);
			if (destDir.exists())
				Files.walk(Paths.get(destDirectory)).filter(Files::isRegularFile).map(Path::toFile).forEach(File::delete);
			destDir.mkdir();
			
			ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
			ZipEntry entry = zipIn.getNextEntry();
			while (entry != null) {
				String filePath = destDirectory + File.separator + entry.getName();
				if (!entry.isDirectory()) {
					extractFile(zipIn, filePath);
				} else {
					File dir = new File(filePath);
					dir.mkdir();
				}
				zipIn.closeEntry();
				entry = zipIn.getNextEntry();
			}
			zipIn.close();
		}catch(Exception e) {e.printStackTrace();}
	}

	public static void fetchFiles(File dir, Consumer<File> fileConsumer) {
		if (dir.isDirectory())
			for (File file1 : dir.listFiles())
				fetchFiles(file1, fileConsumer);
		else
			fileConsumer.accept(dir);
	}
	
	
	public  void saveFiles(byte[] file , String fileName ) {
		String destDir = "C:\\Users\\Home\\Documents\\workspace-sts-3.9.6.RELEASE\\CodeLab\\uploads\\";
        File dir = new File(destDir);        
        
        // create output directory if it doesn't exist
        if(!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[file.length];
        try {
        	
        	Path path = Paths.get(destDir + fileName);
			Files.write(path, file);   
			
            fis = new FileInputStream(path.toString());
            
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            
            while(ze != null){
                String fileName1 = ze.getName();
                
                String name = destDir + File.separator + fileName + File.separator + fileName1 ; 
                
                FileOutputStream newFile = new FileOutputStream(name);
            //    System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
               
                
                BufferedOutputStream fos = new BufferedOutputStream(newFile);
                int len = 0;
                while ( (len = zis.read(buffer)) != -1) {
                	fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {        	
        	File fir = new File(destDir + File.separator + fileName);   
        	try {
				fir.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            e.printStackTrace();
        }
        
    }
		
	
	public Map<String, List<String>> getFiles(String repoCodePath) {
		Map<String, List<String>> repoCode = new TreeMap<String, List<String>>();
		File file = new File(repoCodePath);
		fetchFiles(file, f -> {
			List<String> data = new ArrayList<String>();
			data.add(String.valueOf(f.length()));
			DataInputStream dis = null;
			byte[] datainBytes = null;
			try {
				dis = new DataInputStream(new FileInputStream(f));
				datainBytes = new byte[dis.available()];
				dis.readFully(datainBytes);
				dis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String content = new String(datainBytes, 0, datainBytes.length);
			data.add(content);
			
			String[] key = f.getAbsolutePath().split("C:\\\\Users\\\\Home\\\\Documents\\\\workspace-sts-3.9.6.RELEASE\\\\CodeLab\\\\uploads\\\\");
			
			String path =  key[1].replace("\\", "/");
			repoCode.put(path, data);
		}); 
		return repoCode.entrySet().stream().sorted((Entry<String, List<String>> e1,
						Entry<String, List<String>> e2) -> StringUtils.countOccurrencesOf(e1.getKey(), "/")
								- StringUtils.countOccurrencesOf(e2.getKey(), "/"))
				.collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
	}

	
	
	public void saveCode(Long repoId, Integer version, String filename, String code) {
		try (PrintWriter fileout = new PrintWriter("C:\\Users\\Home\\Documents\\workspace-sts-3.9.6.RELEASE\\CodeLab\\uploads\\" + filename)) {
			fileout.println(code);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
}
