package pl.dk.m3trics;

import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorites")
class FavoritesNumberController {

    private final GaugeService gaugeService;

    FavoritesNumberController(GaugeService gaugeService) {
        this.gaugeService = gaugeService;
    }

    @GetMapping
    void favoriteNumber(@RequestParam Double number) {
      gaugeService.submit("favoriteNumber", number);
    }
}
