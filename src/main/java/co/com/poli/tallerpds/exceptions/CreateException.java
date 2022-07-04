package co.com.poli.tallerpds.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CREATED, reason = "201 Create ")
public class CreateException extends RuntimeException{
}
