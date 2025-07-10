package n3.jenkins;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {



    @ResponseBody
    @GetMapping()
    public String home(){
        return "Hi 신동욱";
    }
    
}
