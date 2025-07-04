package github.wlferrari.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String description) {}
