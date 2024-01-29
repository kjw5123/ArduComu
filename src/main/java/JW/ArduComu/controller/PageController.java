package JW.ArduComu.controller;

import JW.ArduComu.domain.ArduinoData;
import JW.ArduComu.service.ArduinoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class PageController {
    private final ArduinoDataService arduinoDataService;

    @Autowired
    public PageController(ArduinoDataService arduinoDataService) {
        this.arduinoDataService = arduinoDataService;
    }
    @PostMapping("/data")
    public ResponseEntity<ArduinoData> postData(@RequestBody ArduinoData arduinoData) {
        arduinoDataService.insertData(arduinoData);
        return ResponseEntity.ok(arduinoData);
    }

    @GetMapping("/data")
    public String getData(Model model){
        ArduinoData arduinoData;
        arduinoData = arduinoDataService.getRecentData();
        model.addAttribute("nowData", arduinoData);
        return "data/now";
    }

    @GetMapping("/datas/dust")
    public String getDustDatas(Model model){
        Map<Long, ArduinoData> arduinoData = arduinoDataService.getStoredData();
        System.out.println("Dust history: " + arduinoData);
        model.addAttribute("nowData", arduinoData);
        return "datas/dust-history";
    }

    @GetMapping("/datas/humi")
    public String getHumiDatas(Model model){
        Map<Long, ArduinoData> arduinoData = arduinoDataService.getStoredData();
        model.addAttribute("nowData", arduinoData);
        return "datas/humi-history";
    }

    @GetMapping("/datas/temp")
    public String getTempDatas(Model model){
        Map<Long, ArduinoData> arduinoData = arduinoDataService.getStoredData();
        model.addAttribute("nowData", arduinoData);
        return "datas/temp-history";
    }

    @GetMapping("/datas/all")
    public String getAllDatas(Model model){
        Map<Long, ArduinoData> arduinoData = arduinoDataService.getStoredData();
        model.addAttribute("nowData", arduinoData);
        return "datas/all-history";
    }

    public static void main(String[] args) {
        SpringApplication.run(PageController.class, args);
    }
}