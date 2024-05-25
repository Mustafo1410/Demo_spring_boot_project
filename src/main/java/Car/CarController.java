package Car;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/car")
public class CarController implements CarInterface<Integer,Car>{
private final CarServiceSimple  carServiceSimple;
    @Override
    @PostMapping("create")
    public Car create( @RequestBody Car car) {
        return carServiceSimple.create(car);
    }

    @Override
    @PutMapping("update")
    public Car update(@PathVariable Integer id, @RequestBody Car car) {
        return carServiceSimple.update(id, car);
    }

    @Override
    @DeleteMapping("delete")
    public Car delete(Integer id) {
        return carServiceSimple.delete(id);
    }

    @Override
    @GetMapping("get")
    public Car get(Integer id) {
        return carServiceSimple.get(id);
    }

    @Override
    @GetMapping("getAll")
    public List<Car> getAll() {
        return carServiceSimple.getAll();
    }
}
