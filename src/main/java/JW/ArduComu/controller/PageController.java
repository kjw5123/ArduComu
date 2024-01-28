package JW.ArduComu.controller;

import JW.ArduComu.domain.ArduinoData;
import JW.ArduComu.service.ArduinoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/data")
public class PageController {

    private final ArduinoDataService arduinoDataService;
    @Autowired
    public PageController(ArduinoDataService arduinoDataService) {
        this.arduinoDataService = arduinoDataService;
    }
    @PostMapping("/insert")
    public ResponseEntity<ArduinoData> postData(@RequestBody ArduinoData arduinoData) { //아두이노 데이터 들어온다. body 받게금 RequestBody 사용
        arduinoDataService.InsertData(arduinoData);
//        System.out.println("posted it." + arduinoDataService.allArduinoDataHistories()); 입력 테스트용 코드임
        return ResponseEntity.ok(arduinoData);
    }

    @GetMapping("/now") //현재 대기 상황
    public String getNowData(Model model){
        ArduinoData arduinoData;
        arduinoData = arduinoDataService.outData();
        model.addAttribute("nowData", arduinoData);
        return "data/now";
    }

    @GetMapping("/history/dust") // 미세먼지 기록 조회
    public String getDustData(Model model){
        Map<String, Double> arduinoData = arduinoDataService.getDustHistory();
        System.out.println("I did it.");
        model.addAttribute("nowData", arduinoData);
        return "data/history/dust_history";
    }
    @GetMapping("/history/humi") // 습도 기록 조회
    public String getHumiData(Model model){
        Map<String, Double> arduinoData = arduinoDataService.getHumiHistory();
        System.out.println("I did it.");
        model.addAttribute("nowData", arduinoData);
        return "data/history/humi_history";
    }

    @GetMapping("/history/temp") // 기온 기록 조회
    public String getTempData(Model model){
        Map<String, Double> arduinoData = arduinoDataService.getTempHistory();
        System.out.println("I did it.");
        model.addAttribute("nowData", arduinoData);
        return "data/history/temp_history";
    }
    @GetMapping("/history/all") // 모든 기록 조회
    public String getAllData(Model model){
        List<List<Object>> arduinoData = arduinoDataService.allArduinoDataHistories();
        System.out.println("I did it.");
        model.addAttribute("nowData", arduinoData);
        return "data/history/all_history";
    }


    public static void main(String[] args) {
        SpringApplication.run(PageController.class, args);
    }
}
