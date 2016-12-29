package pl.rpolak.patternwebapp.book.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/book")
public class BookApi {
    
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Long> list (){
        List<Long> test = new ArrayList<>();
        test.add(0L);
        
        return test;
    }
    
}
