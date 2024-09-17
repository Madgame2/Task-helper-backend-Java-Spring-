package USER_MODULE.Controllers;

import USER_MODULE.Service.User_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.Authentication;


@Controller
public class MainController {


    @Autowired
    private User_service userService;

    @GetMapping("/home")
    public String Welcome_page(Model model,Authentication authentication){
        if(authentication!=null&& authentication.isAuthenticated()){
            return "redirect:/project_list";
        }

        return "index";
    }

    @GetMapping("/project_list")
    public String project_list(Model model){
        return "project_list";
    }

    @PostMapping("/home/add")
    public String add_user(@RequestParam String email,@RequestParam String password, Model model){

        userService.registerUser(email,password);

        return "index";
    }


    @GetMapping("/home/sign_in")
    public String sign_in(Model model,Authentication authentication){

        if(authentication!=null&& authentication.isAuthenticated()){
            return "redirect:/project_list";
        }

        model.addAttribute("in",true);
        model.addAttribute("up",false);

        model.addAttribute("first","sign_in");
        model.addAttribute("second","sign_up");
        return "authorizaton";
    }
    @GetMapping("/home/sign_up")
    public String sign_up(Model model,Authentication authentication){

        if(authentication!=null&& authentication.isAuthenticated()){
            return "redirect:/project_list";
        }


        model.addAttribute("in",false);
        model.addAttribute("up",true);

        model.addAttribute("first","sign_up");
        model.addAttribute("second","sign_in");
        return "authorizaton";
    }
}
