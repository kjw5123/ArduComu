package JW.ArduComu.controller;

import JW.ArduComu.domain.ArduinoData;
import JW.ArduComu.service.ArduinoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
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
    @PostMapping("/abcd")
    public ResponseEntity<String> postTest(){
        System.out.println("hi");
        return ResponseEntity.ok("Post Requested.");
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
    @GetMapping("/time")
    public ResponseEntity<Map<String, LocalDateTime>> getCurrentTime(){
        LocalDateTime currentTime = LocalDateTime.now();
        Map<String, LocalDateTime> timeJson = new HashMap<>();
        timeJson.put("Server Time", currentTime);
        return ResponseEntity.ok(timeJson);
    }
    public static void main(String[] args) {
        SpringApplication.run(PageController.class, args);
    }

}