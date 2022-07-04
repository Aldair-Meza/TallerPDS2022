package co.com.poli.tallerpds.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "404 Not Found")
public class NotFoundException extends RuntimeException{
}