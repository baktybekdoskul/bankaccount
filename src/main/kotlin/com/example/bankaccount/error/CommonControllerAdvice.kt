package com.example.bankaccount.error

import mu.KotlinLogging
import net.logstash.logback.argument.StructuredArguments.keyValue
import org.apache.commons.lang3.exception.ExceptionUtils
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.UUID
import javax.servlet.http.HttpServletRequest
import javax.validation.ConstraintViolationException

private val logger = KotlinLogging.logger {}

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class CommonControllerAdvice {
    @ExceptionHandler(Exception::class)
    fun handleExceptions(req: HttpServletRequest, exception: Exception): ResponseEntity<ErrorModel> {
        return when (exception) {
            is HttpMessageNotReadableException -> handleBadRequest(req, exception)
            is MissingServletRequestParameterException -> handleBadRequest(req, exception)
            is MethodArgumentNotValidException -> handleArgumentNotValidException(req, exception)
            is ConstraintViolationException -> handleBadRequest(req, exception)
            else -> handleUnknownException(req, exception)
        }
    }

    private fun handleBadRequest(req: HttpServletRequest, exception: Exception): ResponseEntity<ErrorModel> {
        val id = UUID.randomUUID()
        log(exception, id)
        val error = ErrorModel(
            id = id,
            status = Error.BAD_REQUEST.httpStatus,
            error = Error.BAD_REQUEST.text,
            code = Error.BAD_REQUEST,
            detail = getDetail(exception)
        )
        return ResponseEntity(error, error.status)
    }

    private fun handleArgumentNotValidException(req: HttpServletRequest, exception: MethodArgumentNotValidException): ResponseEntity<ErrorModel> {
        val id = UUID.randomUUID()
        log(exception, id)
        val error = ErrorModel(
            id = id,
            status = Error.BAD_REQUEST.httpStatus,
            error = "invalid.request",
            code = Error.BAD_REQUEST,
            detail = getDetail(exception)
        )
        return ResponseEntity(error, error.status)
    }

    private fun handleUnknownException(req: HttpServletRequest, exception: Exception): ResponseEntity<ErrorModel> {
        val id = UUID.randomUUID()
        log(exception, id)
        val error = ErrorModel(
            id = id,
            status = Error.UNKNOWN_ERROR.httpStatus,
            error = Error.UNKNOWN_ERROR.text,
            code = Error.UNKNOWN_ERROR,
            detail = getDetail(exception)
        )
        return ResponseEntity(error, error.status)
    }

    private fun log(ex: Exception, id: UUID, isWarn: Boolean = false) {
        val errorName = when (ex) {
            is CommonException -> ex.error.name
            else -> Error.UNKNOWN_ERROR.name
        }
        if (isWarn) logger.warn(ex.message, keyValue("id", id.toString()), keyValue("code", errorName), ex)
        else logger.error(ex.message, keyValue("id", id.toString()), keyValue("code", errorName), ex)
    }

    private fun getDetail(ex: Exception) = "Error: ${ex.message}\n" +
        "StackTrace: ${ExceptionUtils.getStackTrace(ex)}"
}
