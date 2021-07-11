package com.liguebasketball.basketballsousse.Controller;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.liguebasketball.basketballsousse.dao.EquipeRepository;
import com.liguebasketball.basketballsousse.domaine.Message;
import com.liguebasketball.basketballsousse.entities.Equipe;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.json.JsonParseException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


@CrossOrigin(origins = "*")
@EnableAutoConfiguration
@RestController
@RequestMapping("/api")
public class EquipeController {
    @Autowired
    EquipeRepository repository;
   // @Autowired 	ScategorieRepository  scatrepository;
    @Autowired  ServletContext context;

    @GetMapping("/equipes")
    public List<Equipe> getAllEquipes() {
        System.out.println("Get all equipes...");

        List<Equipe> equipes = new ArrayList<>();
        repository.findAll().forEach(equipes::add);

        return equipes;
    }

    @GetMapping ("/getAll")
    public ResponseEntity<List<String>> getAll()
    {
        List<String> listArt = new ArrayList<String>();
        String filesPath = context.getRealPath("/Images");
        File filefolder = new File(filesPath);
        if (filefolder != null)
        {
            for (File file :filefolder.listFiles())
            {
                if(!file.isDirectory())
                {
                    String encodeBase64 = null;
                    try {
                        String extension = FilenameUtils.getExtension(file.getName());
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] bytes = new byte[(int)file.length()];
                        fileInputStream.read(bytes);
                        encodeBase64 = Base64.getEncoder().encodeToString(bytes);
                        listArt.add("data:image/"+extension+";base64,"+encodeBase64);
                        fileInputStream.close();


                    }catch (Exception e){

                    }
                }
            }
        }
        return new ResponseEntity<List<String>>(listArt,HttpStatus.OK);
    }
//    @PostMapping(value = "/saveUser")
//    public ResponseEntity<Message> saveUser (@RequestParam("file") MultipartFile file,
//                                             @RequestParam("user") String user) throws JsonParseException , JsonMappingException , Exception
//    {
//        Article article = new ObjectMapper().readValue(user, Article.class);
//
//        article.setFileName(file.getOriginalFilename());
//        Article art = repository.save(article);
//
//        if (art != null)
//        {
//            Optional<Scategorie> ScategorieInfo = scatrepository.findByCode(article.getCscateg());
//
//            if (ScategorieInfo.isPresent()) {
//                Scategorie scategorie = ScategorieInfo.get();
//                scategorie.setRang(scategorie.getRang()+1);
//                scategorie  = scatrepository.save(scategorie);
//            }
//            return new ResponseEntity<Message>(new Message (""),HttpStatus.OK);
//        }
//        else
//        {
//            return new ResponseEntity<Message>(new Message ("Article not saved"),HttpStatus.BAD_REQUEST);
//        }
//    }
//


    @PostMapping("/equipes")
    public ResponseEntity<Message> createEquipe (@RequestParam("file") MultipartFile file,
                                                 @RequestParam("equipe") String equipe) throws JsonParseException , JsonMappingException , Exception
    {
        System.out.println("Ok .............");
       Equipe equi = new ObjectMapper().readValue(equipe, Equipe.class);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath( "/Images/")).mkdir();
            System.out.println("mk dir.............");
        }
        String filename= file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }


        equi.setLogo(newFileName);
        Equipe eqp = repository.save(equi);
        if (eqp != null)
        {

            return new ResponseEntity<Message>(new Message (""),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Message>(new Message ("Equipe not saved"),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/equipes/{id}")
    public ResponseEntity<Equipe> getArticleById(@PathVariable(value = "id") Long Id)
            throws ResourceNotFoundException {
        Equipe Equipe = repository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipe not found for this id :: " + Id));
        return ResponseEntity.ok().body(Equipe);
    }

    @GetMapping(path="/ImgEquipes/{id}")
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Equipe Equipe   = repository.findById(id).get();
        return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+Equipe.getLogo()));
    }




    @DeleteMapping("/equipes/{id}")
    public Map<String, Boolean> deleteEquipe(@PathVariable(value = "id") Long EquipeId)
            throws ResourceNotFoundException {
        Equipe Equipe = repository.findById(EquipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found  id :: " + EquipeId));
        repository.delete(Equipe);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("/equipes/delete")
    public ResponseEntity<String> deleteAllEquipes() {
        System.out.println("Delete All equipes...");
        repository.deleteAll();
        return new ResponseEntity<>("All equipes have been deleted!", HttpStatus.OK);
    }

    @PutMapping("/equipes/{id}")
    public ResponseEntity<Equipe> updateEquipe(@PathVariable("id") long id, @RequestBody Equipe Equipe) {
        System.out.println("Update Equipe with ID = " + id + "...");
        Optional<Equipe> EquipeInfo = repository.findById(id);
        if (EquipeInfo.isPresent()) {
            Equipe equipe = EquipeInfo.get();
            equipe.setNom(Equipe.getNom());
            equipe.setNbPointMarquer(Equipe.getNbPointMarquer());
            equipe.setNbPointEncaisses(Equipe.getNbPointEncaisses());
            equipe.setNbMatchJouerExterieur(Equipe.getNbMatchJouerExterieur());
            equipe.setNbMatchJouerDomicile(Equipe.getNbMatchJouerDomicile());
            equipe.setPlayer(Equipe.getPlayer());
            return new ResponseEntity<>(repository.save(Equipe), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

