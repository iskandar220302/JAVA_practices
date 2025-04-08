package com.example.practic_16;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class HomeController {
    private final String API_URL = "https://open.er-api.com/v6/latest/";

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @PostMapping("/home")
    public String convertCurrency(
            @RequestParam double amount,
            @RequestParam String fromCurrency,
            @RequestParam String toCurrency,
            Model model) {
        double conversionRate = getConversionRate(fromCurrency, toCurrency);
        double result = amount * conversionRate;
        model.addAttribute("conversionResult", String.format("Результат: %.2f %s", result, toCurrency));
        return "home";
    }

    private double getConversionRate(String fromCurrency, String toCurrency) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + fromCurrency;
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response != null && response.containsKey("rates")) {
            Map<String, Double> rates = (Map<String, Double>) response.get("rates");
            if (rates.containsKey(toCurrency)) {
                return rates.get(toCurrency);
            }
        }
        return 1.0;
    }
}
