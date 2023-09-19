package br.com.vinidev;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinidev.converters.NumberConverter;
import br.com.vinidev.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping(path = "/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);

	}
	
	@GetMapping(path = "/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}

		return NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);

	}

	

}
