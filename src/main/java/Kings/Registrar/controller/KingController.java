package Kings.Registrar.controller;

import Kings.Registrar.entity.King;
import Kings.Registrar.service.KingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("api/kings")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class KingController {

    @Autowired
    private KingService kingService;

    @GetMapping
    public List<King> getAllKings() {
        return kingService.getAllKings();
    }

    @PostMapping()
    public King addKing(@RequestBody King king) {
        return kingService.addKing(king);
    }

    @GetMapping("/")
    public ModelAndView getKings(Model model) {
        ModelAndView modelAndView = new ModelAndView("index.html");
        modelAndView.addObject("todoItems", kingService.getAllKings());

        return modelAndView;
    }


}
