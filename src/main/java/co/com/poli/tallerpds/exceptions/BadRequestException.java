package co.com.poli.tallerpds.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "400 BadRequest")
public class BadRequestException  extends RuntimeException{
}
