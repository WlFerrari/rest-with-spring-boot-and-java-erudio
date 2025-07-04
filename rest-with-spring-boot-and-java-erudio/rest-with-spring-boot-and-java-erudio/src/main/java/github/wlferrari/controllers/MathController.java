package github.wlferrari.controllers;

import github.wlferrari.exception.UnsupportedMathOperationExeception;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    // http:localhost:8082/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationExeception("Please set a numeric value");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private double convertToDouble(String strNumber) {
        if(strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationExeception("Please set a numeric value");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null ||  strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }

    // http:localhost:8082/math/multiple/3/5
    @RequestMapping("/multiple/{numberOne}/{numberTwo}")
    public double multiple(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationExeception("Please set a numeric value");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    // http:localhost:8082/math/subtraction/10/2
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationExeception("Please set a numeric value");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    // http:localhost:8082/math/div/10/5
    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationExeception("Please set a numeric value");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    // http:localhost:8082/math/med/3/5
    @RequestMapping("/med/{numberOne}/{numberTwo}")
    public double medium(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationExeception("Please set a numeric value");
        return sum(numberOne, numberTwo) / 2;
    }

    // http:localhost:8082/math/square/5
    @RequestMapping("/square/{numberOne}")
    public double square(
            @PathVariable("numberOne") String numberOne
    ) throws Exception {
        if(!isNumeric(numberOne))
            throw new UnsupportedMathOperationExeception("Please set a numeric value");
        return Math.sqrt(convertToDouble(numberOne));
    }
}
