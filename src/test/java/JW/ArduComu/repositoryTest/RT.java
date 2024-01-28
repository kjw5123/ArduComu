package JW.ArduComu.repositoryTest;

import JW.ArduComu.domain.ArduinoData;
import JW.ArduComu.repository.ArduinoDataRepository;
import JW.ArduComu.repository.MemoryArduinoDataRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class RT {
//    ArduinoDataRepository repository = new MemoryArduinoDataRepository();
    ArduinoDataRepository repository = new MemoryArduinoDataRepository();
    @AfterEach
    public void afterEach() {
        repository.clearStored();
    }
    @Test
    public void save(){
        ArduinoData arduinoData = new ArduinoData();
        arduinoData.setTime("12:00:00");
        arduinoData.setTemp(1.0);
        arduinoData.setHumi(1.0);
        arduinoData.setDust(1.0);

        repository.save(arduinoData);
        ArduinoData result = repository.recentData();

        assertThat(arduinoData).isEqualTo(result);
        assertThat(result).isNotNull();
        assertThat(result.getTime()).isEqualTo("12:00:00");
        assertThat(result.getTemp()).isEqualTo(1.0);
        assertThat(result.getHumi()).isEqualTo(1.0);
        assertThat(result.getDust()).isEqualTo(1.0);
    }

    @Test
    public void resentData(){
        ArduinoData arduinoData = new ArduinoData();
        arduinoData.setTime("12:00:00");
        arduinoData.setTemp(1.0);
        arduinoData.setHumi(1.0);
        arduinoData.setDust(1.0);


    }
}
