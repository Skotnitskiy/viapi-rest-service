package viapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import viapi.dto.SerialDTO;
import viapi.service.SerialsService;

import java.util.List;

@RestController
public class SerialsController {
    @Autowired
    SerialsService serialsService;

    @RequestMapping("/serials")
    public List<SerialDTO> serials(@RequestParam(value = "name", defaultValue = "World") String name) {
        return serialsService.getSeials();
    }
}
