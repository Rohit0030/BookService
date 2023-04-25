package BookServiceRohit.BookService.controller;

import BookServiceRohit.BookService.model.MemberModel;
import BookServiceRohit.BookService.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
public class BookController {

@Autowired
public BookService service;

    @PostMapping("/add")
    public ResponseEntity<MemberModel> add(@RequestBody MemberModel account)
    {
        MemberModel saveAccount = service.add(account);
        return new ResponseEntity<MemberModel>(saveAccount, HttpStatus.CREATED);

    }
    @GetMapping("/members")
    public ResponseEntity<List<MemberModel>> getMemberList()
    {
        List<MemberModel> list =service.getAllMember();
        if (list.size()== 0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }
    @GetMapping(path = {"/member/{id}"})
    public Optional<MemberModel> findOne(@PathVariable("id") long id)
    {
        return service.findById(id);
    }

    @PutMapping("/update_member/{id}/{name}")
    public String updateMember(@PathVariable long id ,@PathVariable String name)
    {

        return service.updateMember(id,name);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMember(@PathVariable long id)
    {
        return service.deleteMember(id);
    }

    @DeleteMapping(value = "/deleteall")
    public String deleteAll()
    {
        service.deleteAll();
        return "Successfully deleted all entries";
    }

}


