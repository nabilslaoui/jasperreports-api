package fr.nabilslaoui.enterprise.composition.boostrap.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.nabilslaoui.enterprise.commun.bo.Result;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Getter
	@Setter
	@ToString
	public static class ValidationFieldError extends Exception {
		private static final long serialVersionUID = 1L;
		private final String field;
		private final String error;

		public ValidationFieldError(final String field, final String error) {
			this.field = field;
			this.error = error;
			this.setStackTrace(new StackTraceElement[] {});
		}
	}


	/**
	 * Formattage des erreurs de validation.
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Result<String>> methodArgumentNotValidException(final HttpServletRequest requestContext, final MethodArgumentNotValidException ex) {
		final BindingResult bindingResult = ex.getBindingResult();
		final Result<String> errorResult = new Result<>();
		errorResult.setHasBusinessError(true);
		errorResult.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResult.setUrl(requestContext.getRequestURL().toString());

		for (final ObjectError error : bindingResult.getAllErrors()) {
			if (error instanceof FieldError) {
				final var fErr = (FieldError) error;
				errorResult.getErrors().add(new ValidationFieldError(fErr.getField(), error.getDefaultMessage()));

			} else {
				errorResult.getErrors().add(new ValidationFieldError(null, error.getDefaultMessage()));
			}
		}
		log.error(errorResult.getErrors().toString());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
	}
}
