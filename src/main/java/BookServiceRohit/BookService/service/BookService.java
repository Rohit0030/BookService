package BookServiceRohit.BookService.service;

import BookServiceRohit.BookService.model.MemberModel;
import BookServiceRohit.BookService.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService
{


@Autowired
public BookRepository repository;

    //Post
    public MemberModel add(MemberModel account)
    {
        return repository.save(account);
    }

    //Get
        public List<MemberModel> getAllMember()
        {
        return repository.findAll();
        }

        //get member by id
        public Optional<MemberModel> findById(long id)
        {

            return repository.findById(id);
        }

     // put = update


    public String updateMember(long id,  String name)
    {
        MemberModel member= repository.getReferenceById(id);
        member.setName(name);
        repository.save(member);
        return "Successfully update name as: "+name;
    }
    // delete
    public String deleteMember(long id)
    {
       try {
           repository.deleteById(id);
           return "successfully deleted id: "+id;

            }catch (Exception e)
       {
           ResponseEntity.status(HttpStatus.NOT_FOUND);
           e.printStackTrace();
       }
            return "*****************  already deleted or not Found  *************** ";
    }
    // delete all
    public void deleteAll()
    {
        repository.deleteAll();
    }

}



