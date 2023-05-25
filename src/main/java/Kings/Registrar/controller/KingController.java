package Kings.Registrar.controller;

import Kings.Registrar.entity.King;
import Kings.Registrar.service.KingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kings")
public class KingController {

    @Autowired
    private KingService kingService;

    @GetMapping
    public List<King> getAllKings() {
        return kingService.getAllKings();
    }

    @PostMapping
    public King addKing(@RequestBody King king) {
        return kingService.addKing(king);
    }
}
